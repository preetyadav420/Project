package com.project.preet.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.preet.springboot.dto.StockExchangeDto;
import com.project.preet.springboot.service.StockExchangeService;

@RestController
public class StockExchangeController {
	
	@Autowired
	StockExchangeService sService;
	
	@RequestMapping(value="/StockExchange")
	Iterable<StockExchangeDto> getAll(){
		return sService.getAll();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/StockExchange/{id}")
	StockExchangeDto getStockExchangeById(@PathVariable int id)
	{
		return sService.getStockExchangeById(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/StockExchange/{id}")
	void updateStockExchange(@RequestBody StockExchangeDto stockExchangeDto , @PathVariable int id)
	{
		sService.updateStockExchange(stockExchangeDto, id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/StockExchange")
	void insertStockExchange(@RequestBody StockExchangeDto stockExchangeDto)
	{
		sService.insertStockExchange(stockExchangeDto);
	}
	
	@DeleteMapping(value="/StockExchange/{id}")
	void deleteStockExchange(@PathVariable int id)
	{
		sService.deleteStockExchange(id);
	}

}
