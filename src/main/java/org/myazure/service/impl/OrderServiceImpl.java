package org.myazure.service.impl;

import java.util.List;

import org.myazure.domain.Customer;
import org.myazure.domain.Factory;
import org.myazure.domain.Order;
import org.myazure.domain.Plan;
import org.myazure.repository.CustomerRepository;
import org.myazure.repository.FactoryRepository;
import org.myazure.repository.OrderRepository;
import org.myazure.repository.PlanRepository;
import org.myazure.repository.VehicleRepository;
import org.myazure.repository.WebUserRepository;
import org.myazure.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

@Service("OrderService")
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private WebUserRepository webUserRepository;
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private FactoryRepository factoryRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private PlanRepository planRepository;
	
	
	
	
	@Override
	public List<Order> getLastOrders() {
// 		orderRepository.findTop5OrderByOrderIdAsc();
		return null;
	}

	@Override
	public void saveOrder(Order order) {
		Order newOrder=order;
		if (newOrder.getCreatorUser().getId()==null) {
			newOrder.setCreatorUser(webUserRepository.findOneByUsername("default"));
		} 
		if (newOrder.getDeliveryDriverUser().getId()==null) {
			newOrder.setDeliveryDriverUser(webUserRepository.findOneByUsername("default"));
		} 
		if (newOrder.getCustomerUser().getId()==null) {
			newOrder.setCustomerUser(webUserRepository.findOneByUsername("default"));
		} 
		if (newOrder.getTransportDriverUser().getId()==null) {
			newOrder.setTransportDriverUser(webUserRepository.findOneByUsername("default"));
		} 
		if (newOrder.getDeliveryDriverUser().getId()==null) {
			newOrder.setDeliveryDriverUser(webUserRepository.findOneByUsername("default"));
		} 
		if (newOrder.getFactoryUser().getId()==null) {
			newOrder.setFactoryUser(webUserRepository.findOneByUsername("default"));
		} 
		if (newOrder.getDeliveryVehicle().getId()==null) {
			newOrder.setDeliveryVehicle(vehicleRepository.findOneByCarLicensePlate("default"));
		} 
		if (newOrder.getTransportVehicle().getId()==null) {
			newOrder.setTransportVehicle(vehicleRepository.findOneByCarLicensePlate("default"));;
		} 
		orderRepository.save(newOrder);
		System.out.println(JSON.toJSONString(newOrder));
	}

}
