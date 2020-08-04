package com.project.preet.springboot.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.preet.springboot.dao.CompanyRepository;
import com.project.preet.springboot.dto.CompanyDto;
import com.project.preet.springboot.model.Company;

@Service
public class CompanyService {
	
	@Autowired
	CompanyRepository cRepo;
	
	ModelMapper mapper=new ModelMapper();
	
  
	
	public Iterable<CompanyDto> getAll()
	{	  mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	
	java.lang.reflect.Type targetListType = new TypeToken<Iterable<CompanyDto>>() {}.getType();
		  return mapper.map(cRepo.findAll(),targetListType);
		
	}
	
	public Iterable<CompanyDto> getCompanyBycName(String pattern)
	{	  mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	
	java.lang.reflect.Type targetListType = new TypeToken<Iterable<CompanyDto>>() {}.getType();
		  return mapper.map(cRepo.findBycNameContaining(pattern),targetListType);
		
	}
	
	public CompanyDto getCompanyById(int id)
	{
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(cRepo.findById(id).get(),CompanyDto.class);
	}
	
	public CompanyDto getCompanyByStockCode(String stockCode)
	{
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(cRepo.findByStockCode(stockCode).get(),CompanyDto.class);
	}
	
	public Iterable<CompanyDto> getCompanyBySector(String sector)
	{
		java.lang.reflect.Type targetListType = new TypeToken<Iterable<CompanyDto>>() {}.getType();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(cRepo.findBySector(sector),targetListType);
	}
	
	public void insertCompany(CompanyDto companyDto)
	{
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		System.out.println(companyDto);
		cRepo.save(mapper.map(companyDto,Company.class));
	}
	
	public void updateCompany(CompanyDto companyDto,int id)
	{
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		cRepo.save(mapper.map(companyDto,Company.class));
	}
	
	public void deleteCompany(int id)
	{
		cRepo.deleteById(id);
	}
	

}
