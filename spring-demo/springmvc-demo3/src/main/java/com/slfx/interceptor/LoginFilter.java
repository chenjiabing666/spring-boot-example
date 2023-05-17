/**
 * 
 */
package com.slfx.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


/**
 * 定义拦截器，用于判断用户是否登录，如果用户已经登录则放行，否则用户未登录则跳转至登录页面
 */
public class LoginFilter extends HandlerInterceptorAdapter {


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		System.out.println("==============LoginFilter===preHandle=========");
		return true;

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		System.out.println("==============LoginFilter===postHandle=========");
	}
}
