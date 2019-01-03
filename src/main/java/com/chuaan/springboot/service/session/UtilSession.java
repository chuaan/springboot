package com.chuaan.springboot.service.session;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;

/**
 * 一些专门用来处理session的functions
 * author:chuaan
 * created:2019-01-03
 */

@Service
public class UtilSession {

    //清空session
    public void clean(HttpSession session){
        Enumeration<String> attributes = session.getAttributeNames();
        while(attributes.hasMoreElements()){
            session.removeAttribute(attributes.nextElement());
        }
    }
}
