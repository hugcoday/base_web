package com.groupcotton.common.base.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.groupcotton.common.base.service.AccountService;
import com.groupcotton.common.base.service.DeptService;
import com.groupcotton.common.base.vo.Account;

import com.groupcotton.common.util.DataGridModel;




@Controller
@RequestMapping("/user")
public class AccountAction  {

	
	private DeptService deptService;
	
	private AccountService accountService;

	
	public AccountService getaccountService() {
		return accountService;
	}

	public void setaccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public DeptService getDeptService() {
		return deptService;
	}

	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}

	@RequestMapping(value="/list",method=RequestMethod.GET)   
	public String list(Model model) throws Exception {
		model.addAttribute("deptList", deptService.getDeptList());
		return "user/list";
	}

	@RequestMapping(value="/queryList",method=RequestMethod.POST)
	@ResponseBody         
	public Map<String, Object> queryList(DataGridModel dgm,Account user) throws Exception{
		//spring̫�����ˣ������Զ�װ����������  ���Զ���װ���ص�Mapת����JSON����
	    //return accountService.getPageListByExemple(dgm, user); 
	    return accountService.getPageList(dgm, user);
	}
	
	@RequestMapping(value="/popWindow",method=RequestMethod.GET)
	public String popWindow() throws Exception{
		return "user/popWindow";
	}
	
	@RequestMapping(value="/addOrUpdate",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> addOrUpdate(Account user) throws Exception{
		//spring������jackson�Զ�������ֵ��װ��JSON���󣬱�struts2�����˺ܶ�
		Map<String, String> map = new HashMap<String, String>();
		try {
			accountService.updateAccount(user);
			map.put("mes", "�����ɹ�");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("mes", "����ʧ��");
			throw e;
		}
		return map; 
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> delete(@RequestParam("uid") List<Integer> uid)throws Exception{
		//spring mvc �����Խ�������Ϊlist����
		Map<String, String> map = new HashMap<String, String>();
		try {
			accountService.deleteAccount(uid);
			map.put("mes", "ɾ���ɹ�");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("mes", "ɾ��ʧ��");
			throw e;
		}
		return map;//�ض���
	}
	


}
