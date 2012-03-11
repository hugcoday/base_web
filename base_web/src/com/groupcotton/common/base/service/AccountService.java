package com.groupcotton.common.base.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.groupcotton.common.base.dao.AccountMapper;
import com.groupcotton.common.base.vo.Account;
import com.groupcotton.common.util.DataGridModel;

@Service
public class AccountService {

	private static final Log LOG = LogFactory.getLog(AccountService.class);

	@Autowired
	private AccountMapper accountMapper;

	public Account getAccount(String accountcode) throws Exception {
		Account account = null;

			account = accountMapper.getAccountByUsername(accountcode);


		return account;
	}

	public Account getAccount(String accountcode, String password) throws Exception {
		Account account = new Account();
		account.setAccountCode(accountcode);
		account.setPassword(password);
		return accountMapper.getAccountByUsernameAndPassword(account);
	}

	@Transactional
	public void insertAccount(Account account) throws Exception {
		accountMapper.insertAccount(account);

	}

	@Transactional
	public void updateAccount(Account account) throws Exception {
		accountMapper.updateAccount(account);

	}

	@Transactional
	public void deleteAccount(List<Integer> list) throws Exception {
		accountMapper.deleteAccount(list);
	}

	@SuppressWarnings("rawtypes")
	public Map<String, Object> getPageList(DataGridModel dgm, Account user) throws Exception {

		Map<String, Object> result = new HashMap<String, Object>(2);

		int total = accountMapper.getCount(user);
		List<Account> list = accountMapper.getPageList(user);

		result.put("total", total);
		result.put("rows", list);

		return result;
	}

}
