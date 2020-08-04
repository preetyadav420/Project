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
@Table( schema = "sector")
public class Sector {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	@Column(name="sectorname")
	String sectorname;
	
	@Column(name="brief")
	String brief;


}
