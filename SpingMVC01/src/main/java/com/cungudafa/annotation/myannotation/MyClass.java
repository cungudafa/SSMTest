package com.cungudafa.annotation.myannotation;

@MyAnnotation(value="hello",b="xxxx")
public class MyClass {
	
	@MyAnnotation(value = "",b="")
	private String a;

	@MyAnnotation(value = "",b="")
	public String doSth(){
		return null;
	}
}
