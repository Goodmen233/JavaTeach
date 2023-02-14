package com.ccb.common.enums;

import java.util.Objects;

/**
 * @Description: 文件关联类型枚举
 * @Author: CCB
 * @Date: 2023/2/14 10:24
 */
public enum FileLinkTypeEnum implements IEnum {

    /**
     * 人物头像
     */
    USER_AVATAR(0, "人物头像"),

    /**
     * 课程封面
     */
    COURSE_COVER(1, "课程封面"),

    /**
     * 章节内容
     */
    CHAPTER_CONTENT(2, "章节内容"),

    /**
     * 课程资料
     */
    COURSE(3, "课程资料")

    ;

    public static final String KEY_VALUE = "{ " +
            "0-人物头像 " +
            "1-课程封面 " +
            "2-章节内容 " +
            "3-课程资料 " +
            "}";

    FileLinkTypeEnum(Integer index, String name) {
        this.index = index;
        this.name = name;
    }

    /**
     * 通过枚举值获取枚举
     *
     * @param index 枚举值
     * @return 枚举
     */
    public static FileLinkTypeEnum getEnumByIndex(int index){
        for (FileLinkTypeEnum e : FileLinkTypeEnum.values()) {
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
