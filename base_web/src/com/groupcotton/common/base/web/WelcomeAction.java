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
 * 不需要实现任何接口，也不需要继承任何的类，也不需要任何 Servlet API
 */
@Controller
@RequestMapping("/welcome")
//将Model中属性名为Constants.USER_INFO_SESSION的属性放到Session属性列表中，以便这个属性可以跨请求访问
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
			model.addAttribute("message", "用户不存在");
			return "relogin";
		}else if(user.getPassword() == null || !user.getPassword().equals(user1.getPassword()) ){
			model.addAttribute("message", "密码错误");
			return "relogin";
		}else {
			model.addAttribute(Constants.USER_INFO_SESSION, user1); //名为Constants.USER_INFO_SESSION的属性放到Session属性列表中
			return "welcome";
		}
	}
}
