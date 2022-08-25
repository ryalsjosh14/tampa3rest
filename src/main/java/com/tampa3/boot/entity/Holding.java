package com.tampa3.boot.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="current_holdings")
public class Holding {

    @Id
    @Column(name="ticker") private String ticker;

    @Column(name="shares") private int numShares;
    @Column(name="average_price") private Double averagePrice;
    @Column(name="last_purchase_date") private Date lastPurchaseDate;
    @Column(name="money_spent") private double moneySpent;

    //constructors
    public Holding() { }

    public Holding(String ticker, int numShares, Double averagePrice, Date lastPurchaseDate, double moneySpent) {
        this.ticker = ticker;
        this.numShares = numShares;
        this.averagePrice = averagePrice;
        this.lastPurchaseDate = lastPurchaseDate;
        this.moneySpent = moneySpent;
    }


    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public int getNumShares() {
        return numShares;
    }

    public void setNumShares(int numShares) {
        this.numShares = numShares;
    }

    public Double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(Double averagePrice) {
        this.averagePrice = averagePrice;
    }

    public Date getLastPurchaseDate() {
        return lastPurchaseDate;
    }

    public void setLastPurchaseDate(Date lastPurchaseDate) {
        this.lastPurchaseDate = lastPurchaseDate;
    }

    public double getMoneySpent() {
        return moneySpent;
    }

    public void setMoneySpent(double moneySpent) {
        this.moneySpent = moneySpent;
    }


}
