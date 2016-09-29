package com.mediAssist.service;

import java.util.List;
import java.util.Map;

import com.mediAssist.model.Category;
import com.mediAssist.model.Region;
import com.mediAssist.model.User;

public interface UserService {

	Map<String, List<User>> getAllUsers();

	Map<String, String> saveUsers(List<User> users);

	List<Category> getCatScope();

	List<Region> getRegion();

}
