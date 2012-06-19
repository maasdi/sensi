package com.sensi.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.apache.commons.collections.functors.FalsePredicate;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name="roles")
public class Role implements GrantedAuthority, Serializable {
	
	@Id
	@Column(length=20, name="authority")
	@Size(max=20, min=1)
	private String authority;

	public Role() {
	}
	
	public Role(final String authority) {
		this.authority = authority;
	}
	
	public String getAuthority() {
		return this.authority;
	}
	
	public void setAuthority(final String authority) {
		this.authority = authority;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((authority == null) ? 0 : authority.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (authority == null) {
			if (other.authority != null)
				return false;
		} else if (!authority.equals(other.authority))
			return false;
		return true;
	}
	
	
}
