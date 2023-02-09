package com.ccb.common.enums;

import java.util.Objects;

/**
 * @Description: 审核枚举
 * @Author: CCB
 * @Date: 2023/2/9 13:51
 */
public enum AuditEnum implements IEnum {

    /**
     * 未审核
     */
    NO_AUDIT(0, "未审核"),

    /**
     * 审核通过
     */
    AUDIT_PASS(1, "审核通过"),

    /**
     * 审核失败
     */
    AUDIT_FAIL(2, "审核未通过")

    ;

    public static final String KEY_VALUE = "{ " +
            "0-未审核 " +
            "1-审核通过 " +
            "2-审核未通过 " +
            "}";

    AuditEnum(Integer index, String name) {
        this.index = index;
        this.name = name;
    }

    /**
     * 通过枚举值获取枚举
     *
     * @param index 枚举值
     * @return 枚举
     */
    public static AuditEnum getEnumByIndex(int index){
        for (AuditEnum e : AuditEnum.values()) {
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
