package com.mediAssist.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mediAssist.service.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	ProjectService projectService;
	
	@RequestMapping(value="/home")
	@ResponseBody
	public Map<String, String> home(){
		System.out.println("in controler");
		return projectService.home();
	}
	
}
