package com.cungudafa.spingmvc01.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cungudafa.spingmvc01.bean.StudentInfo;
import com.cungudafa.spingmvc01.dao.StudentInfoDao;


/**
 * 学生数据访问接口的实现类
 * @author Administrator
 *
 */
//@Service
//public class StudentInfoDaoImpl implements StudentInfoDao{
//	@Autowired//由Spring自动将Mybatis生成的接口的实现类的对象注入
//	private StudentInfoDao studentInfoDao;//=new StudentINfoDaoImpl();
//
//	@Override
//	public void addStudentInfo(StudentInfo studentInfo) {
//		System.out.println("执行了StudentInfoDaoImpl.addStudentInfo...");
//		studentInfoDao.addStudentInfo(studentInfo);
//	}
//
//}
