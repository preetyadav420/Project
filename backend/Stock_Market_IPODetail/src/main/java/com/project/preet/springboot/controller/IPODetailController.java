package com.project.preet.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.preet.springboot.dto.IPODetailDto;
import com.project.preet.springboot.service.IPODetailService;


@RestController
public class IPODetailController {
	
	@Autowired
	IPODetailService ipoService;
	
	@RequestMapping(value="/IPODetail")
	Iterable<IPODetailDto> getAll(){
		return ipoService.getAll();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/IPODetail/{id}")
	IPODetailDto getIPODetailById(@PathVariable int id)
	{
		return ipoService.getIPODetailById(id);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/IPODetail/name/{cname}")
	IPODetailDto getIPODetailBycName(@PathVariable String cname)
	{
		return ipoService.getIPODetailBycName(cname);
	}
	
	
	@RequestMapping(method=RequestMethod.PUT,value="/IPODetail/{id}")
	void updateIPODetail(@RequestBody IPODetailDto ipoDetailDto , @PathVariable int id)
	{
		ipoService.updateIPODetail(ipoDetailDto,id);
	}
	
	@PostMapping(value="/IPODetail")
	void insertIPODetail(@RequestBody IPODetailDto ipoDetailDto)
	{
		ipoService.insertIPODetail(ipoDetailDto);
	}
	
	@DeleteMapping(value="/IPODetail/{id}")
	void deleteIPODetail(@PathVariable int id)
	{
		ipoService.deleteIPODetail(id);
	}
	

}
