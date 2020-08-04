package com.project.preet.springboot.service;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.preet.springboot.dao.StockPriceRepository;
import com.project.preet.springboot.dto.StockPriceDto;
import com.project.preet.springboot.helper.ExcelHelper;
import com.project.preet.springboot.model.StockPrice;

@Service
public class StockPriceService {
	
	@Autowired
	StockPriceRepository spRepo;
	
	ModelMapper mapper=new ModelMapper();
	
  
	
	public Iterable<StockPriceDto> getAll()
	{	  mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	
	java.lang.reflect.Type targetListType = new TypeToken<Iterable<StockPriceDto>>() {}.getType();
		  return mapper.map(spRepo.findAll(),targetListType);
		
	}
	
	public void uploadExcel(MultipartFile file) {
	    try {
	      List<StockPrice> stockPrice = ExcelHelper.excelToTutorials(file.getInputStream());
	      spRepo.saveAll(stockPrice);
	    } catch (Exception e) {
	    	System.out.println("failed in service");
	      throw new RuntimeException("fail to store excel data: " + e.getMessage());
	    }
	  }
	
	public Iterable<StockPriceDto> getByDateRange(String date1,String date2,String cCode)
	{
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		java.lang.reflect.Type targetListType = new TypeToken<Iterable<StockPriceDto>>() {}.getType();
			  return mapper.map(spRepo.findAllByDateLessThanEqualAndDateGreaterThanEqualAndCompanyCode( Date.valueOf(date1),Date.valueOf(date2),cCode),targetListType);
	}
	
	public StockPriceDto getStockPriceById(int id)
	{
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(spRepo.findById(id).get(),StockPriceDto.class);
	}
	
	public Iterable<StockPriceDto> getStockPriceByStockExchange(String stockExchange)
	{
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		java.lang.reflect.Type targetListType = new TypeToken<Iterable<StockPriceDto>>() {}.getType();
		return mapper.map(spRepo.findAllByStockExchange(stockExchange),targetListType);
	}
	
	public void insertStockPrice(StockPriceDto stockPriceDto)
	{
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		spRepo.save(mapper.map(stockPriceDto,StockPrice.class));
	}
	
	public void updateStockPrice(StockPriceDto stockPriceDto,int id)
	{
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		spRepo.save(mapper.map(stockPriceDto,StockPrice.class));
	}
	
	public void deleteStockPrice(int id)
	{
		spRepo.deleteById(id);
	}

}
