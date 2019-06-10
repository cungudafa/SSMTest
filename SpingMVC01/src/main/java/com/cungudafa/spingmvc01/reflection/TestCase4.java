package com.cungudafa.spingmvc01.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.cungudafa.spingmvc01.bean.UserInfo;

/**
 * Constructor
 * @author Administrator
 *
 */
public class TestCase4 {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class c = 
				Class.forName("com.cungudafa.spingmvc01.bean.UserInfo");//c-->UserInfo
		
		//获取UserInfo类上无参的构造方法
		Constructor con = c.getDeclaredConstructor();
		//创建UserInfo类的对象
		UserInfo userInfo = (UserInfo)con.newInstance();
		
		//获取UserInfo类上有参(String,String)的构造方法
		Constructor con1 = c.getDeclaredConstructor(String.class,String.class);
		UserInfo userInfo1 = (UserInfo)con1.newInstance("张三","abc123");
		
		Method getUserName = c.getDeclaredMethod("getUserName");
		System.out.println("userInfo1.getUserName = " 
		+ getUserName.invoke(userInfo1));
		
		Method getUserPassword = c.getDeclaredMethod("getUserPassword");
		System.out.println("userInfo1.getUserPassword = " 
				+ getUserPassword.invoke(userInfo1));
	}
}



