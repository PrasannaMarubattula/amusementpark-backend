package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Admin;
import com.exception.AdminNotFoundException;
import com.repository.AdminRepository;
import com.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	AdminRepository adminRepo;

	@Override
	public Admin insertAdmin(Admin admin) {
		return adminRepo.save(admin);
	}

	@Override
	public Admin updateAdminById(Admin admin, int adminId) throws AdminNotFoundException {
		Admin existingAdmin = adminRepo.findById(adminId).orElseThrow(() -> new AdminNotFoundException("Admin not found!"));
		
		existingAdmin.setFirstName(admin.getFirstName());
		existingAdmin.setLastName(admin.getLastName());
		existingAdmin.setUsername(admin.getUsername());
		existingAdmin.setPassword(admin.getPassword());
		existingAdmin.setMobileNumber(admin.getMobileNumber());
		existingAdmin.setEmail(admin.getEmail());
		
		adminRepo.save(existingAdmin);
		return existingAdmin;
	}

	@Override
	public String deleteAdminById(int adminId) throws AdminNotFoundException {
		adminRepo.findById(adminId).orElseThrow(() -> new AdminNotFoundException("Admin not found!"));
		adminRepo.deleteById(adminId);
		return "Deleted";
	}

	@Override
	public Admin getAdminById(int adminId) throws AdminNotFoundException {
		return adminRepo.findById(adminId).orElseThrow(() -> new AdminNotFoundException("Admin not found!"));
	}

	@Override
	public List<Admin> getAllAdmins() {
		return adminRepo.findAll();
	}

}
