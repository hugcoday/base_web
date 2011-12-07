package com.groupcotton.common.role.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.groupcotton.common.role.service.RoleService;
import com.groupcotton.common.role.vo.Role;

import com.groupcotton.common.util.DataGridModel;


@Controller
@RequestMapping("/role")
public class RoleController  {

	private RoleService roleService;

	
	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	
	
	@RequestMapping(value="/list",method=RequestMethod.GET)   
	public String list(Model model) throws Exception {
		
		return "/role/list";
	}


	@RequestMapping(value="/queryList",method=RequestMethod.POST)
	@ResponseBody         
	public Map<String, Object> queryList(DataGridModel dgm,Role role) throws Exception{
		//spring太给力了，可以自动装配两个对象  会自动的装返回的Map转换成JSON对象
	    
	    return roleService.getPageList(dgm, role);
	}
	
	@RequestMapping(value="/popWindow",method=RequestMethod.GET)
	public String popWindow() throws Exception{
		return "role/popWindow";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> add(Role role) throws Exception{
		//spring会利用jackson自动将返回值封装成JSON对象，比struts2方便了很多
		Map<String, String> map = new HashMap<String, String>();
		try {
			roleService.insertRole(role);
			map.put("mes", "操作成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("mes", "操作失败");
			throw e;
		}
		return map; 
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> update(Role role) throws Exception{
		//spring会利用jackson自动将返回值封装成JSON对象，比struts2方便了很多
		Map<String, String> map = new HashMap<String, String>();
		try {
			roleService.updateRole(role);
			map.put("mes", "操作成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("mes", "操作失败");
			throw e;
		}
		return map; 
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> delete(@RequestParam("uid") List<Integer> uid)throws Exception{
		//spring mvc 还可以将参数绑定为list类型
		Map<String, String> map = new HashMap<String, String>();
		try {
			roleService.deleteRole(uid);
			map.put("mes", "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("mes", "删除失败");
			throw e;
		}
		return map;//重定向
	}
	


}
