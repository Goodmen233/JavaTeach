package com.ccb.common.enums;

import java.util.Objects;

/**
 * @Description: 题目类型枚举
 * @Author: CCB
 * @Date: 2023/2/14 11:15
 */
public enum ProblemTypeEnum implements IEnum {

    /**
     * 单选
     */
    SIMPLE_CHOICE(0, "单选"),

    /**
     * 多选
     */
    MULTI_CHOICE(1, "多选"),

    /**
     * 判断
     */
    JUDGE(2, "判断"),

    /**
     * 填空
     */
    FILL_BLANK(3, "填空")

    ;

    public static final String KEY_VALUE = "{ " +
            "0-单选 " +
            "1-多选 " +
            "2-判读 " +
            "3-填空 " +
            "}";

    ProblemTypeEnum(Integer index, String name) {
        this.index = index;
        this.name = name;
    }

    /**
     * 通过枚举值获取枚举
     *
     * @param index 枚举值
     * @return 枚举
     */
    public static ProblemTypeEnum getEnumByIndex(int index){
        for (ProblemTypeEnum e : ProblemTypeEnum.values()) {
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
