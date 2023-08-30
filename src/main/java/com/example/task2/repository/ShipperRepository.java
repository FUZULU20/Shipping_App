package com.example.task2.repository;

import com.example.task2.model.Shipper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipperRepository extends JpaRepository<Shipper, Long> {
    Shipper getShippersById(Long id);
}
