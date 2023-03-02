package com.ccb.common.utils;

import java.util.Collection;

/**
 * @Description: 集合工具类
 * @Author: CCB
 * @Date: 2023/3/2 16:55
 */
public class CollectionUtil {

    private CollectionUtil() {}

    public static <T> boolean isSingleElement(Collection<T> collection) {
        return collection != null && collection.size() == 1;
    }
}
