package com.service;

import java.util.List;

import com.entity.User;

public interface UserService {
	
//	public User validateUser(String username, String password) throws Exception;
	public User addUser(User user);
	public String deleteUserById(int userId);
	public User updateUserById(User user, int userId);
	public User getUserById(int userId);
	public List<User> getAllUsers();

}
