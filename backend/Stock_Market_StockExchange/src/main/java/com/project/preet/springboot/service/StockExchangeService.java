package com.project.preet.springboot.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.preet.springboot.dao.StockExchangeRepository;
import com.project.preet.springboot.dto.StockExchangeDto;
import com.project.preet.springboot.model.StockExchange;


@Service
public class StockExchangeService {
	
	@Autowired
	StockExchangeRepository sRepo;
	
	ModelMapper mapper=new ModelMapper();
	
  
	
	public Iterable<StockExchangeDto> getAll()
	{	  mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	
	java.lang.reflect.Type targetListType = new TypeToken<Iterable<StockExchangeDto>>() {}.getType();
		  return mapper.map(sRepo.findAll(),targetListType);
		
	}
	
	
	public  StockExchangeDto getStockExchangeById(int id)
	{
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(sRepo.findById(id).get(),StockExchangeDto.class);
	}
	
	public void insertStockExchange(StockExchangeDto stockExchangeDto)
	{
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		System.out.println(stockExchangeDto);
		sRepo.save(mapper.map(stockExchangeDto,StockExchange.class));
	}
	
	public void updateStockExchange(StockExchangeDto stockExchangeDto,int id)
	{
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		sRepo.save(mapper.map(stockExchangeDto,StockExchange.class));
	}
	
	public void deleteStockExchange(int id)
	{
		sRepo.deleteById(id);
	}

}
