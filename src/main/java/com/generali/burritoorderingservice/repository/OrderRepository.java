package com.generali.burritoorderingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generali.burritoorderingservice.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
