package com.shixun.online.dao;

import java.util.List;

import com.shixun.online.model.Account;
import com.shixun.online.model.Department;
import com.shixun.online.model.Role;

public interface IAccountDao {

	/**
	 *  用户添加
	 * @param account
	 */
	void saveAccount(Account account);

	/**
	 *  更新用户信息
	 * @param account
	 * @return
	 */
	boolean updateAccount(Account account);

	/**
	 *  删除用户信息
	 * @param id
	 */
	void removeAccount(Integer id);

	/**
	 *  查询所有用户 ，用来做分页
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	List<Account> getaccount(int pageNow, int pageSize);

	/**
	 *  获取department
	 * @return
	 */
	List<Department> getdepartment();

	/**
	 *  获取role
	 * @return
	 */
	List<Role> getrole();

	/**
	 *  分页
	 * @return
	 */
	int getAccountSize();
	
	/**
	 * 获取用户id,用户编辑
	 * 
	 * @return 用户
	 */
	Account get(Integer id);
}
