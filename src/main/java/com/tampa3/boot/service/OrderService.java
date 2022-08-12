package com.tampa3.boot.service;

import com.tampa3.boot.entity.PurchaseOrder;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    //add order
    PurchaseOrder addNewOrder(PurchaseOrder purchaseOrder);

    //get order by id
    PurchaseOrder getOrderById(int id);

    //cancel an order - delete
    void cancelOrder(PurchaseOrder purchaseOrder);

    //get all orders - for showing history
    Iterable<PurchaseOrder> getAllOrders();
}
