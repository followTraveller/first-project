package com.shixun.online.dao.Imp;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shixun.online.dao.IJurisdictionDao;
import com.shixun.online.model.Department;
import com.shixun.online.model.Jurisdiction;

@Repository("jurisdictionDao")
public class JurisdictionDao implements IJurisdictionDao {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * 更新
	 */
	@Override
	public boolean updateJurisdiction(Jurisdiction jurisdiction) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(jurisdiction);
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
	public void removeJurisdiction(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Jurisdiction jurisdiction = (Jurisdiction) session.get(Jurisdiction.class, id);
		session.delete(jurisdiction);
	}

	/**
	 * 查询权限列表
	 */
	@Override
	public List<Jurisdiction> getjurisdiction(int pageNow, int pageSize) {
		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("from Jurisdiction");
		query.setFirstResult((pageNow - 1) * pageSize);
		query.setMaxResults(pageSize);
		List<Jurisdiction> listJurisdiction = query.list();

		if (listJurisdiction.size() > 0) {
			return listJurisdiction;
		}

		return null;
	}

	/**
	 * 分页
	 */
	@Override
	public int getJurisdictionSize() {
		Session session = sessionFactory.getCurrentSession();

		int size = session.createQuery("from Jurisdiction").list().size();

		return size;
	}

	/**
	 * 保存权限
	 */
	@Override
	public void saveJurisdiction(Jurisdiction jurisdiction) {
		Session session = sessionFactory.getCurrentSession();
		jurisdiction.setCreateDate(new Date());
		session.save(jurisdiction);
	}

	/**
	 * 获取id
	 */
	@Override
	public Jurisdiction get(Integer id) {
		return (Jurisdiction) sessionFactory.getCurrentSession().get(Jurisdiction.class, id);
	}

}
