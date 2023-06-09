package com.slfx.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * RequestParam的封装分析
 * @author slfx
 *
 */
@Controller
public class ParameterController2 {

    /**
     * 请求参数封装的分析
     * @param name
     * @param age
     */
    @RequestMapping("/testParam2")
    public String testParam(@RequestParam("username") String name, Integer age){
        System.out.println(name+","+age);
        return "success";
    }

}
