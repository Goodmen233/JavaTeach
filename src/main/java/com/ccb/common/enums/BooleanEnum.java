package com.ccb.common.enums;

import java.util.Objects;

/**
 * @Description: 是否枚举
 * @Author: CCB
 * @Date: 2023/2/9 13:43
 */
public enum BooleanEnum implements IEnum {

    /**
     * 是
     */
    YES(0, "是"),

    /**
     * 否
     */
    NO(1, "否")

    ;

    public static final String KEY_VALUE = "{ " +
            "0-是 " +
            "1-否 " +
            "}";

    BooleanEnum(Integer index, String name) {
        this.index = index;
        this.name = name;
    }

    /**
     * 通过枚举值获取枚举
     *
     * @param index 枚举值
     * @return 枚举
     */
    public static BooleanEnum getEnumByIndex(int index){
        for (BooleanEnum e : BooleanEnum.values()) {
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
