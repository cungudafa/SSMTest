package com.cungudafa.annotation.test;


import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Class Method Field Constructor .isAnnotationPresent(Class class)
 * @author Administrator
 *
 */
public class TestCase02 {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, NoSuchFieldException {
		
		Class c = Class.forName("com.cungudafa.annotation.test.Son");
		
		//c-->Son类，检测Son类上是否有@Controller类型的注解
		boolean flag = c.isAnnotationPresent(Controller.class);
		System.out.println("flag = " + flag);
		flag = c.isAnnotationPresent(Override.class);
		System.out.println("flag = " + flag);
		flag = c.isAnnotationPresent(RequestMapping.class);
		System.out.println("flag = " + flag);
		
		//doSth-->Son类中的doSth()方法
		Method doSth = c.getDeclaredMethod("doSth");
		//判断Son类中的doSth()方法是否有@RequestMapping类型的注解
		flag = doSth.isAnnotationPresent(RequestMapping.class);
		System.out.println("doSth 2RequestMapping = " + flag);
		
		//通过运行时类c拿到名为name的成员变量
		Field name = c.getDeclaredField("name");
		flag = name.isAnnotationPresent(Resource.class);
		System.out.println("name @Resource = " + flag);
	}
}




