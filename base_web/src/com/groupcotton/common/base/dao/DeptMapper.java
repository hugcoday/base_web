package com.groupcotton.common.base.dao;


import java.util.List;

import com.groupcotton.common.base.vo.Dept;



public interface DeptMapper {

	public  void save(Dept transientInstance);

	public  void delete(Dept persistentInstance);

	public  Dept findById(java.lang.Integer id);

	
	public  List findByExample(Dept instance);

	public  List findByProperty(String propertyName, Object value);

	public  List findByCode(Object code);

	public  List findByName(Object name);

	public  List findAll();

	public  Dept merge(Dept detachedInstance);

	public  void attachDirty(Dept instance);

	public  void attachClean(Dept instance);

}
