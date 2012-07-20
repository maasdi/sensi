package com.sensi.service;

import java.util.List;

import com.sensi.domain.User;

public interface UserService {
	
	/** User */
	public void save(User user);
	
	public void update(User user);

    public void delete(User user);

    public User findUser(Long id);

    public List<User> findUsers();

    public Long countUsers();

    public User findUsersByUsername(String username);
    
    public User findUserByEmail(String email);

    public Long countUsersByUsername(String username);
    
    public void createAccount(User user);

}
