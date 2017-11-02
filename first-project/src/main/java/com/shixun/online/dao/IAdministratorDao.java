package com.shixun.online.dao;

import com.shixun.online.model.Administrator;

public interface IAdministratorDao {

	/**
	 * 用户登录
	 * 
	 * @param 从Form表单里获取的用户Id
	 *            和密码
	 * @return
	 */
	Administrator login(String administratorId, String password);

	/**
	 * 注册前的查询
	 * 
	 * @param administratorId
	 * @return
	 */
	int getAdministrator(String administratorId);

	/**
	 * 注册
	 * 
	 * @param administrator
	 * @return
	 */
	void register(Administrator administrator);
	
	
	/**
	 * 保存
	 * @param administrator
	 * @return
	 */
	Administrator save (Administrator administrator) ;
		
	//找回密码时查询密保
	Administrator checkQuestion(String administratorId);
	
	//修改密码
	void updatePassword(String newPassword,String administratorId);
	
	
}
