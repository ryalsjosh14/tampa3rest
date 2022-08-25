package com.tampa3.boot.service;


import com.tampa3.boot.entity.PurchaseOrder;
import com.tampa3.boot.repository.PurchaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class OrderServiceImpl {

    @Autowired
    private PurchaseOrderRepository por;

    //add order
    public PurchaseOrder addNewOrder(PurchaseOrder purchaseOrder)
    {
        return por.save(purchaseOrder);
    }

    //get order by id
    public PurchaseOrder getOrderById(int id)
    {
        Optional<PurchaseOrder> orderOptional = por.findById(id);

        if(orderOptional.isPresent())
            return orderOptional.get();
        else return null;
    }

    //cancel an order - delete
    public void cancelOrder(PurchaseOrder purchaseOrder)
    {
        //check status before cancelling
        if(purchaseOrder.getSTATUS_CODE().equals("pending"))
            por.deleteById(purchaseOrder.getId());
    }

    //get all orders - for showing history
    public Iterable<PurchaseOrder> getAllOrders()
    {
        return por.findAll();
    }
}
