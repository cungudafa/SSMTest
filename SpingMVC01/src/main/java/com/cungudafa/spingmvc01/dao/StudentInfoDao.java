package com.cungudafa.spingmvc01.dao;

import java.util.List;

import com.cungudafa.spingmvc01.bean.StudentInfo;

/**
 * 对于StudentInfo实体的CRUD操作接口
 * @author Administrator
 *
 */
public interface StudentInfoDao {
	/**
	 * 添加一条学生信息
	 * @param studentInfo {studentName,studentNumber}
	 */
	public void addStudentInfo(StudentInfo studentInfo);
	/**
	 * 删除一条学生信息
	 * @param studentInfo {studentId}
	 */
	public void deleteStudentInfo(StudentInfo studentInfo);
	/**
	 * 更新学生信息
	 * @param studentInfo {studentId,studentName,studentNumber}
	 */
	public void updateStudentInfo(StudentInfo studentInfo);
	
	/**
	 * 根据id查询学生信息
	 * @param studentInfo {studentId}
	 * @return StudentInfo类型的对象
	 */
	public StudentInfo getStudentInfoById(StudentInfo studentInfo);
	
//	/**
//	 * 查询所有学生信息
//	 * @return
//	 */
//	public List<StudentInfo> getStudentInfos();
	
	/**
	 * 根据条件查询学生记录
	 * @param studentInfo {studentName 可能为空，可能不为空 studentNumber可能为空，可能不为空}
	 * 1.studentName studentNumber都为空 ——> select * from student_info
	 * 2.studentName != null --> select * from student_info where student_name like ?
	 * 3.studentNumber != null --> select * from student_infow where student_number like ?
	 * 4.studentName && studentNumber != null
	 * 	-->select * from student_info where studnet_name = ? and student_number = ?
	 * @return
	 */
	public List<StudentInfo> getStudentInfos(StudentInfo studentInfo);
}