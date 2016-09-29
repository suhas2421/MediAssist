package com.mediAssist.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mediAssist.repository.ProjectRepository;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository{

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	StringBuffer query;
	
	
}
