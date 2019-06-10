package com.cungudafa.annotation.test;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/xxxxxxxxxx")
public class Son extends Father{
	
	@Resource
	private String name;
	
	@RequestMapping("/yyyyyyyyyyy")
	@Override
	public void doSth(){
		
	}

}
