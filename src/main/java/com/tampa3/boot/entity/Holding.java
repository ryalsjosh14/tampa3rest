package com.tampa3.boot.entity;

import javax.persistence.*;

@Entity
@Table(name="current_holding")
public class Holding {

    @Id
    @GeneratedValue
    @Column(name="ticker") private String ticker;

    @Column(name="shares") private String numShares;
    @Column(name="averagePrice") private Double averagePrice;
    @Column(name="lastPurchaseDate") private String lastPurchaseDate;

}
