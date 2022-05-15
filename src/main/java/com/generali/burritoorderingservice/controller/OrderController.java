package com.generali.burritoorderingservice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generali.burritoorderingservice.entity.Order;
import com.generali.burritoorderingservice.service.OrderService;

@RestController
@RequestMapping("/orders")
@Validated
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping
	public Order create(@Valid @RequestBody Order order) {
		Order reponse = orderService.create(order);
		return order;
	}

	@GetMapping("/{orderId}")
	public Order retrieve(@PathVariable Long orderId) {
		Order response = orderService.retrieve(orderId);
		return response;
	}

}
