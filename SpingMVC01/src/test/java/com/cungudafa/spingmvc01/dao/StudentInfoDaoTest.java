package com.cungudafa.spingmvc01.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cungudafa.spingmvc01.bean.StudentInfo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/application-*.xml")
public class StudentInfoDaoTest {
	@Autowired
	private StudentInfoDao studentInfoDao;
	@Test
	public void test1(){
		StudentInfo studentInfo = new StudentInfo();
		studentInfo.setStudentId(1);
		
		studentInfo = studentInfoDao.getStudentInfoById(studentInfo);
		System.out.println(studentInfo.getStudentName());
		System.out.println(studentInfo.getStudentNumber());
	}
	
	@Test
	public void test2(){
		StudentInfo studentInfo = new StudentInfo();
		studentInfo.setStudentName("王五");
		studentInfo.setStudentNumber("100003");		
		//studentInfoDao.addStudentInfo(studentInfo);
	}
	
//	@Test
//	public void test3(){
//		List<StudentInfo> list = studentInfoDao.getStudentInfos();
//		for(StudentInfo s : list){
//			System.out.println("s.name = " + s.getStudentName());
//			System.out.println("s.number = " + s.getStudentNumber());
//		}
//	}
	
	@Test
	public void test4(){
		StudentInfo studentInfo = new StudentInfo();
		studentInfo.setStudentName("王%");
		studentInfo.setStudentNumber("10%");
		List<StudentInfo> list = studentInfoDao.getStudentInfos(studentInfo);
		for(StudentInfo s : list){
			System.out.println("s.name = " + s.getStudentName());
			System.out.println("s.number = " + s.getStudentNumber());
		}
	}
}




