package com.cungudafa.spingmvc01.dao;
import org.apache.ibatis.jdbc.SQL;

import com.cungudafa.spingmvc01.bean.TeacherInfo;


public class TeacherInfoSQLProvider {
	
	public String getTeacherInfoListSQL(TeacherInfo teacherInfo){
		SQL sql = new SQL().SELECT("*").FROM("teacher_info");
		String teacherName = teacherInfo.getTeacherName();
		String teacherNumber = teacherInfo.getTeacherNumber();
		if(teacherName != null && !teacherName.equals("")){
			sql.WHERE("teacher_name like #{teacherName}");
		}
		if(teacherNumber != null && !teacherNumber.equals("")){
			sql.WHERE("teacher_number like #{teacherNumber}");
		}
		return sql.toString() + "limit #{start},#{length}";
		
	}
	
}
