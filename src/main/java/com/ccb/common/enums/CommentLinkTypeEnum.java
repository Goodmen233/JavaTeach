package com.ccb.common.enums;

import java.util.Objects;

/**
 * @Description: 评论关联类型枚举
 * @Author: CCB
 * @Date: 2023/2/14 10:13
 */
public enum CommentLinkTypeEnum implements IEnum {

    /**
     * 讨论
     */
    STUDENT(0, "讨论"),

    /**
     * 分享
     */
    TEACHER(1, "分享"),

    /**
     * 评论
     */
    COMMENT(2, "评论")

    ;

    public static final String KEY_VALUE = "{ " +
            "0-讨论 " +
            "1-分享 " +
            "2-评论 " +
            "}";

    CommentLinkTypeEnum(Integer index, String name) {
        this.index = index;
        this.name = name;
    }

    /**
     * 通过枚举值获取枚举
     *
     * @param index 枚举值
     * @return 枚举
     */
    public static CommentLinkTypeEnum getEnumByIndex(int index){
        for (CommentLinkTypeEnum e : CommentLinkTypeEnum.values()) {
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
