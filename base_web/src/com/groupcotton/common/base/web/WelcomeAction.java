package com.groupcotton.common.base.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


import com.groupcotton.common.base.service.AccountService;
import com.groupcotton.common.base.vo.Account;
import com.groupcotton.common.util.Constants;



/*
 * ����Ҫʵ���κνӿڣ�Ҳ����Ҫ�̳��κε��࣬Ҳ����Ҫ�κ� Servlet API
 */
@Controller
@RequestMapping("/welcome")
//��Model��������ΪConstants.USER_INFO_SESSION�����Էŵ�Session�����б��У��Ա�������Կ��Կ��������
@SessionAttributes(Constants.USER_INFO_SESSION)
public class WelcomeAction {
	private AccountService userService;
	
	public AccountService getUserService() {
		return userService;
	}

	public void setAccountService(AccountService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String helloWorld(Account user,Model model) throws Exception {
		Account user1 = userService.getAccount(user.getUsername());
		if(user1 == null) {
			model.addAttribute("message", "�û�������");
			return "relogin";
		}else if(user.getPassword() == null || !user.getPassword().equals(user1.getPassword()) ){
			model.addAttribute("message", "�������");
			return "relogin";
		}else {
			model.addAttribute(Constants.USER_INFO_SESSION, user1); //��ΪConstants.USER_INFO_SESSION�����Էŵ�Session�����б���
			return "welcome";
		}
	}
}
