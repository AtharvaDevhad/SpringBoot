package com.sha.serverside.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "ath_user")
public class AthUser implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Enumerated(EnumType.STRING)
	@Column(name = "role")
	private AthRole role;

//	public CharSequence getPassword() {
//		// TODO Auto-generated method stub
//		return null;
//	}

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public AthRole getRole() {
		return role;
	}

	public void setRole(AthRole role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String encode) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return "AthUser [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password + ", role="
				+ role + "]";
	}

	public AthUser(Long id, String name, String username, String password, AthRole role) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public AthUser orElse(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

}
