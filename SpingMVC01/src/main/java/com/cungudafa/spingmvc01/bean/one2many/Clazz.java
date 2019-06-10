package com.cungudafa.spingmvc01.bean.one2many;

import java.util.Set;

public class Clazz {
	
	private Integer clazzId;
	private String clazzName;
	/**
	 * 一个班级下有多个学生
	 */
	private Set<Student> students;
	
	public Integer getClazzId() {
		return clazzId;
	}
	public void setClazzId(Integer clazzId) {
		this.clazzId = clazzId;
	}
	public String getClazzName() {
		return clazzName;
	}
	public void setClazzName(String clazzName) {
		this.clazzName = clazzName;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
}
