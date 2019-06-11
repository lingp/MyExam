package com.lin.mybatis.simple.model;

import java.sql.Date;

/**
 * 角色表
 */
public class SysRole {
	// 角色Id
	private Long id;
	// 角色名称
	private String roleName;
	// 有效标志
	private Long enabled;
	// 创建人
	private Long createBy;
	// 创建时间
	private Date createdAt;
	
	private SysUser user;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Long getEnabled() {
		return enabled;
	}

	public void setEnabled(Long enabled) {
		this.enabled = enabled;
	}

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}
