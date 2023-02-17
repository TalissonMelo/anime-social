package com.talissonmelo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AnimeSocialApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimeSocialApplication.class, args);
	}

}
