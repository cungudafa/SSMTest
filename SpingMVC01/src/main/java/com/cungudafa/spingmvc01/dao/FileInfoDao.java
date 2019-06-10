package com.cungudafa.spingmvc01.dao;

import java.util.List; 
import java.sql.SQLException;

import com.cungudafa.spingmvc01.bean.FileInfo;

/**
 * DataAccessObject数据访问对象
 * @author Administrator
 *
 */
public interface FileInfoDao {
	/**
	 * 添加文件
	 * @param fileInfo
	 */
	public void addFileInfo(FileInfo fileInfo) throws SQLException;
	/**
	 * 查询所有的文件
	 * @return
	 */
	public List<FileInfo> findFiles() throws SQLException;
	/**
	 * 根据id查询文件
	 * @param fileId
	 * @return
	 */	
	public FileInfo findFileById(Integer fileId) throws SQLException;
}
