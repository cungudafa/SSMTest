package com.cungudafa.spingmvc01.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cungudafa.spingmvc01.bean.TeacherInfo;
import com.cungudafa.spingmvc01.bean.schoolInfo;
import com.cungudafa.spingmvc01.dao.SchoolInfoDao;
import com.cungudafa.spingmvc01.dao.TeacherInfoDao;
import com.cungudafa.spingmvc01.service.TeacherInfoService;
import com.cungudafa.spingmvc01.util.DBManager;

@Service
public class TeacherInfoServiceImpl implements TeacherInfoService{
	@Autowired(required=false)
	private TeacherInfoDao teacherInfoDao;
	@Autowired(required=false)
	private SchoolInfoDao schoolInfoDao;
	
	/**
	 * 张-->%张%
	 * 10-->%10%
	 */
	@Override
	public List<TeacherInfo> getTeacherList(TeacherInfo teacherInfo) {
		if(teacherInfo.getTeacherName()!= null && !teacherInfo.getTeacherName().equals("")){
			teacherInfo.setTeacherName("%" + teacherInfo.getTeacherName() + "%");
		}
		if(teacherInfo.getTeacherNumber()!= null && !teacherInfo.getTeacherNumber().equals("")){
			teacherInfo.setTeacherNumber("%" + teacherInfo.getTeacherNumber() + "%");
		}
		if(teacherInfo.getSchool()!= null && !teacherInfo.getSchool().equals("")){
			teacherInfo.setSchool(teacherInfo.getSchool());
		}
		return teacherInfoDao.getTeacherList(teacherInfo);
	}
	/**
	 * 张-->%张%
	 * 10-->%10%
	 */
	@Override
	public Long getTeacherCount(TeacherInfo teacherInfo) {
		if(teacherInfo.getTeacherName()!= null && !teacherInfo.getTeacherName().equals("")){
			teacherInfo.setTeacherName("%" + teacherInfo.getTeacherName() + "%");
		}
		if(teacherInfo.getTeacherNumber()!= null && !teacherInfo.getTeacherNumber().equals("")){
			teacherInfo.setTeacherNumber("%" + teacherInfo.getTeacherNumber() + "%");
		}
		if(teacherInfo.getSchool()!= null && !teacherInfo.getSchool().equals("")){
			teacherInfo.setSchool(teacherInfo.getSchool());
		}
		return teacherInfoDao.getTeacherCount(teacherInfo);
	}

	@Override
	public TeacherInfo getTeacherById(TeacherInfo teacherInfo) {
		List<TeacherInfo> teachers = teacherInfoDao.getTeacherList(teacherInfo);
		if(teachers != null && teachers.size() == 1){
			return teachers.get(0);
		}
		return null;
	}

	@Override
	public void addTeacher(TeacherInfo teacherInfo) {
		teacherInfoDao.addTeacher(teacherInfo);
	}
	@Override
	public void updateTeacher(TeacherInfo teacherInfo) {
		teacherInfoDao.updateTeacher(teacherInfo);
	}

	@Override
	public void deleteTeacher(TeacherInfo teacherInfo) {
		teacherInfoDao.deleteTeacher(teacherInfo);
	}
	@Override
	public schoolInfo getSchoolById(schoolInfo schoolInfo) {
		List<schoolInfo> schoolInfos = schoolInfoDao.getSchool(schoolInfo);
		if(schoolInfos != null && schoolInfos.size() == 1){
			return schoolInfos.get(0);
		}
		return null;
	}

	@Override
	public schoolInfo getSchool(schoolInfo schoolInfo) {
		List<schoolInfo> schoolInfos = schoolInfoDao.getSchool(schoolInfo);
		if(schoolInfos != null && schoolInfos.size() == 1){
			return schoolInfos.get(0);
		}
		return null;
	}
	@Override
	public List<schoolInfo> getSchoolList(schoolInfo schoolInfo) {
			if(schoolInfo.getSchoolId()!= null && !schoolInfo.getSchoolId().equals("")){
			schoolInfo.setSchoolId(schoolInfo.getSchoolId());
		}
		if(schoolInfo.getSchoolName()!= null && !schoolInfo.getSchoolName().equals("")){
			schoolInfo.setSchoolName("%" + schoolInfo.getSchoolName() + "%");
		}
		return schoolInfoDao.getSchoolList(schoolInfo);
	}
	@Override
	public List<schoolInfo> findschools() throws SQLException {
		String sql = "select * from school";
		Connection con = DBManager.getConnection();
		PreparedStatement pstm = con.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<schoolInfo> schools = new ArrayList<>();//定义一个列表，存储数据
		while(rs.next()){
			Integer schoolId = rs.getInt(1);
			String schoolName = rs.getString(2);
			//列表中每个元素封装为TeacherInfo实体型
			schoolInfo s = new schoolInfo();
			s.setSchoolId(schoolId);
			s.setSchoolName(schoolName);
			//添加到techaers返回列表中
			schools.add(s);
		}
		pstm.close();
		con.close();
		return schools;
	}

}
