package com.groupcotton.common.base.dao;

import java.util.List;

import com.groupcotton.common.base.vo.Account;


public interface AccountMapper {

  Account getAccountByUsername(String username);

  Account getAccountByUsernameAndPassword(Account account);

  void insertAccount(Account account);
  

  void updateAccount(Account account);

  
  void deleteAccount(List<Integer> list);
  
  List<Account> getPageList(Account account);
  
  int getCount(Account account);
 

}
