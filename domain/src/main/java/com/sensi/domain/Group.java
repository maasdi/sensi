package com.sensi.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Index;

@Entity
@Table(name = "groups")
public class Group implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "groups_id")
	private Long id;

	@Column(nullable = false, length = 50, name = "name")
	@Index(name = "groups_name_idx")
	private String name;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE })
	@JoinTable(name = "groups_authority", joinColumns = { @JoinColumn(name = "groups_id") }, inverseJoinColumns = @JoinColumn(name = "authority"))
	private List<Role> roles = new ArrayList<Role>();

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

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
}
