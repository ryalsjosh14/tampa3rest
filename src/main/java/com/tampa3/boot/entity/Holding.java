package com.tampa3.boot.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="current_holding")
public class Holding implements Serializable {

    @Id
    @GeneratedValue
    @Column(name="ticker") private String ticker;

    @Column(name="shares") private String numShares;
    @Column(name="average_price") private Double averagePrice;
    @Column(name="last_purchase_date") private String lastPurchaseDate;


}
