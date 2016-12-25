package com.mediAssist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {
	public static void main(String[] args) throws Exception{
		SpringApplication.run(Application.class, args);
		
		/*Set<Scope> list = new TreeSet<Scope>(new ScopeComparator());
		
		for (int i = 0; i < 5; i++) {
			Scope scope = new Scope();
			Double val = (double) i;
			scope.setScopeId(val);
			scope.setScopeName("ABC");
			list.add(scope);
		}
		
		//Test test = new Test();
		//test.setId(1);
		//test.setName("ABC1");
		
		for (Scope scope : list) {
			System.out.println(" >> "+scope.getScopeId()+" >> "+scope.getScopeName());
		}
		*/
		
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder){
		return builder.build();
	}
	
	
}
