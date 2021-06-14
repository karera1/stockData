package com.yahoofinance.stock.stockData;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan({"com.yahoofinance.stock.stockData.controller"})
public class StockDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockDataApplication.class, args);
	}

}
