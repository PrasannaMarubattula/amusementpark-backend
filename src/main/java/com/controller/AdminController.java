package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Admin;
import com.exception.AdminNotFoundException;
import com.service.AdminService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@PostMapping("/insertAdmin")
	public ResponseEntity<Admin> insertAdmin(@RequestBody Admin admin){
		return new ResponseEntity<Admin>(adminService.insertAdmin(admin), HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllAdmins")
	public List<Admin> getAllAdmins(){
		return adminService.getAllAdmins();
	}
	
	@GetMapping("/getAdminById/{adminId}")
	public ResponseEntity<Admin> getAdminById(@PathVariable int adminId) throws AdminNotFoundException{
		return new ResponseEntity<Admin>(adminService.getAdminById(adminId), HttpStatus.OK);
	}
	
	@PutMapping("/updateAdminById/{adminId}")
	public ResponseEntity<Admin> updateAdminById(@PathVariable int adminId, @RequestBody Admin admin) throws AdminNotFoundException{
		return new ResponseEntity<Admin>(adminService.updateAdminById(admin, adminId), HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteAdminById/{adminId}")
	public ResponseEntity<String> deleteAdminById(@PathVariable int adminId) throws AdminNotFoundException{
		adminService.deleteAdminById(adminId);
		return new ResponseEntity<String>("Deleted", HttpStatus.OK);
	}

}
