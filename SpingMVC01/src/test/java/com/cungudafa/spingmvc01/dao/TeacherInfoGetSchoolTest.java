package com.cungudafa.spingmvc01.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cungudafa.spingmvc01.bean.TeacherInfo;
import com.cungudafa.spingmvc01.bean.schoolInfo;
import com.cungudafa.spingmvc01.service.TeacherInfoService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/application-*.xml")
public class TeacherInfoGetSchoolTest {
	@Autowired
	private TeacherInfoDao dao;
		
	@Test
	public void test01(){
			List<TeacherInfo> teacherInfos = dao.getTeacherListWithSchool();
			for(TeacherInfo t : teacherInfos){
				System.out.println("t.name = " + t.getTeacherName());
				System.out.println("t.shcool.name = " + t.getSchool().getSchoolName());
		}
	}
}
