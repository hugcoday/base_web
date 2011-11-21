package com.groupcotton.common.base.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.groupcotton.common.base.dao.AccountMapper;
import com.groupcotton.common.base.vo.Account;
import com.groupcotton.common.util.DataGridModel;

@Service
public class AccountService {

	@Autowired
	private AccountMapper accountMapper;

	public Account getAccount(String username) {
		return accountMapper.getAccountByUsername(username);
	}

	public Account getAccount(String username, String password) {
		Account account = new Account();
		account.setUsername(username);
		account.setPassword(password);
		return accountMapper.getAccountByUsernameAndPassword(account);
	}

	@Transactional
	public void insertAccount(Account account) {
		accountMapper.insertAccount(account);
		accountMapper.insertProfile(account);
		accountMapper.insertSignon(account);
	}

	@Transactional
	public void updateAccount(Account account) {
		accountMapper.updateAccount(account);
		accountMapper.updateProfile(account);

		if (account.getPassword() != null && account.getPassword().length() > 0) {
			accountMapper.updateSignon(account);
		}
	}
	
	@Transactional
	public void deleteAccount(List<Integer> list) {
		accountMapper.deleteAccount(list);
	}
	 

	@SuppressWarnings("rawtypes")
	public Map<String, Object> getPageList(DataGridModel dgm, Account user) throws Exception {

		Map<String, Object> result = new HashMap<String, Object>(2);
		
		int  total = accountMapper.getCount(user);
		List<Account> list = accountMapper.getPageList(user);
		
		
		result.put("total", total);
		result.put("rows", list);

		return result;
	}

}
