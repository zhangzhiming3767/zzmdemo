package com.example.zzmdemo.shiro;

import com.example.zzmdemo.entity.response.FailedResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.shiro.web.filter.authc.UserFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/***
 * 拦截失败后返回json对象给前台 ，而不是默认跳转到登录页方便ajax统一处理.
 * @author pzy
 *
 */
public class MyUserFilter extends UserFilter {

    /**
     * @param request  request
     * @param response response
     * @return boolean
     * @throws Exception Exception
     */
    @Override
    protected boolean onAccessDenied(
            final ServletRequest request,
            final ServletResponse response) throws Exception {
//        HttpServletResponse httpServletResponse
//                = (HttpServletResponse) response;
//        httpServletResponse.setStatus(
//                HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("application/json; charset=utf-8");
//        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(
//                new FailedResponse("-400", "session超时 未登录！"));
//        httpServletResponse.getWriter().write(json);
        return false;
    }
}
