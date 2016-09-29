package com.mediAssist.repository.impl;

import java.util.List;

import com.mediAssist.model.Category;
import com.mediAssist.model.Region;
import com.mediAssist.model.User;

public interface UserRepository {

	List<User> getAllUsers();

	List<User> getAllUsersWithDetails();

	String saveUsers(List<User> users);

	List<Category> getScopeCat();

	List<Region> getRegions();
	
	

}
