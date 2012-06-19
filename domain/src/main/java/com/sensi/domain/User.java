package com.sensi.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Index;

@Entity
@Table(name="users", uniqueConstraints = {@UniqueConstraint(columnNames={"username"})} )
public class User implements Serializable {
	@Id
	@GeneratedValue
	@Column(name="user_id")
	private Long id;
	
	@Column(nullable=false, length=50, name="username")
	@Size(max=50,min=1)
	@Index(name="users_username_idx")
	private String username;
	
	@Column(nullable=false, length=150)
	@Size(max=150,min=1)
	private String password;
	
	@Column(nullable=false)
	private boolean enabled;
	
	@Column(length=50)
	private String salt;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="_group", nullable=true)
	private Group group;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
	
}
