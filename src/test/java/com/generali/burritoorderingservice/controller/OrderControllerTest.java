package com.generali.burritoorderingservice.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.generali.burritoorderingservice.entity.Order;
import com.generali.burritoorderingservice.service.OrderService;

@WebMvcTest(OrderController.class)
public class OrderControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private OrderService orderService;
	
	@Test
	void testCreate() throws Exception {
		Order order = new Order();
		order.setTortilla("corn");
		
		Order response = new Order();
		response.setId(1L);
		response.setTortilla("corn");

        Mockito.when(orderService.create(order)).thenReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.post("/orders")
    			.contentType(MediaType.APPLICATION_JSON)
    			.content("{\r\n"
    					+ "  \"tortilla\": \"corn\",\r\n"
    					+ "  \"protein\": \"bean\",\r\n"
    					+ "  \"vegetables\": \"cabbage, corn\",\r\n"
    					+ "  \"salsa\" : \"mild\",\r\n"
    					+ "  \"extras\": \"avaocado\"\r\n"
    					+ "}"))
    			        .andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	void testRetrieve() throws Exception {		
		Order response = new Order();
		response.setId(1L);
		response.setTortilla("corn");

        Mockito.when(orderService.retrieve(1L)).thenReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.get("/orders/1")
    			.contentType(MediaType.APPLICATION_JSON))
    			.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
