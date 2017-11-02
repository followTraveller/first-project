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
import com.shixun.online.model.Department;
import com.shixun.online.model.PageShow;
import com.shixun.online.service.AccountService;
import com.shixun.online.service.DepartmentService;

@Namespace("/") // @Namespace来代替<package namespace="">
@ParentPackage("base") // @ParentPackage来代替<package extends=””>
@Controller("departmentAction")
public class DepartmentAction extends ActionSupport {

	@Autowired
	private DepartmentService departmentService;

	private List<Department> listDepartment;
	private Department department;
	private Integer id;
	private String message;

	// 动态改变 页面取得
	private int pageNow = 1;
	// 固定不变
	private int pageSize = 6;

	/**
	 *  获取信息列表
	 * @return
	 */
	@Action(value = "departmentManage", results = {
			@Result(name = "success", location = "/WEB-INF/views/departmentmanage.jsp") })
	public String departmentManage() {
		listDepartment = departmentService.getdepartment(pageNow, pageSize);
		if (listDepartment.size() > 0) {
			Map session = ActionContext.getContext().getSession();
			Map request = (Map) ActionContext.getContext().get("request");
			// 保存在session
			session.put("listDepartment", listDepartment);
			PageShow page = new PageShow(pageNow, departmentService.getDepartmentSize(), pageSize);
			// 保存到request
			request.put("page", page);
			return "success";
		}
		return "fail";
	}

	/**
	 *  跳转到添加页面
	 * @return
	 */
	@Action(value = "toadddepartment", results = {
			@Result(name = "success", location = "/WEB-INF/views/adddepartment.jsp") })
	public String addDepartment() {
		return "success";
	}

	/**
	 *  保存
	 * @return
	 */
	@Action(value = "adddepartment", results = {
			@Result(name = "success", location = "/WEB-INF/views/departmentmanage.jsp") })
	public String saveDepartment() {
		departmentService.saveDepartment(department);
		return "success";
	}

	/**
	 *  删除
	 * @return
	 */
	@Action(value = "removeDepartment", results = {
			@Result(name = "success", location = "/WEB-INF/views/departmentmanage.jsp") })
	public String removeDepartment() {
		departmentService.removeDepartment(id);
		return "success";
	}

	/**
	 * 跳转到编辑部门(编辑)
	 * 
	 * @return
	 */
	@Action(value = "eidtDepartment", results = {
			@Result(name = "success", location = "/WEB-INF/views/editdepartment.jsp") })
	public String editDepartment() {
		if (id != null) {
			department = departmentService.get(id);
			return "success";
		}
		return "fail";
	}

	/**
	 * 更新编辑过的部门信息（保存）
	 * 
	 * @return
	 */
	@Action(value = "updateDepartment", results = { @Result(name = "success", type = "json"),
			@Result(name = "fail", type = "json") })
	public String updateDepartment() {

		Department department1 = departmentService.get(id);
		if (department1 != null) {

			department1.setDepartmentName(department.getDepartmentName());
			department1.setDescription(department.getDescription());
			department1.setCreateDate(new Date());
			departmentService.updateDepartment(department1);

			message = "success";
			return "success";
		}
		message = "fail";
		return "fail";
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

	public List<Department> getListDepartment() {
		return listDepartment;
	}

	public void setListDepartment(List<Department> listDepartment) {
		this.listDepartment = listDepartment;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}
}
