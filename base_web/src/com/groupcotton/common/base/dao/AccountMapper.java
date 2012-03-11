package com.groupcotton.common.base.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.groupcotton.common.base.vo.Account;


public interface AccountMapper {

 
  
  Account getAccountByUsername(String accountcode) throws Exception ;

  Account getAccountByUsernameAndPassword(Account account) throws Exception ;

  void insertAccount(Account account) throws Exception ;
  

  void updateAccount(Account account) throws Exception ;

  
  void deleteAccount(List<Integer> list) throws Exception ;
  
  List<Account> getPageList(Account account) throws Exception ;
  
  int getCount(Account account) throws Exception ;
 

}
