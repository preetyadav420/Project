package com.project.preet.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;


/*
 * 
CompanyEntity Class: Below can be fields in Company Entity Class
1.	Company Name
2.	Turnover
3.	CEO
4.	Board of Directors
5.	Listed in Stock Exchanges
6.	Sector
7.	Brief writeup
8.	Company Stock code in each Stock Exchange

 * 
 */

@Entity
@Table( schema = "company")
public class Company {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int Id;
	
	@Column(name="cname")
	String cName;
	
	@Column(name="turnover")
	int turnover;
	
	@Column(name="ceo")
	String ceo;
	
	@Column(name="bod")
	String bod;
	
	@Column(name="listed")
	boolean listed;
	
	@Column(name="sector")
	String sector;
	
	@Column(name="brief")
	String brief;
	
	@Column(name="scode")
	String stockCode;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public int getTurnover() {
		return turnover;
	}

	public void setTurnover(int turnover) {
		this.turnover = turnover;
	}

	public String getCeo() {
		return ceo;
	}

	public void setCeo(String ceo) {
		this.ceo = ceo;
	}

	public String getBod() {
		return bod;
	}

	public void setBod(String bod) {
		this.bod = bod;
	}

	public boolean isListed() {
		return listed;
	}

	public void setListed(boolean listed) {
		this.listed = listed;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
	
	

	
	
	
	
	
	
	

}
