package com.shixun.online.dao.Imp;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shixun.online.dao.IRoleDao;
import com.shixun.online.model.Jurisdiction;
import com.shixun.online.model.Role;

@Repository("roleDao")
public class RoleDao implements IRoleDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * 保存
	 */
	@Override
	public void saveRole(Role role) {
		Session session = sessionFactory.getCurrentSession();
		role.setCreateDate(new Date());
		session.save(role);	
	}

	/**
	 * 更新
	 */
	@Override
	public boolean updateRole(Role role) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(role);
			return true;
		} catch (Exception e) {
			System.out.println("出现异常!!!");
		}
		return false;
	}

	/**
	 * 删除
	 */
	@Override
	public void removeRole(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Role role = (Role) session.get(Role.class, id);
		session.delete(role);
	}

	
	/**
	 * 查询role
	 */
	@Override
	public List<Role> getrole(int pageNow, int pageSize) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Role");
		query.setFirstResult((pageNow - 1) * pageSize);
		query.setMaxResults(pageSize);
		List<Role> listRole = query.list();
		if (listRole.size() > 0) {
			return listRole;
		}
		return null;
	}

	/**
	 * 分页
	 */
	@Override
	public int getRoleSize() {
		Session session = sessionFactory.getCurrentSession();
		int size = session.createQuery("from Role").list().size();
		return size;
	}
	
	/**
	 *  获取权限列表
	 */
	@Override
	public List<Jurisdiction> getJurisdiction() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Jurisdiction");
		List<Jurisdiction> listJurisdiction = query.list();
		return listJurisdiction;
	}

	/**
	 * 获取id
	 */
	@Override
	public Role get(Integer id) {
		return (Role) sessionFactory.getCurrentSession().get(Role.class, id);
	}
	
}
