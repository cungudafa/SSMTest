package com.cungudafa.spingmvc01.reflection;

import org.springframework.web.servlet.DispatcherServlet;

public class Tomcat {
	
	/**
	 * 
	 * @param className org...DispatcherServlet,com...Servlet,....
	 * @return
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public Object createServlet(String className) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
//		if(className.equals("org.springframework.web.servlet.DispatcherServlet")){
//			return new DispatcherServlet();
//		}else if(className.equals("com.chinasfoti.,...Servlet")){
//			
//		}
		Class c = Class.forName(className);
		return c.newInstance();
	}
	
}
