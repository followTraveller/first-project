package com.shixun.online.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.shixun.online.model.Account;
import com.shixun.online.model.Department;
import com.shixun.online.model.PageShow;
import com.shixun.online.model.Role;
import com.shixun.online.service.AccountService;

@Namespace("/") // @Namespace来代替<package namespace="">
@ParentPackage("base") // @ParentPackage来代替<package extends=””>
@Controller("accountAction")
public class AccountAction extends ActionSupport {

	@Autowired
	private AccountService accountService;

	private List<Account> listAccount;
	private List<Department> listDepartment;
	private List<Role> listRole;
	private Integer id;
	private Account account;
	private String message;

	private int page;
	// 动态改变 页面取得
	private int pageNow = 1;
	// 固定不变
	private int pageSize = 6;

	/**
	 *  查询用户
	 * @return
	 */
	@Action(value = "accountManage", results = {
			@Result(name = "success", location = "/WEB-INF/views/accountmanage.jsp") })
	public String accountManage() {
		listAccount = accountService.getaccount(pageNow, pageSize);
		if (listAccount.size() > 0) {
			Map session = ActionContext.getContext().getSession();
			Map request = (Map) ActionContext.getContext().get("request");
			// 保存在session
			session.put("listAccount", listAccount);
			PageShow page = new PageShow(pageNow, accountService.getAccountSize(), pageSize);
			// 保存到request
			request.put("page", page);
			
			return "success";
		}
		return "fail";
	}

	/**
	 *  添加用户
	 * @return
	 */
	@Action(value = "addaccount", results = {
			@Result(name = "success", type="json") })
	public String addAccount() {
		accountService.saveAccount(account);
		return "success";
	}

	/**
	 *  跳转到添加用户
	 * @return
	 */
	@Action(value = "toAddaccount", results = { @Result(name = "success", location = "/WEB-INF/views/addaccount.jsp")  })
	public String toAddAccount() {
		
		listDepartment = accountService.getdepartment();
		listRole = accountService.getrole();
		
		return "success";
	}

	/**
	 *  删除用户
	 * @return
	 */
	@Action(value = "removeAccount", results = { @Result(name = "success", type = "json") })
	public String removeAccount() {
		accountService.removeAccount(id);
		return "success";
	}

	/**
	 * 跳转到编辑账户界面并根据id获取内容
	 */
	@Action(value = "eidtAccount", results = { @Result(name = "success", location = "/WEB-INF/views/editaccount.jsp") })
	public String eidtAccount() {

		listDepartment = accountService.getdepartment();
		listRole = accountService.getrole();

		if (id != null) {
			account = accountService.get(id);
			return "success";
		}
		return "fail";
	}

	/**
	 * 保存编辑过的用户信息（保存）
	 */
	@Action(value = "updateAccount", results = { @Result(name = "success", type = "json"),
			@Result(name = "fail", type = "json") })
	public String updateAccount() {

		Account account1 = accountService.get(id);

		if (account1 != null) {

			account1.setAccountId(account.getAccountId());
			account1.setAccountName(account.getAccountName());
			account1.setPassword(account.getPassword());
			account1.setPhone(account.getPhone());
			account1.setState(account.getState());
			account1.setGender(account.getGender());
			account1.setCreateDate(new Date());
			account1.setDepartment(account.getDepartment());
			account1.setRole(account.getRole());

			accountService.updateAccount(account1);

			message = "success";
			return "success";

		}
		message = "fail";
		return "fail";
	}

	/**
	 *  退出
	 * @return
	 */
	@Action(value = "returnLogin", results = { @Result(name = "success", location = "/WEB-INF/login.jsp") })
	public String returnLogin() {
		return "success";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Account> getListAccount() {
		return listAccount;
	}

	public void setListAccount(List<Account> listAccount) {
		this.listAccount = listAccount;
	}

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<Department> getListDepartment() {
		return listDepartment;
	}

	public void setListDepartment(List<Department> listDepartment) {
		this.listDepartment = listDepartment;
	}

	public List<Role> getListRole() {
		return listRole;
	}

	public void setListRole(List<Role> listRole) {
		this.listRole = listRole;
	}

	public String getMessage() {
		return message;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}