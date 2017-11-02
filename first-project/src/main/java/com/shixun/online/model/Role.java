package com.shixun.online.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "db_role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String roleName;

	private String description;

	@Temporal(TemporalType.DATE)
	private Date createDate;

	// 和用户是一对多关系
	@OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
	// @Cascade(value = { CascadeType.SAVE_UPDATE })
	private Set<Account> accounts = new HashSet<Account>();

	// 和权限是多对多关系
	@ManyToMany(targetEntity = Jurisdiction.class, fetch = FetchType.LAZY)
	@JoinTable(name = "role_jurisdiction", joinColumns = {
			@JoinColumn(name = "role_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "jurisdiction_id", referencedColumnName = "id") })
	//@Cascade(CascadeType.ALL)
	private Set<Jurisdiction> jurisdictions = new HashSet<Jurisdiction>();

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(Integer id, String roleName, String description, Date createDate, Set<Account> accounts,
			Set<Jurisdiction> jurisdictions) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.description = description;
		this.createDate = createDate;
		this.accounts = accounts;
		this.jurisdictions = jurisdictions;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
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

	public Set<Jurisdiction> getJurisdictions() {
		return jurisdictions;
	}

	public void setJurisdictions(Set<Jurisdiction> jurisdictions) {
		this.jurisdictions = jurisdictions;
	}

}
