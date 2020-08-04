package com.project.preet.springboot.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.preet.springboot.model.StockExchange;

@Repository
public interface StockExchangeRepository extends CrudRepository<StockExchange,Integer>{
	
	

}
