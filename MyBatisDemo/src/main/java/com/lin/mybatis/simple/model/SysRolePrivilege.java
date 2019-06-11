package com.lin.mybatis.simple.model;

/**
 * 角色权限关联表
 */
public class SysRolePrivilege {
	// 角色Id
	private long roleId;
	// 权限Id
	private long privilegeId;

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public long getPrivilegeId() {
		return privilegeId;
	}

	public void setPrivilegeId(long privilegeId) {
		this.privilegeId = privilegeId;
	}

}
