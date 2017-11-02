package com.shixun.online.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shixun.online.dao.Imp.AccountDao;
import com.shixun.online.model.Account;
import com.shixun.online.model.Department;
import com.shixun.online.model.Role;

@Transactional
@Service("accountService")
public class AccountService {

	@Autowired
	private AccountDao accountDao;

	/**
	 * 查询所有用户信息
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public List<Account> getaccount(int page, int pageSize) {
		List<Account> listAccount = accountDao.getaccount(page, pageSize);
		return listAccount;
	}

	/**
	 * 分页
	 * @return
	 */
	public int getAccountSize() {
		int accountSize = accountDao.getAccountSize();
		return accountSize;
	}
	
	/**
	 * 删除用户
	 * @param id
	 */
	public void removeAccount(Integer id) {
		accountDao.removeAccount(id);
	}
	
	/**
	 * 保存用户
	 * @param account
	 */
	public void saveAccount(Account account) {
		accountDao.saveAccount(account);
	}
	
	/**
	 * 获取department
	 * @return
	 */
	public List<Department> getdepartment(){
		List<Department> listDepartment = accountDao.getdepartment();
		return listDepartment;
	}
	
	/**
	 * 获取role
	 * @return
	 */
	public List<Role> getrole(){
		List<Role> listRole = accountDao.getrole();
		return listRole;
	}
	
	/**
	 * 获取编辑id
	 * @param id
	 * @return
	 */
	public Account get(Integer id) {
		return accountDao.get(id);
	}

	/**
	 * 更新
	 * @param account
	 * @return
	 */
	public boolean updateAccount(Account account) {
		if (accountDao.updateAccount(account)) {
			return true;
		} else {
			return false;
		}
	}
}