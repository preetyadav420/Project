package com.project.preet.springboot.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*1.	id
2.	Company Name
3.	Stock Exchange
4.	Price per share
5.	Total number of Shares
6.	Open Date Time
7.	Remarks
*/


@Entity
@Data
@Table(schema="ipoDetails")
public class IPODetail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int Id;
	
	@Column(name="cname")
	String cName;
	
	@Column(name="stockexchange")
	String stockExchange;
	
	@Column(name="pricepp")
	String pricePerShare;
	
	@Column(name="total_Shares")
	String totalShares;
	
	@Column(name="open_date_time") 
	Timestamp openDateTime;
	
	@Column(name="remarks")
	String remarks;
	
}
