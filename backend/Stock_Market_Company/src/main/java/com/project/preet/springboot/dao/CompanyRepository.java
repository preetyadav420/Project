package com.project.preet.springboot.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.preet.springboot.model.Company;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Integer> {
	
	public Iterable<Company> findBycNameContaining(String pattern);
	public Iterable<Company> findBySector(String sector);
	public Optional<Company> findByStockCode(String stockCode);
	
	
	

}
