package com.groupcotton.common.base.service;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.groupcotton.common.base.dao.DeptMapper;
import com.groupcotton.common.base.vo.Dept;



@Service
public class DeptService {

  @Autowired
  private DeptMapper DeptMapper;

	public void addDept(Dept dept) throws Exception {
		DeptMapper.save(dept);
	}

	public void deleteDept(int id) throws Exception {
		DeptMapper.delete(getDeptById(id));
	}

	public Dept getDeptById(int id) throws Exception {
		return DeptMapper.findById(id);
	}

	@SuppressWarnings("unchecked")
	public List<Dept> getDeptList() throws Exception {
		return DeptMapper.findAll();
	}

	public void updateDept(Dept dept) throws Exception {
		DeptMapper.merge(dept);
	}

	public Map<String, Object> getAllJson() throws Exception {
		Map<String, Object> result = new HashMap<String, Object>(2);
		List<Dept> list = getDeptList();
		result.put("total", list==null ? 0 : list.size());
		result.put("rows", list);
		return result;
	}

}
