package com.generali.burritoorderingservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.generali.burritoorderingservice.entity.Order;
import com.generali.burritoorderingservice.repository.OrderRepository;

@SpringBootTest
public class OrderServiceTest {
	
	@Autowired
	private OrderService orderService;
	
	@MockBean
	private OrderRepository orderRepository;
	
	@Test
	void testCreate() throws Exception {
		Order order = new Order();
		order.setTortilla("corn");
		
		Order mockResponse = new Order();
		mockResponse.setId(1L);
		mockResponse.setTortilla("corn");

        Mockito.when(orderRepository.save(order)).thenReturn(mockResponse);
        
        Order reponse = orderService.create(order);

        assertEquals(1L, reponse.getId());
	}
	
	@Test
	void testRetrieve() throws Exception {
		Order mockResponse = new Order();
		mockResponse.setId(1L);
		mockResponse.setTortilla("corn");

        Mockito.when(orderRepository.getById(1L)).thenReturn(mockResponse);
        
        Order response = orderService.retrieve(1L);

        assertEquals(1L, response.getId());
	}

}
