package com.cungudafa.spingmvc01.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cungudafa.spingmvc01.bean.StudentInfo;
import com.cungudafa.spingmvc01.dao.StudentInfoDao;
//import com.cungudafa.spingmvc01.dao.impl.StudentInfoDaoImpl;
import com.cungudafa.spingmvc01.service.StudentInfoService;


/**
 * 学生业务接口的实现类
 * @author Administrator
 *
 */
@Service
public class StudentInfoServiceImpl implements StudentInfoService{
	@Autowired
	private StudentInfoDao studentInfoDao ;//= new StudentInfoDaoImpl();
	
	/**
	 * 学生注册
	 */
	@Override
	public void regStudentInfo(StudentInfo studentInfo) {
		System.out.println("执行了StudentInfoServiceImpl.regStudentInfo...");
		studentInfoDao.addStudentInfo(studentInfo);
	}
	
	@Override
	public void delStudentInfo(StudentInfo studentInfo){
		studentInfoDao.deleteStudentInfo(studentInfo);
	}

	@Override
	public void updateStudentInfo(StudentInfo studentInfo) {
		studentInfoDao.updateStudentInfo(studentInfo);
	}
	
	/**
	 * 张	--》   %张%
	 * 10	--》   %10%
	 */
	@Override
	public List<StudentInfo> getStudentInfos(StudentInfo studentInfo) {
		if(studentInfo.getStudentName()!= null &&
				!studentInfo.getStudentName().equals("")){
			studentInfo.setStudentName("%" + studentInfo.getStudentName() + "%");
		}
		if(studentInfo.getStudentNumber() != null &&
				!studentInfo.getStudentNumber().equals("")){
			studentInfo.setStudentNumber("%" + studentInfo.getStudentNumber() + "%");
		}
		return studentInfoDao.getStudentInfos(studentInfo);
	}

}

