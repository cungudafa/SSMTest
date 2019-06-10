package com.cungudafa.spingmvc01.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.cungudafa.spingmvc01.bean.TeacherInfo;

/**
 * 用注解的方式配置SQL
 * @author Administrator
 *
 */
public interface TeacherInfoDaoAnnotation {
	
	@Insert("insert into teacher_info(teacher_name,teacher_number)"
			+ " values(#{teacherName},#{teacherNumber})")
	public void addTeacher(TeacherInfo teacherInfo);
	
	@Select(
			{"<script>",
			"select * from teacher_info ",
			"where 1 = 1 ",
			"<if test='teacherName != null and teacherName.length()!=0'>",
			"and teacher_name like #{teacherName} ",
			"</if>",
			"<if test='teacherNumber != null and teacherNumber.length()!=0'>",
			"and teacher_number like #{teacherNumber} ",
			"</if>",
			"limit #{start},#{length}",
			"</script>"}
			)
//	@Results({
//		@Result(column="teacher_id",property="teacherId"),
//		@Result(column="teacher_name",property="teacherName"),
//		@Result(column="teacher_number",property="teacherNumber")
//	})
	@ResultMap("teachermap")
	public List<TeacherInfo> getTeacherList(TeacherInfo teacherInfo);
}
