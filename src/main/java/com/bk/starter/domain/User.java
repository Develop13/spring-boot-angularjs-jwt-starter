package com.bk.starter.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Email;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@Email
	private String email;
	
	private String username;
	
	private String password;
	
	private Long createdDate;

	private Long modifiedDate;
	
	private Long createdBy;

	private Long modifiedBy;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Long getCreatedDate() {
		return createdDate;
	}
	
	public void setCreatedDate(Long createdDate) {
		this.createdDate = createdDate;
	}
	
	public Long getModifiedDate() {
		return modifiedDate;
	}
	
	public void setModifiedDate(Long modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	public Long getCreatedBy() {
		return createdBy;
	}
	
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	
	public Long getModifiedBy() {
		return modifiedBy;
	}
	
	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
}