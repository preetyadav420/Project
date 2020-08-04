package com.project.preet.springboot.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*1.	Company Code
2.	Stock Exchange
3.	Current Price
4.	Date
5.	Time
*/


@Entity
@Table( schema = "stock_price")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockPrice {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	@Column(name="company_code")
	String companyCode;
	
	@Column(name="stockexchange")
	String stockExchange;
	
	@Column(name="price")
	int price;
	
	@Column(name="date")
	Date date;
	
	@Column(name="time")
	Time time;
	

}
