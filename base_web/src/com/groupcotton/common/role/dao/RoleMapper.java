package com.groupcotton.common.role.dao;


import java.io.Serializable;

import java.util.List;

import com.groupcotton.common.role.vo.Role;




public interface RoleMapper {

	Role getRoleByID(String id);
	
	void insertRole(Role role);
	
	void updateRole(Role role);
	
	void deleteRole(List<Integer> list);
	
	int getCount(Role role);
	
	List<Role> getPageList(Role role);

}
