package com.lin.mybatis.simple.model;

import java.util.Date;
import java.util.Arrays;

/**
 * 用户表 
 */
/**
 * @author 1
 *
 */
/**
 * @author 1
 *
 */
public class SysUser {
	// 用户ID
	private Long id;
	// 用户名
	private String userName;
	// 密码
	private String userPassword;
	// 邮箱
	private String userEmail;
	// 简介
	private String userInfo;
	// 头像
	private byte[] headImg;
	// 创建时间
	private Date createdAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}

	public byte[] getHeadImg() {
		return headImg;
	}

	public void setHeadImg(byte[] headImg) {
		this.headImg = headImg;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	
	
}
