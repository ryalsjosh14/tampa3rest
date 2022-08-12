package com.tampa3.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tampa3.boot.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
