package com.poverty.filter;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/4/11 10:57
 */
@Component
public class CorsFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        // 设置请求编码，解决中文乱码
        request.setCharacterEncoding("UTF-8");

        // 设置响应编码，解决中文乱码
        response.setContentType("test/html;charset=UTF-8");
        //Filter过滤器跨域处理
        //设置请求方式为http 的rest 风格
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE");
        // 允许客户端携带跨域cookie
        // 当Access-Control-Allow-Credentials设为true的时候，Access-Control-Allow-Origin不能设为星号
        response.setHeader("Access-Control-Allow-Credentials", "true");
        // 允许指定域访问跨域资源
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        // 允许浏览器发送的请求消息头
        response.setHeader("Access-Control-Allow-Headers", request.getHeader("Access-Control-Request-Headers"));
        // 允许浏览器在预检请求成功之后发送的实际请求方法名
        response.setHeader("Access-Control-Allow-Methods", request.getHeader("Access-Control-Request-Method"));
        // 设置响应数据格式
        response.setHeader("Content-Type", "application/json");
        // 跨域时会首先发送一个option请求，这里我们给option请求直接返回正常状态
        if (request.getMethod().equals(RequestMethod.OPTIONS.name())) {
            response.setStatus(HttpStatus.OK.value());
            return;
        }
        filterChain.doFilter(request, response);
    }
}
