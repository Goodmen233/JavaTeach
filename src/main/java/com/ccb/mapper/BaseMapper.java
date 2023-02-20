package com.ccb.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Description: tkMapper基础类
 * @Author: CCB
 * @Date: 2023/2/20 16:46
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
