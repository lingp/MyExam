package com.lin.mybatis.simple.model;

/**
 * 权限表
 */
public class SysPrivilege {
	// 权限ID
	private long id;
	// 权限名称
	private String privilegeName;
	// 权限URL
	private String privilegeUrl;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPrivilegeName() {
		return privilegeName;
	}

	public void setPrivilegeName(String privilegeName) {
		this.privilegeName = privilegeName;
	}

	public String getPrivilegeUrl() {
		return privilegeUrl;
	}

	public void setPrivilegeUrl(String privilegeUrl) {
		this.privilegeUrl = privilegeUrl;
	}

}
