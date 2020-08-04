package com.project.preet.springboot.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.preet.springboot.dto.CompanyDto;
import com.project.preet.springboot.dto.StockExchangeDto;
import com.project.preet.springboot.dto.StockPriceDto;


@FeignClient("company")
public interface CompanyClient {
	
	@GetMapping(value= "/Company/StockCode/{stockCode}")
	public CompanyDto getCompanyByStockCode(@PathVariable String stockCode);
	
	

}
