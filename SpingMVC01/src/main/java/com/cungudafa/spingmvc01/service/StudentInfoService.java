package com.cungudafa.spingmvc01.service;

import java.util.List;

import com.cungudafa.spingmvc01.bean.StudentInfo;


/**
 * 对于学生的业务功能接口
 * @author Administrator
 *
 */
public interface StudentInfoService {
	/**
	 * 学生注册
	 * @param studentInfo
	 */
	public void regStudentInfo(StudentInfo studentInfo);
	
	/**
	 * 学生注销
	 * @param studentInfo
	 */
	public void delStudentInfo(StudentInfo studentInfo);
	
	/**
	 * 学生信息更新
	 * @param studentInfo
	 */
	public void updateStudentInfo(StudentInfo studentInfo);
	
	/**
	 * 根据条件查询学生信息
	 * @param studentInfo
	 * @return
	 */
	public List<StudentInfo> getStudentInfos(StudentInfo studentInfo);
	
}