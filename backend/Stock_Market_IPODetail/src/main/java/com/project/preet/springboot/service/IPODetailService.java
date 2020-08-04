package com.project.preet.springboot.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.preet.springboot.dao.IPODetailRepository;
import com.project.preet.springboot.dto.IPODetailDto;
import com.project.preet.springboot.model.IPODetail;

@Service
public class IPODetailService {

		
		@Autowired
		IPODetailRepository ipoRepo;
		
		ModelMapper mapper=new ModelMapper();
		
	  
		
		public Iterable<IPODetailDto> getAll()
		{	  mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		java.lang.reflect.Type targetListType = new TypeToken<Iterable<IPODetailDto>>() {}.getType();
			  return mapper.map(ipoRepo.findAll(),targetListType);
			
		}
		
		
		public IPODetailDto getIPODetailBycName(String cname)
		{	  mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
			
			  return mapper.map(ipoRepo.findBycName(cname).get(),IPODetailDto.class);
			
		}
		
		public IPODetailDto getIPODetailById(int id)
		{
			mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
			return mapper.map(ipoRepo.findById(id).get(),IPODetailDto.class);
		}
		
		public void insertIPODetail(IPODetailDto ipoDetailDto)
		{
			mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
			ipoRepo.save(mapper.map(ipoDetailDto,IPODetail.class));
		}
		
		public void updateIPODetail(IPODetailDto ipoDetailDto,int id)
		{
			mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
			ipoRepo.save(mapper.map(ipoDetailDto,IPODetail.class));
		}
		
		public void deleteIPODetail(int id)
		{
			ipoRepo.deleteById(id);
		}
		

	}
