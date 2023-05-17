package com.slfx.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private HelloController helloController;
	
	public UserService() {
		System.out.println("UserService Constructor...helloController:"+helloController);
	}
	
}
