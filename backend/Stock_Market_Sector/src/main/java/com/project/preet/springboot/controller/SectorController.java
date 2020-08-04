package com.project.preet.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.preet.springboot.dto.SectorDto;
import com.project.preet.springboot.service.SectorService;

@RestController
public class SectorController {
	
	@Autowired
	SectorService sService;
	
	@RequestMapping(value="/Sector")
	Iterable<SectorDto> getAll(){
		return sService.getAll();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/Sector/{id}")
	SectorDto getSectorById(@PathVariable int id)
	{
		return sService.getSectorById(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/Sector/{id}")
	void updateSector(@RequestBody SectorDto sectorDto , @PathVariable int id)
	{
		sService.updateSector(sectorDto, id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/Sector")
	void insertSector(@RequestBody SectorDto sectorDto)
	{
		sService.insertSector(sectorDto);
	}
	
	@DeleteMapping(value="/Sector/{id}")
	void deleteSector(@PathVariable int id)
	{
		sService.deleteSector(id);
	}
	
	

}
