package com.groupcotton.common.role.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.groupcotton.common.role.dao.RoleMapper;
import com.groupcotton.common.role.vo.Role;
import com.groupcotton.common.util.DataGridModel;

@Service
public class RoleService {

	@Autowired
	private RoleMapper roleMapper;


	@Transactional
	public void insertRole(Role role) {
		
		roleMapper.insertRole(role);
	
	}

	@Transactional
	public void updateRole(Role role) {
	
		roleMapper.updateRole(role);
					
	}
	
	@Transactional
	public void deleteRole(List<Integer> list) {
		roleMapper.deleteRole(list);
	}
	 

	@SuppressWarnings("rawtypes")
	public Map<String, Object> getPageList(DataGridModel dgm, Role role) throws Exception {

		Map<String, Object> result = new HashMap<String, Object>(2);
		
		int  total = roleMapper.getCount(role);
		List<Role> list = roleMapper.getPageList(role);
		
		
		result.put("total", total);
		result.put("rows", list);

		return result;
	}

}
