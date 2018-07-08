package com.neusoft.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="Permission")
public class Permission {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "permissionId")
	private int id;
	
	@Column(name = "permission")
	private String permission;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}
	
}
