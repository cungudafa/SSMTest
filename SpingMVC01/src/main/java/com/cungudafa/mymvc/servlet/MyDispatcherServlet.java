package com.cungudafa.mymvc.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cungudafa.mymvc.annotation.MyController;
import com.cungudafa.mymvc.annotation.MyRequestMapping;
import com.cungudafa.mymvc.annotation.MyResponseBody;


/**
 * MyMVC框架的核心Servlet
 * @author Administrator
 *
 */
public class MyDispatcherServlet extends HttpServlet{
	
	/**
	 * 用来保存扫描包以后得到的所有的Controller类名
	 */
	private List<String> classNames = new ArrayList<>();
	/**
	 * 用来保存所有的Controller类，以及与之对应的请求路径
	 * /user --> UserInfoController
	 */
	private Map<String, Object> javaBeans = new HashMap<>();
	/**
	 * 用来保存所有的Controller类的方法，以及与之对应的请求路径
	 * /user/index-->UserInfoController.index()
	 */
	private Map<String, Object> controllerMethods = new HashMap<>();
	
	@Override
	public void init() throws ServletException {
		super.init();
		//1.获得web.xml中配置的初始化参数basePackage
		String basePackage = this.getServletConfig().getInitParameter("basePackage");

		//2.扫描包里面所有的Controller
		scanPackage(basePackage);
				
		//3.根据类名，生成Controller,以及Controller中所有的方法
		//Controller和方法分别保存在两个Map中，以请求路径作为Map的key
		createInstances();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);//使用同一套业务代码处理请求
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.获取请求的路径,处理字符串，从中得到/user/index
		String url = req.getRequestURI();//        /SpingMVC01/user/index.do
		System.out.println("url = " + url) ;
		String context = req.getContextPath();//   /SpingMVC01
		System.out.println("contextPath = " + context);
		url = url.replaceAll(context, "");
		url = url.replaceAll(".do", "");
		
		//2.从保存方法的Map中以"/user/index"作为键，取出方法
		Method method = (Method) controllerMethods.get(url);
		
		//3."/user/index"---->"/user",从保存类的Map中以“/user”作为键，取出控制器
		url = "/" + url.split("/")[1];//{"","user","index"}
		Object controller = javaBeans.get(url);
		
		System.out.println("取得的控制器：" + controller);
		System.out.println("取得的方法：" + method);
		
		//4.在调用方法之前，对将调用的方法的参数列表进行处理
		//4.1拿到当前要执行的方法的参数类型列表
		Class<?>[] paramTypes = method.getParameterTypes();
		Object[] args = new Object[paramTypes.length];
		int i = 0;
		for(Class paramType : paramTypes){//遍历参数类型的数组
			//判断要执行的方法中是否有一个形参的类型是ServletRequest
			if(ServletRequest.class.isAssignableFrom(paramType)){
				args[i++] = req;
			}
			if(ServletResponse.class.isAssignableFrom(paramType)){
				args[i++] = resp;
			}
			if(HttpSession.class.isAssignableFrom(paramType)){
				args[i++] = req.getSession();
			}
		}
		
		
		try {
			String returnValue = (String)method.invoke(controller,args);// /index
			//5.判断方法上是否有@MyResponseBody注解，从而采取不同的响应策略
			if(method.isAnnotationPresent(MyResponseBody.class)){
				PrintWriter out = resp.getWriter();
				out.println(returnValue);
				out.flush();
				
			}else{
				String returnUrl = "/WEB-INF/" + returnValue + ".jsp";
				//跳转
				req.getRequestDispatcher(returnUrl).forward(req, resp);
			}
			
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据扫描得到的类名生成实体类
	 */
	private void createInstances() {
		if(classNames.size() > 0){
			for(String className : classNames){
				try {
					Class c = Class.forName(className);
					Object controller = c.newInstance();
					if(c.isAnnotationPresent(MyController.class)){//判断是控制器，才处理
						//获取控制器上的@RequestMapping注解
						MyRequestMapping rm = (MyRequestMapping) c.getAnnotation(MyRequestMapping.class);
						String classUrl = rm.value();//获得类上@MyRequestMapping注解中的路径值  --> /user
						javaBeans.put(classUrl, controller);
						//获得该控制类的所有方法
						Method[] methods = c.getDeclaredMethods();
						for(Method method: methods){//遍历所有方法
							if(method.isAnnotationPresent(MyRequestMapping.class)){//如果方法上有@MyRequesyMapping注解
								MyRequestMapping rm1 = method.getAnnotation(MyRequestMapping.class);
								String methodUrl = rm1.value();//获得方法上@MyRequestMapping注解中的路径值  --> /index
								String url = classUrl + methodUrl;// /user/index
								controllerMethods.put(url, method);//将所有的请求路径和对应的控制器方法存入map中
							}
						}
						
					}
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("controllerMethods.size() = " + controllerMethods.size());
			for(Map.Entry<String, Object> entity : controllerMethods.entrySet()){
				System.out.println("url = " + entity.getKey());
				System.out.println("method = " + entity.getValue());
				System.out.println("------------");
			}
			System.out.println("javaBeans.size = " + javaBeans.size());
			for(Map.Entry<String, Object> entity : javaBeans.entrySet()){
				System.out.println("url = " + entity.getKey());
				System.out.println("controller = " + entity.getValue());
				System.out.println("------------");
			}
		}
	}

	/**
	 * 扫描基础包下所有的Controller
	 * @param basePackage com.cungudafa.mymvc.controller
	 */
	private void scanPackage(String basePackage) {
		//com.cungudafa.mymvc.controller --> /com/cungudafa/mymvc/controller
		URL url = this.getClass().getClassLoader().getResource("/" + basePackage.replaceAll("\\.", "/"));
		String fileStr = url.getFile();//文件路径
		File file = new File(fileStr);//用该文件路径生成一个文件夹对象
		String[] filesStr = file.list();//获得该文件夹下所有的文件名
		for(String fileName : filesStr){
//			System.out.println("fileName = " + fileName);
			String className = basePackage + "." + fileName.replaceAll(".class", "");
			System.out.println("className = " + className);
			classNames.add(className);
		}
	}
}
