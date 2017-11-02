package com.shixun.online.dao.Imp;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shixun.online.dao.IAccountDao;
import com.shixun.online.model.Account;
import com.shixun.online.model.Department;
import com.shixun.online.model.Role;

@Repository("accountDao")
public class AccountDao implements IAccountDao {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 *  保存用户
	 */
	@Override
	public void saveAccount(Account account) {
		Session session = sessionFactory.getCurrentSession();
		account.setCreateDate(new Date());
		session.save(account);
	}

	/**
	 *  更新
	 */
	@Override
	public boolean updateAccount(Account account) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(account);
			return true;
		} catch (Exception e) {
			System.out.println("出现异常!!!");
		}
		return false;
	}

	/**
	 *  删除
	 */
	@Override
	public void removeAccount(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Account account = (Account) session.get(Account.class, id);
		session.delete(account);
	}

	/**
	 *  查询用户列表
	 */
	@Override
	public List<Account> getaccount(int pageNow, int pageSize) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Account");
		query.setFirstResult((pageNow - 1) * pageSize);
		query.setMaxResults(pageSize);
		List<Account> listAccount = query.list();
		if (listAccount.size() > 0) {
			return listAccount;
		}
		return null;
	}

	/**
	 *  分页
	 */
	public int getAccountSize() {
		Session session = sessionFactory.getCurrentSession();
		int size = session.createQuery("from Account").list().size();
		return size;
	}

	/**
	 *  获取department列表
	 */
	@Override
	public List<Department> getdepartment() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Department");
		List<Department> listDepartment = query.list();
		return listDepartment;
	}

	/**
	 *  获取role列表
	 */
	@Override
	public List<Role> getrole() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Role");
		List<Role> listRole = query.list();
		return listRole;
	}

	/**
	 * 获取id，用于编辑
	 */
	@Override
	public Account get(Integer id) {
		return (Account) sessionFactory.getCurrentSession().get(Account.class, id);
	}

}