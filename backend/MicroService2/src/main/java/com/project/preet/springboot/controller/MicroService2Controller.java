package com.project.preet.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.project.preet.springboot.client.CompanyClient;
import com.project.preet.springboot.client.IPODetailClient;
import com.project.preet.springboot.client.StockPriceClient;
import com.project.preet.springboot.dto.CompanyDto;
import com.project.preet.springboot.dto.IPODetailDto;
import com.project.preet.springboot.dto.StockPriceDto;

@RestController
@RequestMapping("/MicroService2")
public class MicroService2Controller {
	
	
	private CompanyClient companyClient;
	private IPODetailClient ipoClient;
	private StockPriceClient spClient;

	public MicroService2Controller(CompanyClient companyClient, IPODetailClient ipoClient, StockPriceClient spClient ) {
		
		this.companyClient = companyClient;
		this.ipoClient= ipoClient;
		this.spClient= spClient;
	}
	
	@GetMapping("/IPO/{cname}")
	@HystrixCommand(fallbackMethod= "defaultResponseipo")
	public ResponseEntity<IPODetailDto> getIPODetailBycName(@PathVariable String cname) {
		return new ResponseEntity<>(ipoClient.getIPODetailByCompany(cname), HttpStatus.OK);
	}
	
	public ResponseEntity<IPODetailDto> defaultResponseipo(String cname) {
		System.out.println("You are seeing this fallback response because the underlying microservice is down.");
		String err = "Fallback error as the microservice is down.";
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/StockPrice/{date1}/{date2}/{id}")
	@HystrixCommand(fallbackMethod= "defaultResponse")
	public ResponseEntity<Iterable<StockPriceDto>> getStockPriceByDate(@PathVariable String date1,@PathVariable String date2,@PathVariable int id) {
		
		return new ResponseEntity<>(spClient.getStockPriceByDate(date1, date2,companyClient.getCompany(id).getStockCode()), HttpStatus.OK);
	}
	
	public ResponseEntity<Iterable<StockPriceDto>> defaultResponse(String date1,String date2,int id) {
		System.out.println("You are seeing this fallback response because the underlying microservice is down.");
		String err = "Fallback error as the microservice is down.";
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@GetMapping("/pattern/{pattern}")
	@HystrixCommand(fallbackMethod= "defaultResponseDto")
	public ResponseEntity<Iterable<CompanyDto>> getCompanyByPattern(@PathVariable String pattern) {
		return new ResponseEntity<>(companyClient.getCompanyByPattern(pattern), HttpStatus.OK);
	}
	
	
	
	@GetMapping("/{id}")
	@HystrixCommand(fallbackMethod= "defaultResponse")
	public ResponseEntity<CompanyDto> getCompanyDetails(@PathVariable int id) {
		return new ResponseEntity<>(companyClient.getCompany(id), HttpStatus.OK);
	}

	// When we define a fallback-method, the fallback-method must match the same parameters of the method where you define the Hystrix Command using the hystrix-command annotation.
	public ResponseEntity<CompanyDto> defaultResponse(int e) {
		System.out.println("You are seeing this fallback response because the underlying microservice is down.");
		String err = "Fallback error as the microservice is down.";
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	public ResponseEntity<Iterable<CompanyDto>> defaultResponseDto(String s) {
		System.out.println("You are seeing this fallback response because the underlying microservice is down.");
		String err = "Fallback error as the microservice is down.";
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	

}
