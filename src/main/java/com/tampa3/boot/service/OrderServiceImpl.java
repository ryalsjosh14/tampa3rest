package com.tampa3.boot.service;


import com.tampa3.boot.entity.Order;
import com.tampa3.boot.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl {

    @Autowired
    private OrderRepository dao;

    //add order
    public Order addNewOrder(Order order)
    {
        order.setId(0);
        return dao.save(order);
    }

    //get order by id
    public Order getOrderById(int id)
    {
        Optional<Order> orderOptional = dao.findById(id);

        if(orderOptional.isPresent())
            return orderOptional.get();
        else return null;
    }

    //cancel an order - delete
    public void cancelOrder(Order order)
    {
        //check status before cancelling
        if(order.getSTATUS_CODE().equals("Pending"))
            dao.deleteById(order.getId());
    }

    //get all orders - for showing history
    public Iterable<Order> getAllOrders()
    {
        return dao.findAll();
    }


}
