package com.shixun.online.service;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shixun.online.dao.Imp.AdministratorDao;
import com.shixun.online.model.Administrator;

@Transactional
@Service("administratorService")
public class AdministratorService {

	@Autowired
	private AdministratorDao administratorDao;

	/**
	 * 登陆
	 * 
	 * @param administrator
	 * @return
	 */
	public int login(Administrator administrator) {

		Administrator dbadministrator = administratorDao.login(administrator.getAdministratorId(),
				administrator.getPassword());
		if (dbadministrator != null) {
			if (administrator.getAdministratorId().equals(dbadministrator.getAdministratorId())
					&& administrator.getPassword().equals(dbadministrator.getPassword())) {
				// 登录成功
				ServletActionContext.getRequest().getSession().setAttribute("currentLoginUser", dbadministrator);
				return 1;
			} else {
				// 登录名或密码错误
				return -1;
			}
		} else {
			// 用户不存在
			return 0;
		}

	}

	public int register(Administrator administrator) {
		int result = administratorDao.getAdministrator(administrator.getAdministratorId());
		if (result == 0) {
			administratorDao.register(administrator);
			return 1;
		} else {
			// 用户已存在
			return 0;

		}

	}

	public String saveAvatar(String filename, File file) {

		// 文件上传
		String realPath = ServletActionContext.getServletContext().getRealPath("/");
		String path = "avatar/" + filename;
		String fullName = realPath + path;
		File destFile = new File(fullName);
		try {
			FileUtils.copyFile(file, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 路径保存到数据库
		Administrator currentUser = (Administrator) ServletActionContext.getRequest().getSession()
				.getAttribute("currentLoginUser");
		currentUser.setAvatarPath(path);
		administratorDao.save(currentUser);

		System.out.println("service层操作");
		// 返回路径
		return path;

	}

	// 找回密码时查询密保及答案
	public int checkQuestion(Administrator administrator) {
		Administrator dbadministrator = administratorDao.checkQuestion(administrator.getAdministratorId());
		System.out.println(dbadministrator);
		if (dbadministrator.getQuestion().equals(administrator.getQuestion())
				&& dbadministrator.getAnswer().equals(administrator.getAnswer())) {
			return 1;
		} else {
			return 0;
		}
	}

	// 修改密码
	public boolean updatePassword(Administrator administrator) {
		administratorDao.updatePassword(administrator.getPassword(), administrator.getAdministratorId());
		return true;
	}
}
