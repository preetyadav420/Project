package com.project.preet.springboot.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.project.preet.springboot.client.CompanyClient;
import com.project.preet.springboot.client.StockExchangeClient;
import com.project.preet.springboot.client.StockPriceClient;
import com.project.preet.springboot.dto.CompanyDto;
import com.project.preet.springboot.dto.StockExchangeDto;
import com.project.preet.springboot.dto.StockPriceDto;

@RestController
@RequestMapping("/MicroService5")
public class MicroService5Controller {
	
	private StockExchangeClient seClient;
	private StockPriceClient spClient;
	private CompanyClient cClient;


	public MicroService5Controller(StockExchangeClient seClient, StockPriceClient spClient,CompanyClient cClient ) {
		
		this.seClient = seClient;
		this.spClient = spClient;
		this.cClient=cClient;

	}
	
	
	@GetMapping("/StockExchange")
	@HystrixCommand(fallbackMethod= "defaultResponse")
	public ResponseEntity<Iterable<StockExchangeDto>> getStockExchangeList() {
		return new ResponseEntity<>(seClient.getList(), HttpStatus.OK);
	}
	
	
	public ResponseEntity<Iterable<StockExchangeDto>> defaultResponse() {
		System.out.println("You are seeing this fallback response because the underlying microservice is down.");
		String err = "Fallback error as the microservice is down.";
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@GetMapping("/StockExchange/Company/{stockExchange}")
	@HystrixCommand(fallbackMethod= "defaultResponse")
	public ResponseEntity<Iterable<CompanyDto>> getStockExchangeCompanyList(@PathVariable String stockExchange) {
		List<CompanyDto> s=new LinkedList<CompanyDto>();  
		Iterable<StockPriceDto> spDto = spClient.getListByStockExchange(stockExchange);
		for(StockPriceDto spdto:spDto)
		{
			
			s.add(cClient.getCompanyByStockCode(spdto.getCompanyCode()));
		}
		
		return new ResponseEntity<>(s, HttpStatus.OK);
	}
	
	public ResponseEntity<Iterable<CompanyDto>> defaultResponse(String stockExchange) {
		System.out.println("You are seeing this fallback response because the underlying microservice is down.");
		String err = "Fallback error as the microservice is down.";
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping("/StockExchange")
	@HystrixCommand(fallbackMethod= "defaultResponsestock")
	public ResponseEntity<Void> addStockExchange(@RequestBody StockExchangeDto stockExchangeDto) {
		
		seClient.addStockExchange(stockExchangeDto);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	public ResponseEntity<Void> defaultResponsestock(StockExchangeDto stockExchangeDto) {
		System.out.println("You are seeing this fallback response because the underlying microservice is down.");
		String err = "Fallback error as the microservice is down.";
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
