package com.slfx.web;

import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author slfx
 *
 */
public class ControllerDemo3 implements HttpRequestHandler {

    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("=====进入ControllerDemo3==handleRequest方法===");
        request.getRequestDispatcher("/WEB-INF/pages/success3.jsp").forward(request,response);
        return;
    }
}
