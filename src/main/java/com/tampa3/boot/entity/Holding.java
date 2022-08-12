package com.tampa3.boot.entity;

import javax.persistence.Entity;

@Entity
public class Holding {

    private String ticker;
    private String numShares;
    private Double averagePrice;
    private String lastPurchaseDate;

}
