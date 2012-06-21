package com.sensi.service.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
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
	@Autowired
	private PasswordEncoder passwordEncoder;

	public Long countGroups() {
		return (Long) sessionFactory.getCurrentSession().createQuery("select count(o) from Group o").uniqueResult();
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
		if (!StringUtils.hasText(username))
			return 0L;
		return (Long) sessionFactory.getCurrentSession().createQuery("select count(o) from User o where o.username = :username").setString("username", username).uniqueResult();
	}

	public void delete(Role role) {
		if (role != null && role.getAuthority() != null) {
			sessionFactory.getCurrentSession().delete(role);
		}
	}

	public void delete(Group group) {
		if (group != null && group.getId() != null){
			sessionFactory.getCurrentSession().delete(group);
		}
	}

	public void delete(User user) {
		if (user != null && user.getId() != null){
			sessionFactory.getCurrentSession().delete(user);
		}
	}

	public Group findGroup(Long id) {
		return (Group) sessionFactory.getCurrentSession().createQuery("select o from Group o where o.id = :id").setLong("id", id).uniqueResult();
	}

	public List<Group> findGroups() {
		return sessionFactory.getCurrentSession().createQuery("select o from Group o order by o.id ").list();
	}

	public List<Group> findGroupsByName(String name) {
		return sessionFactory.getCurrentSession().createQuery("select o from Group o where o.name = :name").setString("name", name).list();
	}

	public Role findRole(String authority) {
		return (Role) sessionFactory.getCurrentSession().createQuery("select o from Role o.authority = :authority").setString("authority", authority).uniqueResult();
	}

	public List<Role> findRoles() {
		return sessionFactory.getCurrentSession().createQuery("select o from Role o order by o.authority").list();
	}

	public User findUser(Long id) {
		return (User) sessionFactory.getCurrentSession().createQuery("select o from User o where o.id = :id").setLong("id", id).uniqueResult();
	}

	public List<User> findUsers() {
		return sessionFactory.getCurrentSession().createQuery("select o from User o order by o.username").list();
	}

	public User findUsersByUsername(String username) {
		return (User) sessionFactory.getCurrentSession().createQuery("select o from User o where o.username = :username").setString("username", username).uniqueResult();
	}

	public void save(Role role) {
		sessionFactory.getCurrentSession().saveOrUpdate(role);
	}

	public void save(Group group) {
		sessionFactory.getCurrentSession().saveOrUpdate(group);
	}

	public void save(User user) {
		if(passwordEncoder != null){
			user.setPassword(passwordEncoder.encodePassword(user.getPassword(), null));
		}
		sessionFactory.getCurrentSession().save(user);
	}
	
	public void update(User user){
		sessionFactory.getCurrentSession().update(user);
	}

}
