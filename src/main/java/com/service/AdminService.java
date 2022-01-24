package com.service;

import java.util.List;

import com.entity.Admin;
import com.exception.AdminNotFoundException;

public interface AdminService {
	
	public Admin insertAdmin(Admin admin);
	public Admin updateAdminById(Admin admin, int adminId) throws AdminNotFoundException;
	public String deleteAdminById(int adminId) throws AdminNotFoundException;
	public Admin getAdminById(int adminId) throws AdminNotFoundException;
	public List<Admin> getAllAdmins();

}
