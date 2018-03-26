package com.leysoft.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leysoft.app.client.ClientMicroserviceBook;

@RefreshScope
@RequestMapping(value = "/store")
@RestController
public class ApiStoreController {
	
	@Value("${message}")
	private String message;
	
	@Autowired
	private ClientMicroserviceBook client;
	
	@GetMapping(value = {""})
	public List<Object> all() {
		return client.all();
	}
	
	@GetMapping(value = {"/{id}"})
	public Object get(@PathVariable("id") Long id) {
		return client.get(id);
	}
	
	@GetMapping(value = {"/message"})
	public String getMessage() {
		return message;
	}
}