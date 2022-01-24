package com;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entity.Admin;
import com.repository.AdminRepository;
import com.service.AdminService;

@SpringBootTest
class AdminServiceTest {

	@Autowired
	AdminService adminService;
	
	@MockBean
	AdminRepository adminRepo;

	@Test
	void testInsertAdmin() {
		Admin a1 = new Admin();
		a1.setUserId(1);
		a1.setFirstName("admin");
		a1.setLastName("test");
		a1.setUsername("adminUser");
		a1.setPassword("pass");
		a1.setMobileNumber("1234567890");
		a1.setEmail("admin@gmail.com");
		
		Mockito.when(adminRepo.save(a1)).thenReturn(a1);
		
		assertThat(adminService.insertAdmin(a1)).isEqualTo(a1);
	}

	@Test
	void testUpdateAdmin() throws Throwable{
		Admin a1 = new Admin();
		a1.setUserId(1);
		a1.setFirstName("admin");
		a1.setLastName("test");
		a1.setUsername("adminUser");
		a1.setPassword("pass");
		a1.setMobileNumber("1234567890");
		a1.setEmail("admin@gmail.com");
		
		Optional<Admin> a = Optional.of(a1);
		
		Mockito.when(adminRepo.findById(1)).thenReturn(a);
		
		Mockito.when(adminRepo.save(a1)).thenReturn(a1);
		a1.setFirstName("admin");
		a1.setLastName("test");
		
		assertThat(adminService.updateAdminById(a1, 1)).isEqualTo(a1);
	}

	@Test
	void testDeleteAdmin() {
		Admin c1=new Admin();
		c1.setUserId(1);
		c1.setEmail("customer@gmail.com");
		c1.setFirstName("Geetha");
		c1.setLastName("Madhuri");
		c1.setMobileNumber("9988445512");
		c1.setPassword("Geeth@12");
		c1.setUsername("Geetmadhu");
		
		Optional<Admin> c2=Optional.of(c1);

		Mockito.when(adminService.findById(1)).thenReturn(c2);
		Mockito.when(adminService.existsById(c1.getUserId())).thenReturn(false);
		assertFalse(adminService.existsById(c1.getUserId()));
	}

}
