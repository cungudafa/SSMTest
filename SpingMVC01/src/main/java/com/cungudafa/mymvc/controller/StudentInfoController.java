package com.cungudafa.mymvc.controller;

import com.cungudafa.mymvc.annotation.MyController;
import com.cungudafa.mymvc.annotation.MyRequestMapping;

@MyController
@MyRequestMapping("/student")
public class StudentInfoController {
	
	@MyRequestMapping("/index")
	public String index(){
		return "index";
	}
}
