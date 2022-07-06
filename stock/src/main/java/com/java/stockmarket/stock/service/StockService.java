package com.java.stockmarket.stock.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.java.stockmarket.stock.model.CsvHelper;
import com.java.stockmarket.stock.model.Stock;

@Service
public class StockService {

	List<Stock> stocks = new ArrayList<>();
	
	public List<Stock> getStocks(String symbol) {
		return stocks.stream().filter(k -> k.getStock().equals(symbol)).collect(Collectors.toList());
	}

	public boolean addStock(Stock stock) {
		return stocks.add(stock);
	}

	public boolean uploadStockFile(MultipartFile file) {
		try {
		    List<Stock> stockList = CsvHelper.csvToStocks(file.getInputStream());
		    return stocks.addAll(stockList);
		} catch (IOException e) {
		    throw new RuntimeException("fail to store csv data: " + e.getMessage());
		}
	}

}
