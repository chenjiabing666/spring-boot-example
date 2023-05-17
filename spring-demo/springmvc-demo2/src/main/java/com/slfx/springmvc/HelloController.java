package com.slfx.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@Autowired
	private UserService userService;
	
	public HelloController() {
		System.out.println("HelloWorld Constructor...");
	}
	
	@RequestMapping("/helloworld")
	public String hello(){
		System.out.println("success");
		System.out.println(userService);
		return "success";
	}
	
}
