package com.cungudafa.annotation.test;

import org.springframework.stereotype.Controller;

@Controller
@SuppressWarnings("deprecation")//== @SuppressWarnings(value="")
public class TestCase01 {
	
	@Deprecated
	public void f1(){
		
	}
	
	public static void main(String[] args) {
		new TestCase01().f1();
	}
}
