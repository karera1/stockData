package com.yahoofinance.stock.stockData.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import yahoofinance.YahooFinance;

@Controller
public class stockController {

	private Map<String, String> stocks = new HashMap<String, String>();

	@Autowired
	SimpMessagingTemplate template;

	@MessageMapping("/stock.addStock")
	@SendTo("/topic/public")
	public void addStock(@Payload Map<String, String> stockobj) throws Exception {
		
		String stockName = stockobj.get("key");
		try {
		String str = YahooFinance.get(stockobj.get("key")).toString();
		if(null!=str) {
		
		stocks.put(stockName, str);
		template.convertAndSend("/topic/public", stocks);
		}
		System.out.println("Sent" + stocks);}
		catch(Exception e) {
			System.out.println("stockid :"+stockobj.get("key")+"is not a valid entry");
			String str="Exception";
			stocks.put(stockName, str);
			template.convertAndSend("/topic/public", stocks);
		}
	}
	
	@MessageMapping("/stock.removeStock")
	@SendTo("/topic/public")
	public void removeStock(@Payload Map<String, String> stockobj) throws IOException {

		String stockName = stockobj.get("key");
		stocks.remove(stockName);
		template.convertAndSend("/topic/public", stocks);
		System.out.println("Deleted");

	}

}
