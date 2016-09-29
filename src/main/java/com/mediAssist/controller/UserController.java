package com.mediAssist.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mediAssist.model.Category;
import com.mediAssist.model.Region;
import com.mediAssist.model.User;
import com.mediAssist.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value="/get")
	@ResponseBody
	public Map<String, List<User>> home(){
		return userService.getAllUsers();
	}
	
	@RequestMapping(value="/save")
	@ResponseBody
	public Map<String, String> save(@RequestBody List<User> users){
		return userService.saveUsers(users);
	}
	
	@RequestMapping(value="/getCatScope")
	@ResponseBody
	public List<Category> getCatScope(){
		return userService.getCatScope();
	}
	
	@RequestMapping(value="/getRegion")
	@ResponseBody
	public List<Region> getRegion(){
		return userService.getRegion();
	}
	
	
}
