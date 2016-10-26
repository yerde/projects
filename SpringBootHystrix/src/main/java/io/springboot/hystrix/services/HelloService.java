package io.springboot.hystrix.services;

import java.net.URI;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloService {

	@HystrixCommand(fallbackMethod = "doOnFallback")
	public String doHttpCall() {
		return "Greetings from Spring Boot!";
	}

	@SuppressWarnings("unused")
	private String doOnFallback() {
		return "hello from fallback";
	}

	@HystrixCommand(fallbackMethod = "doOnFallback")
	public String doFailHttpCall() {
		RestTemplate restTemplate = new RestTemplate();
		URI uri = URI.create("http://localhost:8090/recommended");
		return restTemplate.getForObject(uri, String.class);
	}

}
