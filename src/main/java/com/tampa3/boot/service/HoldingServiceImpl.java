package com.tampa3.boot.service;

import com.tampa3.boot.entity.Holding;
import com.tampa3.boot.repository.HoldingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class HoldingServiceImpl {

    @Autowired
    HoldingRepository repo;

    public Collection<Holding> getHoldings(){
        return repo.findAll();
    }
}
