package com.tampa3.boot.service;

import com.tampa3.boot.entity.Order;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    //add order
    Order addNewOrder(Order order);

    //get order by id
    Order getOrderById(int id);

    //cancel an order - delete
    void cancelOrder(Order order);

    //get all orders - for showing history
    Iterable<Order> getAllOrders();
}
