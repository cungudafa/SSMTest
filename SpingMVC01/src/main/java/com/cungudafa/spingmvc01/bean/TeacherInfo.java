package com.cungudafa.spingmvc01.bean;

/**
 * TeacherInfo对应数据库中teacher_info表
 * @author Administrator
 *
 */
public class TeacherInfo extends BaseBean{
	private Integer teacherId;
	private String teacherName;
	private String teacherNumber;
	private Integer schoolId;
	
	private schoolInfo school;//外键
	
	public Integer getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getTeacherNumber() {
		return teacherNumber;
	}
	public void setTeacherNumber(String teacherNumber) {
		this.teacherNumber = teacherNumber;
	}
	public schoolInfo getSchool() {
		return school;
	}
	public void setSchool(schoolInfo school) {
		this.school = school;
	}
	public Integer getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

}
