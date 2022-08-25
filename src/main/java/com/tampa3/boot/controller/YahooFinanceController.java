package com.tampa3.boot.controller;


import org.springframework.web.bind.annotation.*;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.math.BigDecimal;

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
        BigDecimal change = stock.getQuote().getChangeInPercent();
        BigDecimal peg = stock.getStats().getPeg();
        BigDecimal dividend = stock.getDividend().getAnnualYieldPercent();

        return stock;
    }

}
