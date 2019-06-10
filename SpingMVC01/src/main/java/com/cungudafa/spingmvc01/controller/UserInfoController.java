package com.cungudafa.spingmvc01.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cungudafa.spingmvc01.bean.UserInfo;

/*
 * 一个控制器
 * @author Administrator 
 * 
 */
@Controller
@RequestMapping("/")
public class UserInfoController {
	
	@RequestMapping(value="index")
	public String userIndex(String userName,String userPassword){
	System.out.println("添加操作的业务逻辑:"+userName+" "+userPassword);
	return "user";
	}

	@RequestMapping("login")
	public String login(){
		return "login";
	}
	@RequestMapping(value="dologin")
	public String login(UserInfo a,HttpSession session){
		System.out.println("用户:"+a.getUserName()+"\t密码："+a.getUserPassword());
		session.setAttribute("user", a);
		return "user";
	}
	@RequestMapping("index1")
	public void index1(HttpServletResponse response){
		try {
			response.sendRedirect("/SpingMVC01/index.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("index2")
	public void index2(HttpServletResponse response){
		try {
			PrintWriter out = response.getWriter();
			out.println("hello");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("index301")
	public String index301(){
		return "user";
	}
	@RequestMapping("index302")
	public @ResponseBody String index302(){
		return "user";
	}
	
	@RequestMapping("student/{id}")
	public String find(@PathVariable("id") Integer id,HttpSession session){
		System.out.println("id = " + id);
		session.setAttribute("id", id);
		return "user";
	}
	
}
