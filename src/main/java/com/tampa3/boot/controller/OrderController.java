package com.tampa3.boot.controller;

import com.tampa3.boot.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.tampa3.boot.entity.Order;


@RestController
@RequestMapping("/")
public class OrderController {

    @Autowired private OrderServiceImpl service;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Order getOrderById(@PathVariable("id") int id) {
        //return service.getCompactDiscById(id);
        //placeholder
        return new Order();
    }
}
