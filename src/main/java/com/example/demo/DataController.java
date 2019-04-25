package com.example.demo;

import java.time.LocalTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DataController {

	@GetMapping()
	public String getTime() {
		return "The current time is : " + LocalTime.now().toString();
	}
	
	@GetMapping("{name}")
	public String sayHello(@PathVariable String name) {
		return "Hello " + name;
	}
	
	
}
