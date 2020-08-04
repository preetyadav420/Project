package com.project.preet.springboot.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.preet.springboot.dto.CompanyDto;

@FeignClient("company")
public interface CompanyClient {
	
	@GetMapping(value= "/Company/sector/{sector}")
	public Iterable<CompanyDto> getCompanyBySector(@PathVariable String sector);
	

}
