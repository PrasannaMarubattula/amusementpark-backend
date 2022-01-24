package com.service;

import java.util.List;

import com.entity.Activity;
import com.exception.ActivityNotFoundException;

public interface ActivityService {
	
	public Activity insertActivity(Activity activity);
	public Activity updateActivityById(Activity activity, int activityId) throws ActivityNotFoundException;
	public String deleteActivityById(int activityId) throws ActivityNotFoundException;
	public List<Activity> getAllActivities();
	public Activity getActivityById(int activityId) throws ActivityNotFoundException;
	
	//Custom
	public List<Activity> viewActivitiesOfCharges(float charges);
	public int countActivitiesOfCharges(float charges);

}
