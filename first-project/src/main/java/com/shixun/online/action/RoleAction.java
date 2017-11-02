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
import com.shixun.online.model.Jurisdiction;
import com.shixun.online.model.PageShow;
import com.shixun.online.model.Role;
import com.shixun.online.service.RoleService;

@Namespace("/") // @Namespace来代替<package namespace="">
@ParentPackage("base") // @ParentPackage来代替<package extends=””>
@Controller("roleAction")
public class RoleAction extends ActionSupport {

	@Autowired
	private RoleService roleService;

	private List<Role> listRole;
	private List<Jurisdiction> listJurisdiction;
	private Role role;
	private Integer id;
	private String message;

	// 动态改变 页面取得
	private int pageNow = 1;
	// 固定不变
	private int pageSize = 6;

	/**
	 *  获取role列表
	 * @return
	 */
	@Action(value = "roleManage", results = { @Result(name = "success", location = "/WEB-INF/views/rolemanage.jsp") })
	public String roleManage() {
		listRole = roleService.getrole(pageNow, pageSize);
		if (listRole.size() > 0) {
			Map session = ActionContext.getContext().getSession();
			Map request = (Map) ActionContext.getContext().get("request");
			// 保存在session
			session.put("listRole", listRole);
			PageShow page = new PageShow(pageNow, roleService.getRoleSize(), pageSize);

			// 保存到request
			request.put("page", page);
			return "success";
		}
		return "fail";
	}

	/**
	 *  保存
	 * @return
	 */
	@Action(value = "addrole", results = { @Result(name = "success", location = "/WEB-INF/views/rolemanage.jsp") })
	public String addRole() {
		roleService.saveRole(role);
		return "success";
	}

	/**
	 *  跳转到保存
	 * @return
	 */
	@Action(value = "toaddrole", results = { @Result(name = "success", location = "/WEB-INF/views/addrole.jsp") })
	public String toAddRole() {
		listJurisdiction = roleService.getJurisdiction();
		return "success";
	}

	/**
	 *  删除
	 * @return
	 */
	@Action(value = "removeRole", results = { @Result(name = "success", location = "/WEB-INF/views/rolemanage.jsp") })
	public String removeRole() {
		roleService.removeRole(id);
		return "success";
	}

	/**
	 * 跳转到编辑角色界面，并且根据id获取内容（编辑）
	 * 
	 * @return
	 */
	@Action(value = "eidtRole", results = { @Result(name = "success", location = "/WEB-INF/views/editrole.jsp") })
	public String eidtRole() {
		listJurisdiction = roleService.getJurisdiction();
		role = roleService.get(id);
		if (id != null) {
			return "success";
		}
		return "fail";
	}

	/**
	 * 保存编辑户后的角色信息（保存）
	 * 
	 * @return
	 */
	@Action(value = "updateRole", results = { @Result(name = "success", type = "json"),
			@Result(name = "fail", type = "json") })
	public String updateRole() {
		Role role1 = roleService.get(id);
		if (role1 != null) {

			role1.setRoleName(role.getRoleName());
			role1.setDescription(role.getDescription());
			role1.setCreateDate(new Date());

			roleService.updateRole(role1);

			message = "success";
			return "success";
		}
		message = "fail";
		return "fail";
	}

	public List<Role> getListRole() {
		return listRole;
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

	public void setListRole(List<Role> listRole) {
		this.listRole = listRole;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Jurisdiction> getListJurisdiction() {
		return listJurisdiction;
	}

	public void setListJurisdiction(List<Jurisdiction> listJurisdiction) {
		this.listJurisdiction = listJurisdiction;
	}

	public String getMessage() {
		return message;
	}

}
