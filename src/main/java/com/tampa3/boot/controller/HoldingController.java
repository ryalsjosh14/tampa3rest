package com.tampa3.boot.controller;

import com.tampa3.boot.entity.Holding;
import com.tampa3.boot.entity.Order;
import com.tampa3.boot.service.HoldingServiceImpl;
import com.tampa3.boot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/holdings")
public class HoldingController {

    @Autowired
    private HoldingServiceImpl service;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Holding> getHoldings() {
        return service.getHoldings();
    }
}
