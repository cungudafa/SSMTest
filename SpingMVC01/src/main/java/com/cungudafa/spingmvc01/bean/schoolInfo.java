package com.cungudafa.spingmvc01.bean;

import java.util.Set;


public class schoolInfo {
	private Integer schoolId;
	private String schoolName;
	/**
	 * 一个班级下有多个老师
	 */
	private Set<TeacherInfo> teachers;
	
	public Integer getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public Set<TeacherInfo> getTeachers() {
		return teachers;
	}
	public void setTeachers(Set<TeacherInfo> teachers) {
		this.teachers = teachers;
	}


}