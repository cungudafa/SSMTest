package com.cungudafa.spingmvc01.dao.one2many;

import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cungudafa.spingmvc01.bean.one2many.Clazz;
import com.cungudafa.spingmvc01.bean.one2many.Student;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/application-*.xml")
public class ClazzDaoTest {
	@Autowired
	private ClazzDao dao;
	
	@Test
	public void test1(){
		Clazz clazz = new Clazz();
		clazz.setClazzId(1601);//按班级号查找全部学生姓名（1对多）
		clazz = dao.getClazzById(clazz);
		System.out.println("clazz.name = " + clazz.getClazzName());
		
		Set<Student> students = clazz.getStudents();
		for(Student s : students){
			System.out.println("s.name = " + s.getStudentName());
		}
	}
	
	@Test
	public void test2(){
		List<Clazz> clazzes = dao.getClazzes();//按班级号依次查找
		for(Clazz clazz : clazzes){
			System.out.println("----------------");
			System.out.println("clazz.name = " + clazz.getClazzName());
			
			Set<Student> students = clazz.getStudents();
			for(Student s : students){
				System.out.println("s.name = " + s.getStudentName());
			}		
			System.out.println("----------------");
		}
	}
}
