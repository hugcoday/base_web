package com.groupcotton.common.base.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.groupcotton.common.base.vo.Account;


public interface AccountMapper {

  static final Log LOG = LogFactory.getLog(AccountMapper.class);
  
  Account getAccountByUsername(String accountcode);

  Account getAccountByUsernameAndPassword(Account account);

  void insertAccount(Account account);
  

  void updateAccount(Account account);

  
  void deleteAccount(List<Integer> list);
  
  List<Account> getPageList(Account account);
  
  int getCount(Account account);
 

}
