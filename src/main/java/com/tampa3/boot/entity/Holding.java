package com.tampa3.boot.entity;

import javax.persistence.*;

@Entity
@Table(name="current_holdings")
public class Holding {

    @Id
    @Column(name="ticker") private String ticker;

    @Column(name="shares") private String numShares;
    @Column(name="average_price") private Double averagePrice;
    @Column(name="last_purchase_date") private String lastPurchaseDate;


    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getNumShares() {
        return numShares;
    }

    public void setNumShares(String numShares) {
        this.numShares = numShares;
    }

    public Double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(Double averagePrice) {
        this.averagePrice = averagePrice;
    }

    public String getLastPurchaseDate() {
        return lastPurchaseDate;
    }

    public void setLastPurchaseDate(String lastPurchaseDate) {
        this.lastPurchaseDate = lastPurchaseDate;
    }




}
