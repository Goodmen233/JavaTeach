package com.ccb.common.utils;

import com.ccb.domain.common.PageBO;

import java.util.Objects;

/**
 * @Description: 分页工具
 * @Author: CCB
 * @Date: 2023/3/27 15:25
 */
public class PageUtil {

    public static void checkPage(PageBO pageBO) {
        if (Objects.isNull(pageBO.getPageNo())) {
            pageBO.setPageNo(0);
        }
        if (Objects.isNull(pageBO.getPageSize())) {
            pageBO.setPageSize(15);
        }
    }

}
