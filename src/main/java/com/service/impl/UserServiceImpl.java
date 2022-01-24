package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.User;
import com.repository.UserRepository;
import com.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepo;

	@Override
	public User addUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public String deleteUserById(int userId) {
		userRepo.findById(userId).orElseThrow();
		userRepo.deleteById(userId);
		return "Deleted";
	}

	@Override
	public User updateUserById(User user, int userId) {
		User existingUser = userRepo.findById(userId).orElseThrow();
		
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setUsername(user.getUsername());
		existingUser.setPassword(user.getPassword());
		existingUser.setMobileNumber(user.getMobileNumber());
		existingUser.setEmail(user.getEmail());
		
		userRepo.save(existingUser);
		return existingUser;
	}

	@Override
	public User getUserById(int userId) {
		return userRepo.findById(userId).orElseThrow();
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

}
