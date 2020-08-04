package com.project.preet.springboot.dao;

import java.sql.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.preet.springboot.model.StockPrice;

@Repository
public interface StockPriceRepository extends CrudRepository<StockPrice,Integer>{
	
	
	Iterable<StockPrice> findAllByDateLessThanEqualAndDateGreaterThanEqualAndCompanyCode(Date sd,Date ed,String cCode);
	Iterable<StockPrice> findAllByStockExchange(String stockExchange);

}
