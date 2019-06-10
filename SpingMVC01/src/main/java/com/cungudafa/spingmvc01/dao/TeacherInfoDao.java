package com.cungudafa.spingmvc01.dao;

import java.util.List;

import com.cungudafa.spingmvc01.bean.TeacherInfo;


/**
 * TeacherInfo实体类数据操作的接口
 * @author Administrator
 *
 */
public interface TeacherInfoDao {
	/**
	 * 按条件及分页信息查询记录
	 * @param teacher
	 * @return
	 */
	public List<TeacherInfo> getTeacherList(TeacherInfo teacherInfo);
	
	/**
	 * 按条件查询总记录数
	 * @param teacherInfo
	 * @return
	 */
	public Long getTeacherCount(TeacherInfo teacherInfo);
	
	/**
	 * 添加老师记录
	 * @param teacherInfo
	 */
	public void addTeacher(TeacherInfo teacherInfo);
	
	/**
	 * 修改老师记录
	 * @param teacherInfo
	 */
	public void updateTeacher(TeacherInfo teacherInfo);
	
	/**
	 * 删除老师记录
	 * @param teacherInfo
	 */
	public void deleteTeacher(TeacherInfo teacherInfo);
	/**
	 * 获得老师集合
	 * @return
	 */
	public List<TeacherInfo> getTeacherListWithSchool();
}
