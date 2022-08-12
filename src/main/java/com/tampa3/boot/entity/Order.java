package com.tampa3.boot.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
//Need to add a table
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idOrder")
    private int id;

    //Need to add table name to all attributes
    @Column(name="ticker") private String ticker;//Symbol
    @Column(name="priceToBuy") private double priceToBuy;
    @Column(name="numberOfShares") private int numberOfShares;
    @Column(name="orderDate") private Date orderDate;
    @Column(name="statusCode") private String STATUS_CODE;



    //Constructor

    public Order(String ticker, double priceToBuy, int numberOfShares, Date orderDate, String STATUS_CODE) {
        this.ticker = ticker;
        this.priceToBuy = priceToBuy;
        this.numberOfShares = numberOfShares;
        this.orderDate = orderDate;
        this.STATUS_CODE = STATUS_CODE;
    }

    //Def constructor
    public Order() {}

    //getters and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public double getPriceToBuy() {
        return priceToBuy;
    }

    public void setPriceToBuy(double priceToBuy) {
        this.priceToBuy = priceToBuy;
    }

    public int getNumberOfShares() {
        return numberOfShares;
    }

    public void setNumberOfShares(int numberOfShares) {
        this.numberOfShares = numberOfShares;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getSTATUS_CODE() {
        return STATUS_CODE;
    }

    public void setSTATUS_CODE(String STATUS_CODE) {
        this.STATUS_CODE = STATUS_CODE;
    }
}
