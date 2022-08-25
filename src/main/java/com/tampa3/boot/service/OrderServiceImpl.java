package com.tampa3.boot.service;


import com.tampa3.boot.entity.Holding;
import com.tampa3.boot.repository.HoldingRepository;
import com.tampa3.boot.service.HoldingServiceImpl;
import com.tampa3.boot.service.HoldingService;
import com.tampa3.boot.entity.PurchaseOrder;
import com.tampa3.boot.repository.PurchaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Locale;
import java.util.Optional;

@Service
public class OrderServiceImpl {

    @Autowired
    private PurchaseOrderRepository por;
    @Autowired
    private HoldingServiceImpl service;


    //add order
    public PurchaseOrder addNewOrder(PurchaseOrder purchaseOrder)
    {
        //check if buying or selling, then adjust holding table
        PurchaseOrder response = por.save(purchaseOrder);

        if(response != null)
        {
           System.out.println("inserted successfully");

            //create holding object to pass to holding table
            Holding holding = new Holding(purchaseOrder.getTicker(), purchaseOrder.getNumberOfShares(), purchaseOrder.getPriceToBuy(), purchaseOrder.getOrderDate());

            if(purchaseOrder.getSTATUS_CODE().toLowerCase().equals("buy")) //send buy order to holding
            {
                Holding add = service.addNewHolding(holding);
            }
            else if(purchaseOrder.getSTATUS_CODE().toLowerCase().equals("sell")) //send sell order to holding
            {
                service.sellHolding(holding);
            }
        }
        return response;
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
        por.deleteById(purchaseOrder.getId());
    }

    //get all orders - for showing history
    public Iterable<PurchaseOrder> getAllOrders()
    {
        return por.findAll();
    }
}
