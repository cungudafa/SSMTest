package com.cungudafa.spingmvc01.dao;

import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cungudafa.spingmvc01.bean.TeacherInfo;
import com.cungudafa.spingmvc01.bean.schoolInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/application-*.xml")
public class SchoolDaoTest {
	@Autowired
	private SchoolInfoDao dao;
	
	@Test
	public void test1(){
		schoolInfo schoolInfo = new schoolInfo();
		schoolInfo.setSchoolId(1);//按班级号查找全部学生姓名（1对多）
		schoolInfo = dao.getSchoolById(schoolInfo);
		System.out.println("schoolInfo.name = " + schoolInfo.getSchoolName());
		
		Set<TeacherInfo> teacherInfos = schoolInfo.getTeachers();
		for(TeacherInfo t : teacherInfos){
			System.out.println("t.name = " + t.getTeacherName());
		}
	}
	
	@Test
	public void test2(){
		schoolInfo schoolInfo1 = new schoolInfo();
		schoolInfo1.setSchoolId(1);//按班级号查找全部学生姓名（1对多）
		List<schoolInfo> schoolInfos = dao.getSchool(schoolInfo1);//按班级号依次查找
		for(schoolInfo schoolInfo : schoolInfos){
			System.out.println("----------------");
			System.out.println("school.name = " + schoolInfo.getSchoolName());
			
		
			Set<TeacherInfo> teacherInfos=schoolInfo.getTeachers();
			for(TeacherInfo t : teacherInfos){
				System.out.println("s.name = " + t.getTeacherName());
			}		
			System.out.println("----------------");
		}
	}
	
	@Test
	public void test3(){
		schoolInfo schoolInfo1 = new schoolInfo();
		schoolInfo1.setSchoolId(null);//按班级号查找全部学生姓名（1对多）
		List<schoolInfo> schoolInfos = dao.getSchool(schoolInfo1);//按班级号依次查找
		for(schoolInfo schoolInfo : schoolInfos){
			System.out.println("----------------");
			System.out.println("school.name = " + schoolInfo.getSchoolName());
			
		
			Set<TeacherInfo> teacherInfos=schoolInfo.getTeachers();
			for(TeacherInfo t : teacherInfos){
				System.out.println("s.name = " + t.getTeacherName());
			}		
			System.out.println("----------------");
		}
	}

}
