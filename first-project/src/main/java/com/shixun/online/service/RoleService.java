package com.shixun.online.service;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shixun.online.dao.Imp.RoleDao;
import com.shixun.online.model.Jurisdiction;
import com.shixun.online.model.Role;

@Transactional
@Service("roleService")
public class RoleService {

	@Autowired
	private RoleDao roleDao;

	/**
	 *  获取角色信息
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public List<Role> getrole(int page, int pageSize) {
		List<Role> listRole = roleDao.getrole(page, pageSize);
		return listRole;
	}

	/**
	 *  分页
	 * @return
	 */
	public int getRoleSize() {
		int roleSize = roleDao.getRoleSize();
		return roleSize;
	}

	/**
	 *  获取权限列表
	 * @return
	 */
	public List<Jurisdiction> getJurisdiction() {
		List<Jurisdiction> listJurisdiction = roleDao.getJurisdiction();
		return listJurisdiction;
	}

	/**
	 *  保存
	 * @param role
	 */
	public void saveRole(Role role) {
		roleDao.saveRole(role);
	}

	/**
	 *  删除
	 * @param id
	 */
	public void removeRole(Integer id) {
		roleDao.removeRole(id);
	}

	/**
	 *  获取编辑id
	 * @param id
	 * @return
	 */
	public Role get(Integer id) {
		return roleDao.get(id);
	}

	/**
	 *  更新
	 * @param role
	 * @return
	 */
	public boolean updateRole(Role role) {
		if (roleDao.updateRole(role)) {
			return true;
		} else {
			return false;
		}
	}
}
