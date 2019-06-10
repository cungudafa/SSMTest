package com.cungudafa.annotation.demo;

@Table("user_info")
public class UserInfo {//user_info表
	
	@Column("user_id")
	private Integer userId;//user_id字段
	
	@Column("user_name")
	private String userName;//user_name字段

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}

