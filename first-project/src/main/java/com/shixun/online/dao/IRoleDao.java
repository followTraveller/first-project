package com.shixun.online.dao;

import java.util.List;

import com.shixun.online.model.Jurisdiction;
import com.shixun.online.model.Role;

public interface IRoleDao {

	/**
	 * 添加
	 * @param role
	 */
	void saveRole(Role role);

	/**
	 *  更新
	 * @param role
	 * @return
	 */
	boolean updateRole(Role role);

	/**
	 *  删除
	 * @param id
	 */
	void removeRole(Integer id);

	/**
	 *  获取权限项
	 * @return
	 */
	List<Jurisdiction> getJurisdiction();

	/**
	 *  获取分页
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	List<Role> getrole(int pageNow, int pageSize);

	/**
	 *  需要用到分页。
	 * @return
	 */
	int getRoleSize();

	/**
	 * 获取用户id,部门编辑
	 * 
	 * @return 部门
	 */
	Role get(Integer id);
}
