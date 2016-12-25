package com.mediAssist.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.example.ws.model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mediAssist.model.Category;
import com.mediAssist.model.Region;
import com.mediAssist.model.User;
import com.mediAssist.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	RestTemplate restTemplate;

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
		Greeting greeting = restTemplate.getForObject("http://localhost:8080/MediAssist/api/getGreeting", Greeting.class);
		System.out.println(">> "+greeting.getText());
		return userService.getRegion();
	}
	
	@RequestMapping(value="/getRest", method = RequestMethod.GET)
	@ResponseBody
	public Greeting getRest(){
		final String uri = "http://localhost:8080/MediAssist/api/getRestGreeting";
	    Greeting greeting = restTemplate.getForObject(uri, Greeting.class);
		return greeting;
	}
	
	@RequestMapping(value="/getRestList", method = RequestMethod.GET)
	@ResponseBody
	public List<Greeting> getRestList(){
		final String uri = "http://localhost:8080/MediAssist/api/getGreetings";
		List<Greeting> greetings = restTemplate.getForObject(uri, List.class);
		return greetings;
	}
	
}
