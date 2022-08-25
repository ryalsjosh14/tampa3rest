package com.tampa3.boot.service;

import com.tampa3.boot.entity.Holding;
import com.tampa3.boot.repository.HoldingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;


@Service
public class HoldingServiceImpl {

    @Autowired
    private HoldingRepository hr;

    public Collection<Holding> getAllHoldings(){
        return hr.findAll();
    }

    //pass in id and return holding
    public Holding getHoldingById(String ticker)
    {
        Optional<Holding> holdOpt = hr.findById(ticker);

        if(holdOpt.isPresent())
            return holdOpt.get();
        else return null;
    }

    //pass in holding and return
    public Holding getHolding(Holding holding)
    {
        return holding;
    }

    public Holding addNewHolding(Holding holding)
    {
        return hr.save(holding);
    }

    //sells holding using delete
    public void sellHolding(Holding holding)
    {
        //Holding holding = hr.findById(ticker).get();
        hr.deleteById(holding.getTicker());
    }

    public void deleteHoldingById(Holding holding)
    {
        hr.delete(holding);
    }
}
