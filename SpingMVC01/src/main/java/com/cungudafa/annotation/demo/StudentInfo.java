package com.cungudafa.annotation.demo;

@Table("t_student")
public class StudentInfo {
	@Column("t_stuid")
	private Integer id;
	@Column("t_stuname")
	private String studentName;
	@Column("t_stunumber")
	private String studentNumber;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
}
