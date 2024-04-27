package com.ccb.common.enums;

import java.util.Objects;

/**
 * @Description: 用户类型枚举
 * @Author: CCB
 * @Date: 2023/2/14 09:48
 */
public enum UserTypeEnum implements IEnum {

    /**
     * 学生
     */
    STUDENT(0, "学生"),

    /**
     * 教师
     */
    TEACHER(1, "教师")

    ;

    public static final String KEY_VALUE = "{ " +
            "0-学生 " +
            "1-教师 " +
            "}";

    UserTypeEnum(Integer index, String name) {
        this.index = index;
        this.name = name;
    }

    /**
     * 通过枚举值获取枚举
     *
     * @param index 枚举值
     * @return 枚举
     */
    public static UserTypeEnum getEnumByIndex(int index){
        for (UserTypeEnum e : UserTypeEnum.values()) {
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
