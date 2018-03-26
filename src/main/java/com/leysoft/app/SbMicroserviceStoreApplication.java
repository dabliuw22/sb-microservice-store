package com.leysoft.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;

@EnableFeignClients("com.leysoft.app")
@EnableDiscoveryClient
@SpringBootApplication
public class SbMicroserviceStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbMicroserviceStoreApplication.class, args);
	}
	
	@Bean
	public AlwaysSampler defaultSampler() {
		return new AlwaysSampler();
	}
}