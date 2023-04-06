package com.ccb.service.impl;

import com.ccb.context.ApplicationContext;
import com.ccb.domain.bo.ExerciseDetailBO;
import com.ccb.domain.bo.StudentProblemBO;
import com.ccb.domain.po.ProblemPO;
import com.ccb.domain.po.StudentProblemPO;
import com.ccb.domain.vo.req.student.ExerciseSubmitReq;
import com.ccb.domain.vo.resp.student.ExerciseDetailResp;
import com.ccb.mapper.ProblemMapper;
import com.ccb.mapper.StudentProblemMapper;
import com.ccb.service.StudentProblemService;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Description: 学生问题服务实现
 * @Author: CCB
 * @Date: 2023/4/6 14:00
 */
@Service
@RequiredArgsConstructor
public class StudentProblemServiceImpl implements StudentProblemService {

    private StudentProblemMapper studentProblemMapper;

    private ProblemMapper problemMapper;

    @Override
    public void exerciseSubmit(ExerciseSubmitReq exerciseSubmitReq) {
        List<StudentProblemPO> answerList = exerciseSubmitReq.getAnswerList();
        List<StudentProblemPO> insertAnswer = answerList.stream().filter(t -> Objects.isNull(t.getId())).collect(Collectors.toList());
        List<StudentProblemPO> updateAnswer = answerList.stream().filter(t -> !Objects.isNull(t.getId())).collect(Collectors.toList());
        studentProblemMapper.insertList(insertAnswer);
        updateAnswer.forEach(t -> {
            studentProblemMapper.updateByPrimaryKey(t);
        });
    }

    @Override
    public ExerciseDetailResp queryExerciseDetail(Long id) {
        ExerciseDetailResp exerciseDetailResp = new ExerciseDetailResp();
        exerciseDetailResp.setExerciseId(id);

        ProblemPO problemPO = new ProblemPO();
        problemPO.setExerciseId(id);
        List<ProblemPO> problemPOList = problemMapper.queryProblem(problemPO);

        StudentProblemBO studentProblemBO = new StudentProblemBO();
        List<Long> problemIdList = problemPOList.stream().map(ProblemPO::getId).collect(Collectors.toList());
        studentProblemBO.setStudentId(ApplicationContext.getUser().getId());
        studentProblemBO.setProblemIdList(problemIdList);
        List<StudentProblemPO> studentProblemPOList = studentProblemMapper.queryStudentProblem(studentProblemBO);
        Map<Long, String> problemId2AnswerMap = studentProblemPOList.stream().collect(Collectors.toMap(StudentProblemPO::getProblemId, StudentProblemPO::getAnswer));

        List<ExerciseDetailBO> exerciseDetailBOList = Lists.newArrayList();
        problemPOList.forEach(t -> {
            ExerciseDetailBO exerciseDetailBO = new ExerciseDetailBO();
            exerciseDetailBO.setProblemId(t.getId());
            exerciseDetailBO.setProblemContent(t.getContent());
            exerciseDetailBO.setRightAnswer(t.getAnswer());
            exerciseDetailBO.setStudentAnswer(problemId2AnswerMap.get(t.getId()));
            exerciseDetailBOList.add(exerciseDetailBO);
        });

        exerciseDetailResp.setExerciseDetailBOList(exerciseDetailBOList);
        return exerciseDetailResp;
    }
}
