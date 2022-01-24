package com;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entity.Activity;
import com.repository.ActivityRepository;
import com.service.ActivityService;

@SpringBootTest
class ActivityServiceTest {

	@Autowired
	ActivityService activityservice;
	
	@MockBean
	ActivityRepository repo;

	@Test
	void testGetAllActivities() 
	{
		Activity a1 = new Activity();
		a1.setActivityId(1);
		a1.setActivityName("Gaint Wheel");
		a1.setCharges(150);
		a1.setDescription("Land game");
		
		Activity a2 = new Activity();
		a2.setActivityId(2);
		a2.setActivityName("Wave pool");
		a2.setCharges(150);
		a2.setDescription("Water game");
		
		List<Activity> activityList = new ArrayList<>();
		activityList.add(a1);
		activityList.add(a2);
		
		Mockito.when(repo.findAll()).thenReturn(activityList);
		assertThat(activityservice.getAllActivities()).isEqualTo(activityList);
		}
	

	@Test
	void testInsertActivity() {
		Activity a1 = new Activity();
		a1.setActivityId(1);
		a1.setActivityName("Gaint Wheel");
		a1.setCharges(150);
		a1.setDescription("Land game");
		
		Mockito.when(repo.save(a1)).thenReturn(a1);
		assertThat(activityservice.insertActivity(a1)).isEqualTo(a1);
	}

	@Test
	void testUpdateActivity() throws Throwable {
		Activity a1 = new Activity();
		a1.setActivityId(1);
		a1.setActivityName("Gaint Wheel");
		a1.setCharges(150);
		a1.setDescription("Land game");
		
		Optional<Activity> a2 = Optional.of(a1);
		Mockito.when(repo.findById(1)).thenReturn(a2);
		
		Mockito.when(repo.save(a1)).thenReturn(a1);
		a1.setActivityName("Wave pool");
		a1.setCharges(180);
		a1.setDescription("Water game");
		
		assertThat(activityservice.updateActivityById(a1, 1)).isEqualTo(a1);
	}

	@Test
	void testDeleteActivityById() {
		Activity a1 = new Activity();
		a1.setActivityId(1);
		a1.setActivityName("Gaint Wheel");
		a1.setCharges(150);
		a1.setDescription("Land game");
		
		Optional<Activity> a2 = Optional.of(a1);
		
		Mockito.when(repo.findById(1)).thenReturn(a2);
		Mockito.when(repo.existsById(a1.getActivityId())).thenReturn(false);
		assertFalse(repo.existsById(a1.getActivityId()));
	}


}
