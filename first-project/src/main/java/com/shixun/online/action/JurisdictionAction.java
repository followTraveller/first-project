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
import com.shixun.online.service.JurisdictionService;

@Namespace("/") // @Namespace来代替<package namespace="">
@ParentPackage("base") // @ParentPackage来代替<package extends=””>
@Controller("jurisdictionAction")
public class JurisdictionAction extends ActionSupport {

	@Autowired
	private JurisdictionService jurisdictionService;

	private List<Jurisdiction> listJurisdiction;

	private Jurisdiction jurisdiction;

	private Integer id;

	private String message;

	// 动态改变 页面取得
	private int pageNow = 1;
	// 固定不变
	private int pageSize = 6;

	@Action(value = "jurisdictionManage", results = {
			@Result(name = "success", location = "/WEB-INF/views/jurisdictionmanage.jsp") })
	public String jurisdictionManage() {
		listJurisdiction = jurisdictionService.getjurisdiction(pageNow, pageSize);
		if (listJurisdiction.size() > 0) {
			Map session = ActionContext.getContext().getSession();
			Map request = (Map) ActionContext.getContext().get("request");
			// 保存在session
			session.put("listJurisdiction", listJurisdiction);
			PageShow page = new PageShow(pageNow, jurisdictionService.getJurisdictionSize(), pageSize);
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
	@Action(value = "addJurisdiction", results = {
			@Result(name = "success", location = "/WEB-INF/views/jurisdictionmanage.jsp") })
	public String addJurisdiction() {
		jurisdictionService.saveJurisdiction(jurisdiction);
		return "success";
	}

	/**
	 *  跳转到保存
	 * @return
	 */
	@Action(value = "toAddjurisdiction", results = {
			@Result(name = "success", location = "/WEB-INF/views/addjurisdiction.jsp") })
	public String toAddJurisdiction() {
		return "success";
	}

	/**
	 *  删除
	 * @return
	 */
	@Action(value = "removeJurisdiction", results = {
			@Result(name = "success", location = "/WEB-INF/views/jurisdictionmanage.jsp") })
	public String removeJurisdiction() {
		jurisdictionService.removeJurisdiction(id);
		return "success";
	}

	/**
	 * 跳转到编辑权限的页面，并根据id获取内容（编辑）
	 * 
	 * @return
	 */
	@Action(value = "eidtJurisdiction", results = {
			@Result(name = "success", location = "/WEB-INF/views/editjurisdiction.jsp") })
	public String editJurisdiction() {
		if (id != null) {
			jurisdiction = jurisdictionService.get(id);
			return "success";
		} else {
			return "fail";
		}
	}

	/**
	 * 保存编辑过的权限信息（保存）
	 * 
	 * @return
	 */
	@Action(value = "updateJurisdiction", results = { @Result(name = "success", type = "json"),
			@Result(name = "fail", type = "json") })
	public String updateJurisdiction() {

		Jurisdiction jurisdiction1 = jurisdictionService.get(id);

		if (jurisdiction1 != null) {

			jurisdiction1.setJurisdictionName(jurisdiction.getJurisdictionName());
			jurisdiction1.setDescription(jurisdiction.getDescription());
			// jurisdiction1.setRoles(jurisdiction.getRoles());
			jurisdiction1.setCreateDate(new Date());

			jurisdictionService.updateJurisdiction(jurisdiction1);

			message = "success";
			return "success";
		} else {
			message = "fail";
			return "fail";
		}
	}

	public List<Jurisdiction> getListJurisdiction() {
		return listJurisdiction;
	}

	public void setListJurisdiction(List<Jurisdiction> listJurisdiction) {
		this.listJurisdiction = listJurisdiction;
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

	public Jurisdiction getJurisdiction() {
		return jurisdiction;
	}

	public void setJurisdiction(Jurisdiction jurisdiction) {
		this.jurisdiction = jurisdiction;
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
