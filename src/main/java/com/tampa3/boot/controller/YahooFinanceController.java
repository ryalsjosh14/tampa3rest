package com.tampa3.boot.controller;


import com.tampa3.boot.entity.myStock;
import org.springframework.web.bind.annotation.*;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/stockRequest/")
@CrossOrigin
public class YahooFinanceController {

    @RequestMapping(method = RequestMethod.GET, value = "/{ticker}")
    public myStock singleStock (@PathVariable("ticker") String ticker)
    {

        //Neeed to input a stock ticker somehow
        Stock stock = null;
        try {
            stock = YahooFinance.get(ticker);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        myStock singleStock = new myStock();
        BigDecimal price = stock.getQuote().getPrice();
        singleStock.setPrice(price);
        singleStock.setTicker(ticker);
//        BigDecimal change = stock.getQuote().getChangeInPercent();
//        BigDecimal peg = stock.getStats().getPeg();
//        BigDecimal dividend = stock.getDividend().getAnnualYieldPercent();

        return singleStock;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all/all")
    public List<myStock> multipleStock (@PathVariable("ticker") String ticker)
    {
        String[] symbols = new String[] {"INTC", "BABA", "TSLA", "AIR.PA", "YHOO"};

        Map<String, Stock> stocks = null; // single request
        try {
            stocks = YahooFinance.get(symbols);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<myStock> stonks = new ArrayList<>();

        myStock x;
        for (String s: symbols){
            x = new myStock();
            x.setTicker(s);
            try {
                x.setPrice(YahooFinance.get(s).getQuote().getPrice());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stonks.add(x);
        }

        return stonks;
    }


}
