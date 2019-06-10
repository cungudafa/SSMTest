package com.cungudafa.annotation.test;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Class Method Field Constructor .getAnnotation(Class class)
 * @author Administrator
 *
 */
public class TestCase03 {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException {
		//一、获取Son类上的@RequestMapping注解
		//1.获取Son的运行时类
		Class c = Class.forName("com.cungudafa.annotation.test.Son");
		//2.判断Son类上是否有@RequestMapping注解
		if(c.isAnnotationPresent(RequestMapping.class)){
			//3.如果有，则获取Son类上的@RequestMapping注解
//			Annotation a = c.getAnnotation(RequestMapping.class);
			RequestMapping rm = 
					(RequestMapping) c.getAnnotation(RequestMapping.class);
			System.out.println("rm = " + rm);
			//获取该注解上的value值
			String[] value = rm.value();
			System.out.println("value = " + value[0]);
		}
		
		//二、获取doSth方法上的@RequestMapping注解的value值
		Method doSth = c.getDeclaredMethod("doSth");
		if(doSth.isAnnotationPresent(RequestMapping.class)){
			RequestMapping rm = doSth.getAnnotation(RequestMapping.class);
			String[] value = rm.value();
			System.out.println("value = " + value[0]);
		}
	}
}



