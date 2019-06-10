package com.cungudafa.spingmvc01.dao;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;

import com.cungudafa.spingmvc01.bean.TeacherInfo;


public interface TeacherInfoDaoSQLProvider {
	
	@SelectProvider(type=TeacherInfoSQLProvider.class,method="getTeacherInfoListSQL")
	@ResultMap("teachermap")
	public List<TeacherInfo> getTeacherInfoList(TeacherInfo teacherInfo);
}
