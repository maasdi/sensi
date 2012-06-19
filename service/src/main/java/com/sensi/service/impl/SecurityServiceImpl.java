package com.sensi.service.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.sensi.domain.Group;
import com.sensi.domain.Role;
import com.sensi.domain.User;
import com.sensi.service.SecurityService;

@Service("securityService")
@Transactional
public class SecurityServiceImpl implements SecurityService {

	@Autowired
	private SessionFactory sessionFactory;

	public Long countGroups() {
		return (Long) sessionFactory.getCurrentSession().createQuery(
				"select count(o) from Group o").uniqueResult();
	}

	public Long countGroupsByName(String name) {
		if (!StringUtils.hasText(name))
			return 0L;
		return (Long) sessionFactory.getCurrentSession().createQuery(
				"select count(o) from Group o where o.name like :name")
				.setString("name", "%" + name + "%").uniqueResult();
	}

	public Long countRoles() {
		return (Long) sessionFactory.getCurrentSession().createQuery(
				"select count(o) from Role o").uniqueResult();
	}

	public Long countUsers() {
		return (Long) sessionFactory.getCurrentSession().createQuery("select count(o) from User o").uniqueResult();
	}

	public Long countUsersByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Role role) {
		if (role != null && role.getAuthority() != null) {
			sessionFactory.getCurrentSession().delete(role);
		}
	}

	public void delete(Group group) {
		// TODO Auto-generated method stub

	}

	public void delete(User user) {
		// TODO Auto-generated method stub

	}

	public Group findGroup(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Group> findGroups() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Group> findGroupsByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public Role findRole(String authority) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Role> findRoles() {
		// TODO Auto-generated method stub
		return null;
	}

	public User findUser(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> findUsers() {
		return sessionFactory.getCurrentSession().createQuery("from User o order by o.username").list();
	}

	public List<User> findUsersByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(Role role) {
		sessionFactory.getCurrentSession().saveOrUpdate(role);
	}

	public void save(Group group) {
		// TODO Auto-generated method stub

	}

	public void save(User user) {
		// TODO Auto-generated method stub

	}

}
