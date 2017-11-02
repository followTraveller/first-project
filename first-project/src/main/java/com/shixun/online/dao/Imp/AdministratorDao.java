package com.shixun.online.dao.Imp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shixun.online.dao.IAdministratorDao;
import com.shixun.online.model.Account;
import com.shixun.online.model.Administrator;

@Repository("administratorDao")
public class AdministratorDao implements IAdministratorDao {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * 获取登录信息
	 */
	@Override
	public Administrator login(String administratorId, String password) {
		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("from Administrator where administratorId=?");
		query.setParameter(0, administratorId);
		List<Administrator> list = query.list();
		System.out.println(list);
		for (Administrator administrator : list) {
			return administrator;
		}

		return null;
	}

	/**
	 * 注册
	 * 
	 * @param administrator
	 * @return
	 */
	@Override
	public void register(Administrator administrator) {
		Session session = sessionFactory.getCurrentSession();

		session.save(administrator);

	}

	/**
	 * 注册前的查询
	 * 
	 * @param administrator
	 * @return
	 */
	@Override
	public int getAdministrator(String string) {
		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("from Administrator where administratorId=?");
		query.setParameter(0, string);
		List<Administrator> list = query.list();

		return list.size();
	}

	/**
	 * 保存
	 */
	@Override
	public Administrator save(Administrator administrator) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(administrator);

		System.out.println("dao层操作");
		return null;
	}

	@Override
	// 找回密码时查询密保及答案
	public Administrator checkQuestion(String administratorId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("from Administrator where administratorId=?");
		query.setParameter(0, administratorId);
		List<Administrator> list = query.list();
		for (Administrator administrator : list) {
			return administrator;
		}

		return null;
	}

	@Override
	// 修改密码
	public void updatePassword(String newPassword, String administratorId) {

		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("update Administrator set password=? where administratorId=?");
		query.setParameter(0, newPassword);
		query.setParameter(1, administratorId);
		query.executeUpdate();

	}

}
