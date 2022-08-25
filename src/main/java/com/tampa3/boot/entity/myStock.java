package com.tampa3.boot.entity;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity

public class myStock {

    public String ticker;
    public BigDecimal price;

    public myStock(){} //Empty cons
    public myStock(String ticker, BigDecimal price) {
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
