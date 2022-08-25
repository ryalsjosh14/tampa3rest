package com.tampa3.boot.controller;


import org.springframework.web.bind.annotation.*;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("/stockRequest/")
@CrossOrigin
public class YahooFinanceController {

    @RequestMapping(method = RequestMethod.GET, value = "/{ticker}")
    public Stock singleStock (@PathVariable("ticker") String ticker)
    {

        //Neeed to input a stock ticker somehow
        Stock stock = null;
        try {
            stock = YahooFinance.get(ticker);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BigDecimal price = stock.getQuote().getPrice();
//        BigDecimal change = stock.getQuote().getChangeInPercent();
//        BigDecimal peg = stock.getStats().getPeg();
//        BigDecimal dividend = stock.getDividend().getAnnualYieldPercent();

        return stock;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public Map<String, Stock> multipleStock (@PathVariable("ticker") String ticker)
    {
        String[] symbols = new String[] {"INTC", "BABA", "TSLA", "AIR.PA", "YHOO"};

        Map<String, Stock> stocks = null; // single request
        try {
            stocks = YahooFinance.get(symbols);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stock intel = stocks.get("INTC");
        Stock airbus = stocks.get("AIR.PA");

        return stocks;
    }


}
