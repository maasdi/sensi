package com.sensi.service;

import java.util.List;

import com.sensi.domain.Group;
import com.sensi.domain.Role;
import com.sensi.domain.User;

public interface SecurityService {
	/** Role */
	public Long countRoles();
	
	public Role findRole(String authority);
	
	public List<Role> findRoles();
	
	public void save(Role role);
	
	public void delete(Role role);
	
	/** Group */
	public Long countGroups();
	
	public Group findGroup(Long id);
	
	public List<Group> findGroups();
	
	public List<Group> findGroupsByName(String name);
	
	public Long countGroupsByName(String name);
	
	public void save(Group group);
	
	public void delete(Group group);
	
	/** User */
	public void save(User user);
	
	public void update(User user);

    public void delete(User user);

    public User findUser(Long id);

    public List<User> findUsers();

    public Long countUsers();

    public User findUsersByUsername(String username);

    public Long countUsersByUsername(String username);

}
