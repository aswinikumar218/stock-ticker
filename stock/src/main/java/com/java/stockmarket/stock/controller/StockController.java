package com.java.stockmarket.stock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.java.stockmarket.stock.model.Stock;
import com.java.stockmarket.stock.service.StockService;
import static com.google.common.base.Preconditions.checkNotNull;

@RestController
@RequestMapping("/api")
public class StockController {

	@Autowired
	StockService stockService;
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public ResponseEntity<String> uploadStockFile(@RequestParam("file") MultipartFile file) {
	    if(stockService.uploadStockFile(file)) {
	    	return ResponseEntity.ok("Stock dataset has been uploaded to the portforlio");
	    }
	    return ResponseEntity.badRequest().body("Failed to upload stock dataset to the portfolio");
	}
	
	@RequestMapping(value="/stocks", method=RequestMethod.POST)
	public ResponseEntity<String> addStock(@RequestBody Stock stock) {
		
		try {
	        validateStock(stock);
	    } catch (Exception e) {
	        return ResponseEntity.badRequest().body("Mandatory field stock symbol not present");
	    }

	    if(stockService.addStock(stock)) {
	    	return ResponseEntity.ok("Stock has been added to the portforlio");
	    }
	    return ResponseEntity.badRequest().body("Failed to add stock to the portfolio");
	}

	@RequestMapping(value="/stocks", method=RequestMethod.GET)
	public List<Stock> getStocks(@RequestParam(name="symbol") String symbol) {
	    return stockService.getStocks(symbol);
	}
	
	private void validateStock(Stock stock) {
	    checkNotNull(stock.getStock());
	    checkNotNull(stock.getQuarter());
	}
}
