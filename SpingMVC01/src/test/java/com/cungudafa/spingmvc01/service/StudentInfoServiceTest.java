package com.cungudafa.spingmvc01.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cungudafa.spingmvc01.bean.StudentInfo;
import com.cungudafa.spingmvc01.service.StudentInfoService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/application-*.xml")
public class StudentInfoServiceTest {
	@Autowired
	private StudentInfoService studentInfoService;
	
	@Test
	public void test1(){
		StudentInfo studentInfo = new StudentInfo();
		studentInfo.setStudentName("王");
		studentInfo.setStudentNumber("10");
		List<StudentInfo> list = studentInfoService.getStudentInfos(studentInfo);
		for(StudentInfo s : list){
			System.out.println("s.name = " + s.getStudentName());
			System.out.println("s.number = " + s.getStudentNumber());
		}
	}
}