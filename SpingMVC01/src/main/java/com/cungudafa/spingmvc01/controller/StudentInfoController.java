package com.cungudafa.spingmvc01.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cungudafa.spingmvc01.bean.StudentInfo;
import com.cungudafa.spingmvc01.service.StudentInfoService;



/**
 * 学生操作的核心控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/student")
public class StudentInfoController {
	
	@Autowired//自动装配，将StudentInfoService接口实现的类自动注入进来
	private StudentInfoService studentInfoService ;
	/**
	 * 处理学生注册的请求
	 * @param studentInfo
	 * @return
	 */
	@RequestMapping("/doreg")
	public String doReg(StudentInfo studentInfo){
		System.out.println("执行StudentInfoController.doReg...");
		studentInfoService.regStudentInfo(studentInfo);
		return "index";
	}
	/**
	 * 处理学生注销的请求
	 * @param studentInfo
	 * @return
	 */
	@RequestMapping("/dodelete")
	public String doDelete(StudentInfo studentInfo){
		studentInfoService.delStudentInfo(studentInfo);
		return "index";
	}

	/**
	 * 处理学生信息更新的请求
	 * @param studentInfo
	 * @return
	 */
	@RequestMapping("/doupdate")
	public String doUpdate(StudentInfo studentInfo){
		studentInfoService.updateStudentInfo(studentInfo);
		return "index";
	}
	/**
	 * 根据条件查询学生信息
	 * @param studentInfo {studentName 可能为空，可能不为空 studentNumber可能为空，可能不为空}
	 * @return
	 */
	@RequestMapping("/list")
	public String list(StudentInfo studentInfo,HttpSession session){
		List<StudentInfo> list = studentInfoService.getStudentInfos(studentInfo);
		session.setAttribute("students", list);
		return "index";
	}
	
	
}
