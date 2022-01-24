package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entity.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer>{
	
	@Query("Select a from Activity a where a.charges=:charges")
	List<Activity> viewActivitiesOfCharges(float charges);

}
