package com.cungudafa.spingmvc01.service;

import java.sql.SQLException;
import java.util.List;

import com.cungudafa.spingmvc01.bean.TeacherInfo;
import com.cungudafa.spingmvc01.bean.schoolInfo;


/**
 * 老师模块的业务层接口
 * @author Administrator
 *
 */
public interface TeacherInfoService {
	/**
	 * 根据条件/分页查询记录
	 * @param teacherInfo
	 * @return
	 */
	public List<TeacherInfo> getTeacherList(TeacherInfo teacherInfo);
	/**
	 * 根据条件查询总记录数
	 * @param teacherInfo
	 * @return
	 */
	public Long getTeacherCount(TeacherInfo teacherInfo);
	
	/**
	 * 根据id查询记录
	 * @param teacherInfo
	 * @return
	 */
	public TeacherInfo getTeacherById(TeacherInfo teacherInfo);
	/**
	 * 添加老师信息
	 * @param teacherInfo
	 */
	public void addTeacher(TeacherInfo teacherInfo);
	/**
	 * 修改老师信息
	 * @param teacherInfo
	 */
	public void updateTeacher(TeacherInfo teacherInfo);
	
	/**
	 * 删除老师信息
	 * @param teacherInfo
	 */
	public void deleteTeacher(TeacherInfo teacherInfo);
	/**
	 * 获得学校名称(偷懒少写一个schoolservice)
	 * 获得学校
	 * @param schoolInfo
	 * @return
	 */
	public schoolInfo getSchoolById(schoolInfo schoolInfo);
	public schoolInfo getSchool(schoolInfo schoolInfo);
	public List<schoolInfo> getSchoolList(schoolInfo schoolInfo);
	List<schoolInfo> findschools() throws SQLException;

}