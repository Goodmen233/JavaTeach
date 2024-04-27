package com.ccb.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.ccb.common.enums.ScoreLinkTypeEnum;
import com.ccb.common.enums.UserTypeEnum;
import com.ccb.common.utils.CollectionUtil;
import com.ccb.context.ApplicationContext;
import com.ccb.domain.bo.ExerciseBO;
import com.ccb.domain.bo.ExerciseQueryBO;
import com.ccb.domain.bo.ProblemBO;
import com.ccb.domain.bo.User;
import com.ccb.domain.common.PageResp;
import com.ccb.domain.po.ChoicePO;
import com.ccb.domain.po.ExercisePO;
import com.ccb.domain.po.ProblemPO;
import com.ccb.domain.po.StudentScorePO;
import com.ccb.domain.vo.req.teacher.ExercisePublishReq;
import com.ccb.mapper.ChoiceMapper;
import com.ccb.mapper.ExerciseMapper;
import com.ccb.mapper.ProblemMapper;
import com.ccb.mapper.StudentScoreMapper;
import com.ccb.service.ExerciseService;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Description: 作业/练习服务实现
 * @Author: CCB
 * @Date: 2023/3/28 20:12
 */
@Service
@RequiredArgsConstructor
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseMapper exerciseMapper;

    private final StudentScoreMapper studentScoreMapper;

    private final ProblemMapper problemMapper;

    private final ChoiceMapper choiceMapper;

    @Override
    public PageResp<ExerciseBO> queryExercise(ExerciseQueryBO exerciseQueryBO) {
        PageResp<ExerciseBO> pageResp = new PageResp<>();
        List<ExercisePO> exercisePOList = exerciseMapper.queryExercise(exerciseQueryBO);
        List<ExerciseBO> exerciseBOList = new ArrayList<>();
        exercisePOList.forEach(t -> {
            ExerciseBO exerciseBO = new ExerciseBO();
            BeanUtils.copyProperties(t, exerciseBO);
            User user = ApplicationContext.getUser();
            StudentScorePO studentScorePO = new StudentScorePO();
            if (Objects.equals(user.getUserType(), UserTypeEnum.STUDENT.getIndex())) {
                // 学生-统计完成情况
                studentScorePO.setStudentId(user.getId());
                studentScorePO.setLinkId(t.getId());
                List<StudentScorePO> studentScorePOS = studentScoreMapper.queryStudentScore(studentScorePO);
                if (CollectionUtil.isEmpty(studentScorePOS)) {
                    exerciseBO.setMark("未完成");
                } else {
                    exerciseBO.setMark("已完成");
                }
            } else {
                // 老师-完成人数/班级人数
                studentScorePO.setLinkId(t.getId());
                List<StudentScorePO> studentScorePOS = studentScoreMapper.queryStudentScore(studentScorePO);
                int total = studentScorePOS.size();
                studentScorePOS = studentScorePOS.stream().filter(p -> Objects.equals(p.getLinkType(), ScoreLinkTypeEnum.EXERCISE.getIndex())).collect(Collectors.toList());
                int count = studentScorePOS.size();
                exerciseBO.setMark(count + "/" + total);
            }
        });
        pageResp.setRows(exerciseBOList);
        pageResp.setTotal(exerciseMapper.countExercise(exerciseQueryBO));
        return pageResp;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveExercise(ExercisePublishReq exercisePublishReq) {
        // 保存练习
        ExercisePO exercisePO = new ExercisePO();
        BeanUtil.copyProperties(exercisePublishReq, exercisePO);
        if (Objects.isNull(exercisePO.getId())) {
            exerciseMapper.insertSelective(exercisePO);
        } else {
            exerciseMapper.updateByPrimaryKey(exercisePO);
        }
        // 保存题目
        List<ChoicePO> choicePOList = Lists.newArrayList();
        List<ProblemBO> problemList = exercisePublishReq.getProblemList();
        problemList.forEach(t -> {
            ProblemPO problemPO = new ProblemPO();
            BeanUtil.copyProperties(t, problemPO);
            problemPO.setExerciseId(exercisePO.getId());
            problemMapper.insertSelective(problemPO);
            // 保存选项
            t.getChoiceList().forEach(choice -> {
                ChoicePO choicePO = new ChoicePO();
                BeanUtil.copyProperties(choice, choicePO);
                choicePO.setLinkId(problemPO.getId());
                choicePOList.add(choicePO);
            });
        });
        choiceMapper.insertList(choicePOList);
    }
}
