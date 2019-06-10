package com.cungudafa.spingmvc01.dao;

import java.util.List;

import com.cungudafa.spingmvc01.bean.schoolInfo;

public interface SchoolInfoDao {
	
	public schoolInfo getSchoolById(schoolInfo schoolInfo);
	
	public List<schoolInfo> getSchool(schoolInfo schoolInfo);
	
	public List<schoolInfo> getSchoolList(schoolInfo schoolInfo);

}
