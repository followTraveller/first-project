package com.shixun.online.dao;

import java.util.List;

import com.shixun.online.model.Department;

public interface IDepartmentDao {

	/**
	 *  部门添加
	 * @param department
	 */
	void saveDepartment(Department department);

	/**
	 *  更新部门信息
	 * @param department
	 * @return
	 */
	boolean updateDepartment(Department department);

	/**
	 *  删除部门信息
	 * @param id
	 */
	void removeDepartment(Integer id);

	/**
	 *  查询所有部门 ，用来做分页
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	List<Department> getdepartment(int pageNow, int pageSize);

	/**
	 *  分页
	 * @return
	 */
	int getDepartmentSize();
	
	/**
	 * 获取用户id
	 * 
	 * @return 部门
	 */
	Department get(Integer id);
}
