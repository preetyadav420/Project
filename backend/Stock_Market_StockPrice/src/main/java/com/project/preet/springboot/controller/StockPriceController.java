package com.project.preet.springboot.controller;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.preet.springboot.dto.StockPriceDto;
import com.project.preet.springboot.helper.ExcelHelper;
import com.project.preet.springboot.service.StockPriceService;



@RestController
public class StockPriceController {
	
	@Autowired
	StockPriceService spService;
	
	@PostMapping("/StockPrice/upload")
	  public void uploadFile(@RequestParam("file") MultipartFile file) {
	    String message = "";

	    if (ExcelHelper.hasExcelFormat(file)) {
	      try {
	    	  spService.uploadExcel(file);

	        message = "Uploaded the file successfully: " + file.getOriginalFilename();
	        System.out.println(message);
	      } catch (Exception e) {
	        message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	        System.out.println(message);
	        
	      }
	    }

	    message = "Please upload an excel file!";
	    System.out.println(message);
	  }
	
	@RequestMapping(value="/StockPrice")
	Iterable<StockPriceDto> getAll(){
		return spService.getAll();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/StockPrice/{id}")
	StockPriceDto getStockPriceById(@PathVariable int id)
	{
		return spService.getStockPriceById(id);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/StockPrice/StockExchange/{stockExchange}")
	Iterable<StockPriceDto> getStockPriceById(@PathVariable String stockExchange)
	{
		return spService.getStockPriceByStockExchange(stockExchange);
	}
	
	
	@RequestMapping(method=RequestMethod.GET,value="/StockPrice/date/{date1}/{date2}/{cCode}")
	Iterable<StockPriceDto> getByDate(@PathVariable String date1,@PathVariable String date2,@PathVariable String cCode)
	{
		return spService.getByDateRange(date1,date2,cCode);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/StockPrice/{id}")
	void updateStockPrice(@RequestBody StockPriceDto stockPriceDto , @PathVariable int id)
	{
		spService.updateStockPrice(stockPriceDto, id);
	}
	
	@PostMapping(value="/StockPrice")
	void insertStockPrice(@RequestBody StockPriceDto stockPriceDto)
	{
		spService.insertStockPrice(stockPriceDto);
	}
	
	@DeleteMapping(value="/StockPrice/{id}")
	void deleteStockPrice(@PathVariable int id)
	{
		spService.deleteStockPrice(id);
	}
	
}
