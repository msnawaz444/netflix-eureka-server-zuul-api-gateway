package com.ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.EurekaClient;

@RequestMapping("/client2")
@RestController
public class Client2Controller {

	@Value("${spring.application.name}")
	private String appName;

	@Autowired
	private EurekaClient eurekaClient;

	@GetMapping("/name2")
	public String client1() {
		return String.format("Hello from '%s'!", eurekaClient.getApplication(appName).getName());
	}

}
