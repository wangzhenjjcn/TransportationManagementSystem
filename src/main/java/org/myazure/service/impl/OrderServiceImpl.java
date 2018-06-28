package org.myazure.service.impl;

import java.util.List;

import org.myazure.domain.Order;
import org.myazure.repository.OrderRepository;
import org.myazure.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("OrderService")
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public List<Order> getLastOrders() {
// 		orderRepository.findTop5OrderByOrderIdAsc();
		return null;
	}

	@Override
	public void saveOrder(Order order) {
			orderRepository.save(order);
	}

}
