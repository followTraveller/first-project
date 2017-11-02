package com.shixun.online.action;

import java.io.File;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.shixun.online.model.Administrator;
import com.shixun.online.service.AdministratorService;

@Namespace("/") // @Namespace来代替<package namespace="">
@ParentPackage("base") // @ParentPackage来代替<package extends=””>
@Controller("administratorAction")
public class AdministratorAction {
	@Autowired
	private AdministratorService administratorService;

	private Administrator administrator;

	private String message;

	private File upload;

	private String uploadContentType;

	private String uploadFileName;

	private String imgPath;
	
	private String administratorId;

	/**
	 * 跳转到登陆界面
	 * 
	 * @return
	 */
	@Action(value = "toLogin", results = { @Result(name = "success", location = "/WEB-INF/login.jsp") })
	public String toLogin() {
		return "success";
	}

	/**
	 * 用户登录
	 * 
	 * @return
	 */
	@Action(value = "login", results = { @Result(name = "success", location = "/WEB-INF/views/index.jsp"),
			@Result(name = "fail", location = "/WEB-INF/login.jsp") })
	public String login() {
		// TODO 需要把登陆方法产生的各种情况描述出来，也就是登陆密码错误，登录名不存在等
		if (administratorService.login(administrator) == 1) {
			Administrator currentUser = (Administrator) ServletActionContext.getRequest().getSession()
					.getAttribute("currentLoginUser");
			administrator.setAvatarPath(currentUser.getAvatarPath());
			return "success";
		} else if (administratorService.login(administrator) == -1) {
			message = "用户名或密码错误！！请重新输入！！";
			return "fail";
		} else {
			message = "该用户不存在！！请注册！！";
			return "fail";
		}

	}

	/**
	 * 用户注册
	 * 
	 * @return
	 */
	@Action(value = "register", results = { @Result(name = "success", location = "/WEB-INF/login.jsp"),
			@Result(name = "fail", location = "/WEB-INF/login.jsp") })
	public String register() {
		if (administratorService.register(administrator) == 1) {
			message = "注册成功，可以登录！";
			return "success";
		} else {
			message = "注册失败，该用户已存在！！";
			return "fail";
		}

	}

	// 跳转到密保界面
	@Action(value = "toCheckQuestion", results = {
			@Result(name = "success", location = "/WEB-INF/views/confirmQuestion.jsp") })
	public String toCheckQuestion() {
		return "success";
	}

	// 查询密保及答案
	@Action(value = "checkQuestion", results = { @Result(name = "success", location = "/WEB-INF/views/newPassword.jsp"),
			@Result(name = "fail", location = "/WEB-INF/views/confirmQuestion.jsp") })
	public String checkQuestion() {
		int result = administratorService.checkQuestion(administrator);
		administratorId=administrator.getAdministratorId();
		if (result == 1) {
			return "success";
		} else {
			return "fail";
		}

	}

	@Action(value = "updatePassword", results = { @Result(name = "success", location = "/WEB-INF/login.jsp"),
			@Result(name = "fail", location = "/WEB-INF/views/newPassword.jsp") })
	public String updatePassword() {
		boolean result = administratorService.updatePassword(administrator);
		if (result == true) {
			return "success";
		} else {
			return "fail";
		}

	}

	/**
	 * 上传头像
	 */
	@Action(value = "saveAvatar", results = { @Result(name = "success", type = "json") })
	public String saveAvatar() {

		imgPath = administratorService.saveAvatar(uploadFileName, upload);
		return "success";
	}

	public Administrator getAdministrator() {
		return administrator;
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getAdministratorId() {
		return administratorId;
	}

	public void setAdministratorId(String administratorId) {
		this.administratorId = administratorId;
	}

	
	
}
