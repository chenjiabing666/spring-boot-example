package com.slfx.web;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author slfx
 *
 */
public class ControllerDemo2 implements Controller {

    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        System.out.println("=====ControllerDemo2===handleRequest====");
       ModelAndView mv = new ModelAndView();
       mv.setViewName("success2");
       mv.addObject("hello","你好");
        return mv;
    }
}
