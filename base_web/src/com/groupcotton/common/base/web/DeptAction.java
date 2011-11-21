package com.groupcotton.common.base.web;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.groupcotton.common.base.service.DeptService;
import com.groupcotton.common.base.vo.Dept;


@Controller
@RequestMapping("/dept")
public class DeptAction {

	private DeptService deptService;

	public DeptService getDeptService() {
		return deptService;
	}

	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}

	@RequestMapping(value="/queryAll")
	@ResponseBody         
	public Map<String, Object> queryAll() throws Exception{
	    return deptService.getAllJson(); 
	}
	
	@RequestMapping(value="/allList")
	@ResponseBody         
	public List<Dept> allList() throws Exception{
	    return deptService.getDeptList(); 
	}
	
	
}
