package com.cungudafa.spingmvc01.bean.one2many;

public class Student {
	private Integer studentId;
	private String studentName;
	/**
	 * 一个学生属于一个班级
	 */
	private Clazz clazz;
	
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Clazz getClazz() {
		return clazz;
	}
	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}
}
