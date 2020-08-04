package com.project.preet.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockExchangeDto {
	
	int id;

	String stockExchange;
	
	String brief;
	
	String contactAddress;
	
	String	remarks;

}
