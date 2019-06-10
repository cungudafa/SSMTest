package com.cungudafa.annotation.demo;

import java.lang.reflect.InvocationTargetException;

public class TestCase {
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException, SecurityException {
		UserInfo userInfo = new UserInfo();
		userInfo.setUserId(10001);
		userInfo.setUserName("zhangsan");
		String sql = SQLGenerator.createSelectSql(userInfo);
		System.out.println("sql = " + sql);
		
		System.out.println("--------查询-----------");
		StudentInfo s = new StudentInfo();
		s.setId(10002);
		s.setStudentName("李四");
		s.setStudentNumber("102001203103");
		sql = SQLGenerator.createSelectSql(s);
		System.out.println("--------查询-----------");
		System.out.println("sql = " + sql);
		
		System.out.println("--------插入-----------");
		StudentInfo s1 = new StudentInfo();
		s1.setId(10002);//插入内容
		s1.setStudentName("李四");
		s1.setStudentNumber("102001203103");
		sql = SQLGenerator.createInsertSql(s1);
		System.out.println("sql = " + sql);
		
		System.out.println("--------删除-----------");
		StudentInfo s2 = new StudentInfo();
		s2.setId(10002);//删除条件任取
		s2.setStudentName("李四");
		s2.setStudentNumber("102001203103");
		sql = SQLGenerator.createDeleteSql(s2);
		System.out.println("sql = " + sql);
		
		System.out.println("--------更新studentinfo-----------");
		StudentInfo s3 = new StudentInfo();
		s3.setId(10002);//默认s3内容
		s3.setStudentName("李四");
		s3.setStudentNumber("102001203103");
		//修改内容
		StudentInfo s3_update = new StudentInfo();
		//s3_update.setId(s3.getId());//获得原始id,id唯一不可更改
		s3_update.setStudentName("张三");
		s3_update.setStudentNumber("0123456789");
		sql = SQLGenerator.createUpdateSql(s3,s3_update);
		System.out.println("sql = " + sql);
		
		System.out.println("\n--------userinfo表：-----------");
		UserInfo userInfo1 = new UserInfo();
		userInfo1.setUserId(1001);
		userInfo1.setUserName("user001");
		sql = SQLGenerator.createSelectSql(userInfo1);
		System.out.println("\nSelectsql = " + sql);//查	
		sql = SQLGenerator.createInsertSql(userInfo1);
		System.out.println("\nInsertsql = " + sql);//增
		userInfo1.setUserName("user123");//修改姓名
		sql = SQLGenerator.createUpdateSql(userInfo,userInfo1);//user001->user123
		System.out.println("\nUpdatesql = " + sql);//改
		sql = SQLGenerator.createDeleteSql(userInfo1);
		System.out.println("\nDeletesql = " + sql);//删
		
	}
}
