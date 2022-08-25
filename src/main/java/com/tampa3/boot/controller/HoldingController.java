package com.tampa3.boot.controller;

import com.tampa3.boot.entity.Holding;
import com.tampa3.boot.entity.PurchaseOrder;
import com.tampa3.boot.service.HoldingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/holdings/")
@CrossOrigin
public class HoldingController {

    @Autowired
    private HoldingServiceImpl service;

    @RequestMapping(method = RequestMethod.GET, value = "/{ticker}")
    public Holding getHoldingById(@PathVariable("ticker") String ticker) {
        return service.getHoldingById(ticker);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public Collection<Holding> getAllHoldings() {
        return service.getAllHoldings();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add/")
    public Holding addNewHolding(@RequestBody Holding holding)
    {
        System.out.println(holding.getTicker());
        return service.addNewHolding(holding);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/")
    public void sellHolding(@RequestBody Holding holding)
    {
        //Holding holding = getHoldingById(ticker);
        service.sellHolding(holding);
    }
}
