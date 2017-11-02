package com.shixun.online.dao;

import java.util.List;

import com.shixun.online.model.Jurisdiction;

public interface IJurisdictionDao {

	/**
	 *  权限添加
	 * @param jurisdiction
	 */
	void saveJurisdiction(Jurisdiction jurisdiction);

	/**
	 *  更新权限信息
	 * @param jurisdiction
	 * @return
	 */
	boolean updateJurisdiction(Jurisdiction jurisdiction);

	/**
	 *  删除权限信息
	 * @param id
	 */
	void removeJurisdiction(Integer id);

	/**
	 *  查询所有权限 ，用来做分页
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	List<Jurisdiction> getjurisdiction(int pageNow, int pageSize);

	/**
	 *  分页
	 * @return
	 */
	int getJurisdictionSize();

	/**
	 * 获取权限id
	 * 
	 * @return 部门
	 */
	Jurisdiction get(Integer id);
}
