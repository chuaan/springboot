package com.chuaan.springboot.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * author:chuaan
 * created:2018-12-29
 */

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e){
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception",e);
        mav.addObject("url", req.getRequestURI());
        mav.setViewName("web/errorPage");
        return mav;
    }
}
