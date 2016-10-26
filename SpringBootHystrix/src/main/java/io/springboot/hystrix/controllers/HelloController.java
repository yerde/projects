package io.springboot.hystrix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.springboot.hystrix.services.HelloService;

@RestController
public class HelloController {

	@Autowired
	HelloService helloService;

	@GetMapping("/")
	public String index() {
		return helloService.doHttpCall() + " - " + helloService.doFailHttpCall();
	}
}
