package com.cungudafa.spingmvc01.reflection;

import com.cungudafa.spingmvc01.bean.UserInfo;

public class TestCase1 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class c = Class.forName("com.cungudafa.spingmvc01.bean.UserInfo");
		System.out.println("c = " + c);//c->UserInfo的运行时类
		String className = c.getName();
		System.out.println("classname = " + className);
		System.out.println("modifiers = " + c.getModifiers());
		
		Object o = c.newInstance();//创建了一个c->UserInfo类的对象  UserInfo u = new UserInfo();
		if(o instanceof UserInfo){
			System.out.println("yes");
		}else{
			System.out.println("no");
		}
		UserInfo userInfo = (UserInfo)o;
	}
}
