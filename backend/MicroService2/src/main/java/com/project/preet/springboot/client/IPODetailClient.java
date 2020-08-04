package com.project.preet.springboot.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.preet.springboot.dto.IPODetailDto;

@FeignClient("ipodetails")
public interface IPODetailClient {
	
	@GetMapping(value= "/IPODetail/name/{cname}")
	public IPODetailDto getIPODetailByCompany(@PathVariable String cname);

}
