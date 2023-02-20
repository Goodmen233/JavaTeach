package com.ccb.filter;

import com.alibaba.fastjson.JSON;
import com.ccb.common.utils.RedisUtil;
import com.ccb.domain.common.ResultInfo;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Description: 判断请求头里面是否有登录的token信息，有的话进行判定，有效才放行
 * @Author: CCB
 * @Date: 2023/2/10 11:18
 */
@Slf4j
@WebFilter(urlPatterns = {"/file/*", "/teacher/*", "/student/*", "/common/*", "/audit/*"})
public class LoginFilter extends HttpFilter {

    private static final long serialVersionUID = 6403614881115304399L;

    /**
     * 判断登录状态
     *
     * @param req 请求
     * @param resp 响应
     * @param chain 过滤器链
     * @throws IOException IO异常
     * @throws ServletException Servlet异常
     */
    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
        String token = req.getHeader("token");
        if (! RedisUtil.containsValueKey(token)) {
            log.error("[{}]请求中，登录状态过期", req.getRequestURI());
            PrintWriter writer=resp.getWriter();
            writer.write(JSON.toJSONString(ResultInfo.tokenError()));
            writer.flush();
            return;
        }
        chain.doFilter(req, resp);
    }

}
