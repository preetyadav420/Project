package com.project.preet.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.project.preet.springboot.client.CompanyClient;
import com.project.preet.springboot.dto.CompanyDto;


@RestController
@RequestMapping("/MicroService3")
public class MicroService3Controller {
	
	
	private CompanyClient companyClient;


	public MicroService3Controller(CompanyClient companyClient ) {
		
		this.companyClient = companyClient;

	}
	
	@GetMapping("/Sector/{sector}")
	@HystrixCommand(fallbackMethod= "defaultResponse")
	public ResponseEntity<Iterable<CompanyDto>> getCompanyBySector(@PathVariable String sector) {
		return new ResponseEntity<>(companyClient.getCompanyBySector(sector), HttpStatus.OK);
	}

	public ResponseEntity<Iterable<CompanyDto>> defaultResponse(String sector) {
		System.out.println("You are seeing this fallback response because the underlying microservice is down.");
		String err = "Fallback error as the microservice is down.";
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	

}
