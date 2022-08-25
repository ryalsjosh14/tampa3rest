package com.tampa3.boot.controller;

import com.tampa3.boot.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tampa3.boot.entity.PurchaseOrder;

import java.util.Date;


@RestController
@RequestMapping("/order/")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderServiceImpl service;

    @RequestMapping(method = RequestMethod.GET, value = "/get/{id}")
    public PurchaseOrder getOrderById(@PathVariable("id") int id) {
        return service.getOrderById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public Iterable<PurchaseOrder> GetAllOrders()
    {
        return service.getAllOrders();
    }

    //add order -> will need to take input, create new purchase order object,
    //then call addNewOrder to insert.
    @RequestMapping(method = RequestMethod.POST, value = "/add/")
    public PurchaseOrder addNewOrder(@RequestBody PurchaseOrder purchaseOrder)
    {
        System.out.println(purchaseOrder.getTicker());
        return service.addNewOrder(purchaseOrder);
    }

    //cancel an order - so delete it
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public void cancelOrder(@PathVariable("id") int id) {
        PurchaseOrder purchaseOrder = getOrderById(id);
        System.out.println(purchaseOrder.getTicker());
        service.cancelOrder(purchaseOrder);
   }



}
