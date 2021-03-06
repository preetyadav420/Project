package com.project.preet.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class StockMarketIpoDetailApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockMarketIpoDetailApplication.class, args);
	}

}
