package com.cungudafa.annotation.myannotation;


public class TestCase01 {
	public static void main(String[] args) throws Exception {
		//获得MyClass上MyAnnotation注解中的各个值
		//1.获得MyClass的运行时类
		Class c = Class.forName("com.cungudafa.annotation.myannotation.MyClass");
		//2.判断MyClass类上是否有MyAnnotation注解
		if(c.isAnnotationPresent(MyAnnotation.class)){
			//3.如果有，则获得MyAnnotation注解
			MyAnnotation m = 
					(MyAnnotation) c.getAnnotation(MyAnnotation.class);
			String value = m.value();
			String a = m.a();
			String b = m.b();
			System.out.println("value = " + value);
			System.out.println("a = " + a);
			System.out.println("b = " + b);
		}
	}
}

