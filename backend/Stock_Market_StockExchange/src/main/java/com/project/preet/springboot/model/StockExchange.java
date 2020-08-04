package com.project.preet.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table( schema = "stockexchange")
public class StockExchange {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	@Column(name="stockExchange")
	String stockExchange;
	
	@Column(name="brief")
	String brief;
	
	@Column(name="contactAddress")
	String contactAddress;
	
	@Column(name="remarks")
	String	remarks;

	


}
