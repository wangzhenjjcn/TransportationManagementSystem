package org.myazure.service;

import java.util.List;

import org.myazure.domain.Order;
 
public interface OrderService {
	 
	List<Order> getLastOrders();
	void saveOrder(Order order);

}
