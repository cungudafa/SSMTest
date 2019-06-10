package com.cungudafa.mymvc.controller;

import com.cungudafa.mymvc.annotation.MyController;
import com.cungudafa.mymvc.annotation.MyRequestMapping;

@MyController
@MyRequestMapping("/clazz")
public class ClazzInfoController {
	
	@MyRequestMapping("/index")
	public String index(){
		return "user";
	}
}
