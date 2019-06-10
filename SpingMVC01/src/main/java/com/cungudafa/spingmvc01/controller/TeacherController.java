package com.cungudafa.spingmvc01.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cungudafa.spingmvc01.bean.TeacherInfo;
import com.cungudafa.spingmvc01.bean.schoolInfo;
import com.cungudafa.spingmvc01.service.TeacherInfoService;

/**
 * 处理老师功能模块请求的控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController extends BaseController{
	@Autowired
	private TeacherInfoService teacherInfoService;
	/**
	 * 处理访问老师模块主页的条件+分页查询的请求
	 * @return
	 */
	@RequestMapping("/index")
	public String index(TeacherInfo teacherInfo,HttpServletRequest request){
		
		//处理请求中的pager.offset
		handleOffset(request);
		teacherInfo.setStart(this.getStart());
		request.setAttribute("teachernamecondition", teacherInfo.getTeacherName());
		request.setAttribute("teachernumbercondition", teacherInfo.getTeacherNumber());
		request.setAttribute("schoolidcondition", teacherInfo.getSchoolId());
		//schoolInfo schoolInfo=new schoolInfo();
		//schoolInfo.setSchoolId(teacherInfo.getSchoolId());
		//request.setAttribute("schoolnamecondition", teacherInfo.getSchool().getSchoolName());
		
		//按条件/分页查询出所有记录
		List<TeacherInfo> teachers = teacherInfoService.getTeacherList(teacherInfo);
		//按条件查询出所有的记录数
		Long count = teacherInfoService.getTeacherCount(teacherInfo);
		
		request.setAttribute("teachers", teachers);
		request.setAttribute("count", count);
		
		
		return "teacher/teacher_index";
	}
	
	/**
	 * 处理查询单个教师信息的请求
	 * @param teacherInfo
	 * @param request
	 * @return
	 */
	@RequestMapping("/show")
	public @ResponseBody TeacherInfo show(TeacherInfo teacherInfo,HttpServletRequest request){
		teacherInfo = teacherInfoService.getTeacherById(teacherInfo);
		request.setAttribute("teacher", teacherInfo);
		return teacherInfo;
	}
	@RequestMapping("/getSchoolsName")
	public @ResponseBody List<schoolInfo> getSchools(){
		try {
			return teacherInfoService.findschools();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 处理添加老师信息的请求
	 * @param teacherInfo
	 * @return
	 */
	@RequestMapping("/add")
	public String add(TeacherInfo teacherInfo,HttpServletRequest request){
		teacherInfoService.addTeacher(teacherInfo);
		/**
		 * 下面两句是把查询条件置空,返回数据库全部数据
		 */
		teacherInfo.setTeacherName(null);
		teacherInfo.setTeacherNumber(null);
		//teacherInfo.setSchoolId(null);
		return index(teacherInfo,request);
		
	}
	/**
	 * 处理修改前准备显示用户信息的请求
	 * @param teacherInfo
	 * @return
	 */
	@RequestMapping("/update")
	public String update(TeacherInfo teacherInfo,HttpServletRequest request){
		teacherInfo = teacherInfoService.getTeacherById(teacherInfo);
		request.setAttribute("teacher", teacherInfo);
		return "teacher/teacher_update";
	}
	
	/**
	 * 处理更新老师信息的请求
	 * @param teacherInfo
	 * @param request
	 * @return
	 */
	@RequestMapping("/doupdate")
	public String doUpdate(TeacherInfo teacherInfo,HttpServletRequest request){
		teacherInfoService.updateTeacher(teacherInfo);
		teacherInfo.setTeacherId(null);
		teacherInfo.setTeacherName(null);
		teacherInfo.setTeacherNumber(null);
		//teacherInfo.setSchoolId(null);
		return index(teacherInfo, request);
	}
	
	/**
	 * 处理删除老师信息的请求
	 * @param teacherInfo
	 * @param request
	 * @return
	 */
	@RequestMapping("/delete")
	public String delete(TeacherInfo teacherInfo,HttpServletRequest request){
		teacherInfoService.deleteTeacher(teacherInfo);
		teacherInfo.setTeacherId(null);
		teacherInfo.setTeacherName(null);
		teacherInfo.setTeacherNumber(null);
		//teacherInfo.setSchoolId(null);
		return index(teacherInfo, request);
	}
}
