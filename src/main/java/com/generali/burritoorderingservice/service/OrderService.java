package com.generali.burritoorderingservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generali.burritoorderingservice.entity.Order;
import com.generali.burritoorderingservice.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	public Order create(Order order) {
		Order response = orderRepository.save(order); 
		return response;
	}
	
	public Order retrieve(Long id) {
		Order response = orderRepository.getById(id);
		return response;
	}

}
