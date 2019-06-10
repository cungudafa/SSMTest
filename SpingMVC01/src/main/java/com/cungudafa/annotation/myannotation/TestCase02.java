package com.cungudafa.annotation.myannotation;

public class TestCase02 {
	public static void main(String[] args) throws Exception {
		//判断MyClass的子类是否继承了MyClass类的注解
		Class c = 
				Class.forName("com.cungudafa.annotation.myannotation.MyClassSon");
		if(c.isAnnotationPresent(MyAnnotation.class)){
			System.out.println("继承了");
		}else{
			System.out.println("没有继承");
		}
	}
}

