package com.project.preet.springboot.dto;

import java.sql.Date;
import java.sql.Time;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockPriceDto {
	
	String companyCode;

	String stockExchange;

	int price;

	Date date;


	Time time;

}
