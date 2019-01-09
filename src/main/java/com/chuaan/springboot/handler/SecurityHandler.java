package com.chuaan.springboot.handler;

import com.chuaan.springboot.account.Admin;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器 目前打算用来确保用户权限
 * author:chuaan
 * created:2019-01-03
 */

public class SecurityHandler implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {

        //基本代码都来源于LoginController的get里面，应该是把这里复用起来，但是demo就多走一步算了
        Admin admin = (Admin) request.getSession().getAttribute("Current_Admin");
        if (admin == null) {
            response.sendRedirect("/redirect?next=" + request.getRequestURI());
            return false;

        } else if (admin.getAdmin() >= Admin.REJECT) {
            response.sendRedirect("/no_authority");
            return false;
        }

        return true;

    }

}
