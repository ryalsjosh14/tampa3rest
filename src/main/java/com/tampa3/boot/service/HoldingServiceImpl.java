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
        //check if the holding already exists
        Optional<Holding> opt = hr.findById(holding.getTicker());

        //if it already exists, adjust fields and inserts updated holding
        if(opt.isPresent())
        {
            Holding existingHolding = hr.findById(holding.getTicker()).get();

            //update total shares
            int totalShares = holding.getNumShares() + existingHolding.getNumShares();
            //update money spent
            double moneySpent = holding.getMoneySpent() + existingHolding.getMoneySpent();
            //update average price
            double avgPrice = moneySpent / totalShares;


            Holding newHolding = new Holding(holding.getTicker(), totalShares, avgPrice,
                    holding.getLastPurchaseDate(), moneySpent);

            return hr.save(newHolding);
        }
        else //if doesnt exist, just insert the input
            return hr.save(holding);

    }


    //sells holding using delete
    public void sellHolding(Holding holding)
    {
        //check if it exists
        Optional<Holding> opt = hr.findById(holding.getTicker());

        if(opt.isPresent())
        {
            Holding existingHolding = hr.findById(holding.getTicker()).get();

            int totalShares = existingHolding.getNumShares() - holding.getNumShares();
            Holding newHolding = new Holding(holding.getTicker(), totalShares, holding.getAveragePrice(),
                    holding.getLastPurchaseDate(), holding.getMoneySpent());

            if(totalShares > 0)
                hr.save(newHolding);
            else //if they sell everything, delete stock from holding
                hr.deleteById(holding.getTicker());
        }
        else
            System.out.println("you have no holdings of that stock");
    }

    public void deleteHoldingById(Holding holding)
    {
        hr.delete(holding);
    }
}
