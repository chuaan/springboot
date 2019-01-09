package com.chuaan.springboot.service.account;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * author:chuaan
 * created:2019-01-07
 */

@Service
public class UserAlert {
    /*
    //找不到这个用户名或者密码错误
    public void noSuchUser(HttpServletResponse response){
        try {
            response.setCharacterEncoding("utf-8");
            PrintWriter out = response.getWriter();
            out.print("<script>alert('登录失败 login error');window.location='login'</script>");
            out.flush();
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //密码修改失败
    public void errorPasswordChange(HttpServletResponse response){
        try {
            response.setCharacterEncoding("utf-8");
            PrintWriter out = response.getWriter();
            out.print("<script>alert('Password change error');window.location='mainpage'</script>");
            out.flush();
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
*/
    //根据传递的message来提示
    public void userAlert(HttpServletResponse response, String alertMessage, String nextPageMessage){
        try {
            response.setCharacterEncoding("utf-8");
            PrintWriter out = response.getWriter();
            out.print("<script>alert('"+alertMessage+"');window.location='"+nextPageMessage+"'</script>");
            out.flush();
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
