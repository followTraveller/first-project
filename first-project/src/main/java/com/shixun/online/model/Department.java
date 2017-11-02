package com.shixun.online.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "db_department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String departmentName;

	private String description;

	@Temporal(TemporalType.DATE)
	private Date createDate;

	// 和用户一对多关系
	@OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
	// @Cascade(value = { CascadeType.SAVE_UPDATE })
	private Set<Account> accounts = new HashSet<Account>();

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(Integer id, String departmentName, String description, Date createDate, Set<Account> accounts) {
		super();
		this.id = id;
		this.departmentName = departmentName;
		this.description = description;
		this.createDate = createDate;
		this.accounts = accounts;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

}
