package com.cungudafa.spingmvc01.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cungudafa.spingmvc01.bean.UserInfo;

@RestController
@RequestMapping("/rest")
public class RestfulController {
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/index")
	public @ResponseBody UserInfo index(HttpSession session){
		UserInfo user = new UserInfo();
		user.setUserId(10001);
		user.setUserName("张三");
		user.setUserPassword("abc123");
		return user;
	}
}
