package com.cungudafa.spingmvc01.dao;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cungudafa.spingmvc01.bean.TeacherInfo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/application-*.xml")
public class TeacherInfoSQLProviderDaoTest {
	@Autowired
	private TeacherInfoDaoSQLProvider dao;
	
	
	@Test
	public void test2(){
		TeacherInfo teacherInfo = new TeacherInfo();
		teacherInfo.setStart(0);
		teacherInfo.setTeacherName("%王%");
		teacherInfo.setTeacherNumber("%10%");
		
		List<TeacherInfo> teachers = dao.getTeacherInfoList(teacherInfo);
		for(TeacherInfo t : teachers){
			System.out.println("t.name = " + t.getTeacherName());
			System.out.println("t.number = " + t.getTeacherNumber());
			System.out.println("------------------------");
		}
	}
}
