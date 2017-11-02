package com.shixun.online.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "db_account")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	// 用户名
	@Column(name = "account_id")
	private Long accountId;

	// 姓名
	private String accountName;

	// 密码
	private String password;

	// 手机
	private Long phone;

	// 状态
	private String state;

	// 性别
	private String gender;

	// 创建时间
	@Temporal(TemporalType.DATE)
	private Date createDate;

	// 和部门是多对一关系
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "department_id")
	// @Cascade(value = { CascadeType.SAVE_UPDATE})
	private Department department;

	// 和角色是多对一关系
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "role_id")
	// @Cascade(value = {CascadeType.SAVE_UPDATE})
	private Role role;

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(Integer id, Long accountId, String accountName, String password, Long phone, String state,
			String gender, Date createDate, Department department, Role role) {
		super();
		this.id = id;
		this.accountId = accountId;
		this.accountName = accountName;
		this.password = password;
		this.phone = phone;
		this.state = state;
		this.gender = gender;
		this.createDate = createDate;
		this.department = department;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
