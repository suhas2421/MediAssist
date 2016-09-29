package com.mediAssist.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediAssist.repository.ProjectRepository;
import com.mediAssist.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	ProjectRepository projectRepository;
	
	@Override
	public Map<String, String> home() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("Response", "Success");
		map.put("Exception", "No");
		map.put("Result", "ID="+"123");
		return map;
	}

}
