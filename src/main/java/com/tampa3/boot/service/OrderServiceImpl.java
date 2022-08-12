package com.tampa3.boot.service;


import com.tampa3.boot.entity.PurchaseOrder;
import com.tampa3.boot.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl {

    @Autowired
    private OrderRepository dao;

    //add order
    public PurchaseOrder addNewOrder(PurchaseOrder purchaseOrder)
    {
        purchaseOrder.setId(0);
        return dao.save(purchaseOrder);
    }

    //get order by id
    public PurchaseOrder getOrderById(int id)
    {
        Optional<PurchaseOrder> orderOptional = dao.findById(id);

        if(orderOptional.isPresent())
            return orderOptional.get();
        else return null;
    }

    //cancel an order - delete
    public void cancelOrder(PurchaseOrder purchaseOrder)
    {
        //check status before cancelling
        if(purchaseOrder.getSTATUS_CODE().equals("Pending"))
            dao.deleteById(purchaseOrder.getId());
    }

    //get all orders - for showing history
    public Iterable<PurchaseOrder> getAllOrders()
    {
        return dao.findAll();
    }


}
