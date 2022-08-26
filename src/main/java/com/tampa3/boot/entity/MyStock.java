package com.tampa3.boot.entity;

import java.math.BigDecimal;

//@Entity

public class MyStock {

    public String ticker;
    public BigDecimal price;

    public MyStock(){} //Empty cons
    public MyStock(String ticker, BigDecimal price) {
        this.ticker = ticker;
        this.price = price;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
