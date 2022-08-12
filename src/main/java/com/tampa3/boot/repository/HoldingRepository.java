package com.tampa3.boot.repository;

import com.tampa3.boot.entity.Holding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoldingRepository extends JpaRepository<Holding, String> {
}
