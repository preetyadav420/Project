package com.project.preet.springboot.helper;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.project.preet.springboot.model.StockPrice;

public class ExcelHelper {

	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	  static String[] HEADERs = { "id", "companyCode", "stockExchange", "price" ,"date","time"};
	  static String SHEET = "StockPrices";

	  public static boolean hasExcelFormat(MultipartFile file) {

	    if (!TYPE.equals(file.getContentType())) {
	      return false;
	    }

	    return true;
	  }

	  public static List<StockPrice> excelToTutorials(InputStream is) {
	    try {
	      Workbook workbook = new XSSFWorkbook(is);
	      
	      Sheet sheet = workbook.getSheet(SHEET);
	      
	      Iterator<Row> rows = sheet.iterator();
	      System.out.println( "There");
	      
	      List<StockPrice> stockPrices = new ArrayList<StockPrice>();

	      int rowNumber = 0;
	      while (rows.hasNext()) {
	        Row currentRow = rows.next();

	        // skip header
	        if (rowNumber == 0) {
	          rowNumber++;
	          continue;
	        }

	        Iterator<Cell> cellsInRow = currentRow.iterator();

	        StockPrice stockPrice = new StockPrice();

	        int cellIdx = 0;
	        while (cellsInRow.hasNext()) {
	          Cell currentCell = cellsInRow.next();
	          
	          switch (cellIdx) {
	          case 0:
	        	  {stockPrice.setId((int)currentCell.getNumericCellValue());
	            break;}

	          case 1:
	          { stockPrice.setCompanyCode(currentCell.getStringCellValue());
	            break;}

	          case 2:
	          { stockPrice.setStockExchange(currentCell.getStringCellValue());
	            break;}

	          case 3:
	        	  {stockPrice.setPrice((int)currentCell.getNumericCellValue());
	            break;}
	            
			  case 4: 
			  { stockPrice.setDate(Date.valueOf(currentCell.getStringCellValue()));
			 break; }
			 
			  case 5:
			 { stockPrice.setTime(Time.valueOf(currentCell.getStringCellValue()));
			 break;}

	          default:
	            break;
	          }

	          cellIdx++;
	        }

	        stockPrices.add(stockPrice);
	      }

	      workbook.close();

	      return stockPrices;
	    } catch (Exception e) {
	    	System.out.println( e.getMessage());
	      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
	    }
	  }
	}
