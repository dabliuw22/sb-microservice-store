package com.leysoft.app.client;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("gateway-server")
@RibbonClient("microservice-store")
public interface ClientMicroserviceBook {
	
	@GetMapping(value = "/microservice-book/book")
	public List<Object> all();
	
	@GetMapping(value = "/microservice-book/book/{id}")
	public Object get(@PathVariable("id") Long id);
}