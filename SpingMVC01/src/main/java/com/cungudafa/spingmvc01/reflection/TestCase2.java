package com.cungudafa.spingmvc01.reflection;

import java.lang.reflect.Field;

import com.cungudafa.spingmvc01.bean.UserInfo;

/**
 * Field
 * @author Administrator
 *
 */
public class TestCase2 {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException, InstantiationException, IllegalAccessException {
		Class c = Class.forName("com.cungudafa.spingmvc01.bean.UserInfo");//c-->UserInfo
		Field f = c.getDeclaredField("userName");//获取到UserInfo类的名为userName的字段（成员变量）
		//f-->UserInfo.userName
		UserInfo userInfo = (UserInfo)c.newInstance();
		userInfo.setUserName("张三");
		//获得userInfo上userName的值
		System.out.println("userName = " + userInfo.getUserName());
		//修改成员变量的访问控制权限
		f.setAccessible(true);
		System.out.println("userName = " + f.get(userInfo));
		//给userInfo的userName赋值
		f.set(userInfo, "李四");
		System.out.println("after userName = " + f.get(userInfo));
		
		
		
		//返回UserInfo类上所有的成员变量
		Field[] fields = c.getDeclaredFields();
		for(Field field : fields){
			System.out.println("-------------");
			System.out.println(field);
		}
	}
}





