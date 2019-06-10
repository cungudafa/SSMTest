package com.cungudafa.spingmvc01.dao.one2many;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cungudafa.spingmvc01.bean.one2many.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/application-*.xml")
public class StudentDaoTest {
	@Autowired
	private StudentDao dao;
	
	@Test
	public void test1(){
		List<Student> students = dao.getStudentList();
		for(Student s : students){
			System.out.println("s.name = " + s.getStudentName());
			System.out.println("s.clazz.name = " + s.getClazz().getClazzName());
		}
	}
}
