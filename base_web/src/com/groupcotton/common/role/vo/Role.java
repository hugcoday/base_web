package com.groupcotton.common.role.vo;


import java.io.Serializable;


public class Role implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	 
	private java.lang.Integer roleId;
	 
	 
	private java.lang.String roleCode;
	 
	 
	private java.lang.String roleName;
	 


	
	 
	public void setRoleId(java.lang.Integer value) {
		this.roleId = value;
	}
	
	public java.lang.Integer getRoleId() {
		return this.roleId;
	}
	 
	 
	public void setRoleCode(java.lang.String value) {
		this.roleCode = value;
	}
	
	public java.lang.String getRoleCode() {
		return this.roleCode;
	}
	 
	 
	public void setRoleName(java.lang.String value) {
		this.roleName = value;
	}
	
	public java.lang.String getRoleName() {
		return this.roleName;
	}
	 

	
}