package com.slfx.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * RequestBody的封装分析
 * @author slfx
 *
 */
@Controller
public class ParameterController4 {

    /**
     * 请求参数封装的分析
     * @param body
     */
    @RequestMapping("/testParam4")
    public void testParam(@RequestBody String body){
        System.out.println(body);
    }

}
