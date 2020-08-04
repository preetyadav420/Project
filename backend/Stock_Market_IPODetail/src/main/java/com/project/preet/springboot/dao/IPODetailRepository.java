package com.project.preet.springboot.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.preet.springboot.model.IPODetail;

@Repository
public interface IPODetailRepository extends CrudRepository<IPODetail,Integer>{
	
	public Optional<IPODetail> findBycName(String cname);

}
