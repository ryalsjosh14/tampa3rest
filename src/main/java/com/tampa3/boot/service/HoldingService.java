package com.tampa3.boot.service;

import com.tampa3.boot.entity.Holding;
import com.tampa3.boot.entity.PurchaseOrder;

import java.util.Collection;

public interface HoldingService {
    //this is a service

    //show all holdings
    Collection<Holding> getAllHoldings();

    Holding getHoldingById(String ticker);

    Holding getHolding(Holding holding);

    //add holding to current inventory ->pass in order ot create holding
    Holding addNewHolding(PurchaseOrder order);

    //sell holding - delete by passing in ticker.
    // so when clicked to sell, grab ticker (id)
    void sellHolding(String ticker);
}
