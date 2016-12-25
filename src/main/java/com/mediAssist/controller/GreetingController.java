package com.mediAssist.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.example.ws.model.Greeting;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	/*private static Integer nextId;
	private static Map<Integer, Greeting> greetingMap;
	
	private static Greeting save(Greeting greeting){
		if(greetingMap == null){
			greetingMap = new HashMap<Integer, Greeting>();
			nextId = 1;
		}
		greeting.setId(nextId);
		nextId = nextId + 1;
		greetingMap.put(greeting.getId(), greeting);
		return greeting;
		
	}
	
	static {
		Greeting g1 = new Greeting();
		g1.setText("Hellow");
		save(g1);
		
		
		Greeting g2 = new Greeting();
		g2.setText("Suhas");
		save(g2);
		
	}*/
	
	/*@RequestMapping(value = "/api/getGreetings", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Greeting>> getGreeting() {
		Collection<Greeting> greetings = greetingMap.values();
		return new ResponseEntity<Collection<Greeting>>(greetings, HttpStatus.OK);
	}*/

	/*@RequestMapping(value = "/api/getGreeting", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Greeting> getGreeting() {
		List<Greeting> greetings = (List<Greeting>) greetingMap.values();
		return greetings;
	}*/
	
	/*@RequestMapping(value = "/api/getRestGreeting", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Greeting getGreetin() {
		Greeting g1 = new Greeting();
		g1.setId(1);
		g1.setText("Rest Test");
		return g1;
	}*/
}
