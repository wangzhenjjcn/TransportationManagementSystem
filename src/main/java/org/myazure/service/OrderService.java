package org.myazure.service;

import java.util.List;

import org.myazure.domain.Order;
 
public interface OrderService {
	 
	Order saveOrder(Order order);
	List<Order> getLast5Orders();

}
