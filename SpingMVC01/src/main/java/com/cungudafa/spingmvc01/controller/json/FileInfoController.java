package com.cungudafa.spingmvc01.controller.json;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cungudafa.spingmvc01.bean.FileInfo;
import com.cungudafa.spingmvc01.dao.FileInfoDao;
import com.cungudafa.spingmvc01.dao.impl.FileInfoDaoImpl;


/**
 * 返回JSON格式数据的控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/file/json")
public class FileInfoController {
	
	private FileInfoDao fileInfoDao = new FileInfoDaoImpl();
	
	/**
	 * 根据id返回文件信息
	 * @param fileInfo
	 * @return
	 */
	@RequestMapping("/get")
	public @ResponseBody FileInfo getFile(FileInfo fileInfo,HttpSession session){
		try {
			fileInfo = fileInfoDao.findFileById(fileInfo.getFileId());
			return fileInfo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("/getall")//浏览器输入http://localhost:8080/SpingMVC01/file/json/getall.d
	public @ResponseBody List<FileInfo> getFiles(){
		try {
			return fileInfoDao.findFiles();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping("/getall2")
	public String getFiles2(HttpSession session){
		try {
			session.setAttribute("files", fileInfoDao.findFiles());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "files2";
	}
}
