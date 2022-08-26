package com.tampa3.boot.entity;

import java.math.BigDecimal;

//@Entity

public class MyStock {

    public String ticker;
    public BigDecimal price;

    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyStock(){} //Empty cons
    public MyStock(String ticker, BigDecimal price, String name) {
        this.ticker = ticker;
        this.price = price;
        this.name = name;
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
