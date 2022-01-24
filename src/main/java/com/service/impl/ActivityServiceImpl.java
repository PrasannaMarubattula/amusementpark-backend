package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Activity;
import com.exception.ActivityNotFoundException;
import com.repository.ActivityRepository;
import com.service.ActivityService;

@Service
public class ActivityServiceImpl implements ActivityService{
	
	@Autowired
	ActivityRepository activityRepo;

	@Override
	public Activity insertActivity(Activity activity) {
		return activityRepo.save(activity);
	}

	@Override
	public Activity updateActivityById(Activity activity, int activityId) throws ActivityNotFoundException {
		Activity existingActivity = activityRepo.findById(activityId).orElseThrow(() -> new ActivityNotFoundException("Activity not found!"));
		
		existingActivity.setCharges(activity.getCharges());
		existingActivity.setDescription(activity.getDescription());
		existingActivity.setActivityName(activity.getActivityName());
		
		activityRepo.save(existingActivity);
		return existingActivity;
	}

	@Override
	public String deleteActivityById(int activityId) throws ActivityNotFoundException {
		activityRepo.findById(activityId).orElseThrow(() -> new ActivityNotFoundException("Activity not found!"));
		activityRepo.deleteById(activityId);
		
		return "Deleted";
	}

	@Override
	public List<Activity> getAllActivities() {
		return activityRepo.findAll();
	}

	@Override
	public Activity getActivityById(int activityId) throws ActivityNotFoundException {
		return activityRepo.findById(activityId).orElseThrow(() -> new ActivityNotFoundException("Activity not found!"));
	}

	@Override
	public List<Activity> viewActivitiesOfCharges(float charges) {
		List<Activity> activityList = activityRepo.viewActivitiesOfCharges(charges);
		return activityList;
	}

	@Override
	public int countActivitiesOfCharges(float charges) {
		List<Activity> activityList = activityRepo.viewActivitiesOfCharges(charges);
		int count = activityList.size();
		return count;
	}

}
