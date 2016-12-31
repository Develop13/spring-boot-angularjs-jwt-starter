package com.bk.starter.service;

import java.util.List;

import com.bk.starter.domain.User;

public interface UserService {
	
	public User create(User user);
	
	public List<User> userList();

	public User findByUserName(String username);

	public boolean login(String email, String password);

}
