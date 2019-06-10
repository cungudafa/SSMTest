package com.cungudafa.spingmvc01.controller;

import javax.servlet.http.HttpServletRequest;


/**
 * 所有控制层的父类，处理请求中的pager.offset
 * @author Administrator
 *
 */
public class BaseController {
	
	private int start;

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}
	
	/**
	 * 处理pager.offset
	 * @param request
	 */
	protected void handleOffset(HttpServletRequest request){
		String s = request.getParameter("pager.offset");
		if(s != null && !s.equals("")){
			int start = Integer.parseInt(s);
			this.start = start;
		}
	}
	
}

