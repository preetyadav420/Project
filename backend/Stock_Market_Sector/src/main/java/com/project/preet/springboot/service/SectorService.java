package com.project.preet.springboot.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.preet.springboot.dao.SectorRepository;
import com.project.preet.springboot.dto.SectorDto;
import com.project.preet.springboot.model.Sector;

@Service
public class SectorService {
	
	
	@Autowired
	SectorRepository sRepo;
	
	ModelMapper mapper=new ModelMapper();
	
  
	
	public Iterable<SectorDto> getAll()
	{	  mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	
	java.lang.reflect.Type targetListType = new TypeToken<Iterable<SectorDto>>() {}.getType();
		  return mapper.map(sRepo.findAll(),targetListType);
		
	}
	
	
	public  SectorDto getSectorById(int id)
	{
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(sRepo.findById(id).get(),SectorDto.class);
	}
	
	public void insertSector(SectorDto sectorDto)
	{
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		System.out.println(sectorDto);
		sRepo.save(mapper.map(sectorDto,Sector.class));
	}
	
	public void updateSector(SectorDto sectorDto,int id)
	{
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		sRepo.save(mapper.map(sectorDto,Sector.class));
	}
	
	public void deleteSector(int id)
	{
		sRepo.deleteById(id);
	}
	
	
	

}
