package com.cungudafa.spingmvc01.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.cungudafa.spingmvc01.bean.UserInfo;

/**
 * Method
 * @author Administrator
 *
 */
public class TestCase3 {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class c = 
		Class.forName("com.cungudafa.spingmvc01.bean.UserInfo");//c-->UserInfo
		c = UserInfo.class;
		
		Method m = c.getDeclaredMethod("getUserId");//m-->UserInfo.getUserId
		System.out.println("m = " + m);
		
		UserInfo userInfo = (UserInfo)c.newInstance();
		userInfo.setUserId(1001);
		System.out.println("userInfo.getUserId = " + userInfo.getUserId());
		Object value = m.invoke(userInfo);//-->userInfo.getUserId();
		System.out.println("userInfo.getUserId = " + value);
		
		//UserInfo.setUserId(Integer id);
		Method m1 = c.getDeclaredMethod("setUserId", Integer.class);
		m1.invoke(userInfo, 1002);//userInfo.setUserId(1002);
		value = m.invoke(userInfo);//-->userInfo.getUserId();
		System.out.println("after userInfo.getUserId = " + value);
		
		
		//UserInfo.show(String s1,String s2,Integer i3);
		Method m3 = c.getDeclaredMethod("show", String.class,String.class,Integer.class);
		Object value1 = m3.invoke(userInfo, "hello " ,"world ",10000);
		System.out.println("value1 = " + value1);
		
		//获取UserInfo类上所有的方法
		Method[] methods = c.getDeclaredMethods();
		for(Method method : methods){
			System.out.println("method = " + method);
		}
	}
}
