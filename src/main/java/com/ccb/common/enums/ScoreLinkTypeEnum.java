package com.ccb.common.enums;

import java.util.Objects;

/**
 * @Description: 成绩关联类型枚举
 * @Author: CCB
 * @Date: 2023/2/14 14:07
 */
public enum ScoreLinkTypeEnum implements IEnum {

    /**
     * 课程成绩
     */
    SOURCE(0, "课程"),

    /**
     * 作业成绩
     */
    EXERCISE(1, "作业"),

    /**
     * 选课，暂无成绩
     */
    CHOOSE(99, "选课")

    ;

    public static final String KEY_VALUE = "{ " +
            "0-课程 " +
            "1-作业 " +
            "}";

    ScoreLinkTypeEnum(Integer index, String name) {
        this.index = index;
        this.name = name;
    }

    /**
     * 通过枚举值获取枚举
     *
     * @param index 枚举值
     * @return 枚举
     */
    public static ScoreLinkTypeEnum getEnumByIndex(int index){
        for (ScoreLinkTypeEnum e : ScoreLinkTypeEnum.values()) {
            if (Objects.equals(index, e.getIndex())) {
                return e;
            }
        }
        return null;
    }

    private Integer index;

    private String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Integer getIndex() {
        return index;
    }
}
