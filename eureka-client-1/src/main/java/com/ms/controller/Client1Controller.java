package com.ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.EurekaClient;

@RequestMapping("/client1")
@RestController
public class Client1Controller {

	@Value("${spring.application.name}")
	private String appName;

	@Autowired
	private EurekaClient eurekaClient;

	@GetMapping("/name1")
	public String client1() {
		return String.format("Hello from '%s'!", eurekaClient.getApplication(appName).getName());
	}

}
