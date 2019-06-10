package com.cungudafa.mymvc.controller;

import javax.servlet.http.HttpServletRequest;

import com.cungudafa.mymvc.annotation.MyController;
import com.cungudafa.mymvc.annotation.MyRequestMapping;
import com.cungudafa.mymvc.annotation.MyResponseBody;

@MyController
@MyRequestMapping("/user")
public class UserInfoController {
	
	@MyRequestMapping("/index")
	@MyResponseBody 
	public String index(HttpServletRequest req){
		String name = req.getParameter("name");
		System.out.println("UserInfoController index...");
		System.out.println("name = " + name);
		return "index";
	}
}