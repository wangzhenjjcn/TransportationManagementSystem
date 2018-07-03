package org.myazure.service.impl;

import java.util.List;

import org.myazure.domain.Customer;
import org.myazure.domain.Factory;
import org.myazure.domain.Order;
import org.myazure.domain.Plan;
import org.myazure.domain.Vehicle;
import org.myazure.domain.WebUser;
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
	
	public static WebUser defaultUser;
	public static Vehicle defaultVehicle;
	public static Factory  defaultFactory;
	
	
	@Override
	public List<Order> getLast5Orders() {
		return orderRepository.findTop5ByOrderByOrderIdDesc();
	}

	@Override
	public Order saveOrder(Order order) {
		Order newOrder=order;
		if (defaultUser==null) {
			defaultUser	=webUserRepository.findOneByUsername("default");
		}
		if (defaultVehicle==null) {
			defaultVehicle =vehicleRepository.findOneByCarLicensePlate("default");
		}
		
		if (defaultFactory==null) {
			defaultFactory =factoryRepository.findOneByName("default");
		}
		if (newOrder.getCreatorUser().getId()==null) {
			newOrder.setCreatorUser(defaultUser);
		} 
		if (newOrder.getDeliveryDriverUser().getId()==null) {
			newOrder.setDeliveryDriverUser(defaultUser);
		} 
		if (newOrder.getCustomerUser().getId()==null) {
			newOrder.setCustomerUser(defaultUser);
		} 
		if (newOrder.getTransportDriverUser().getId()==null) {
			newOrder.setTransportDriverUser(defaultUser);
		} 
		if (newOrder.getDeliveryDriverUser().getId()==null) {
			newOrder.setDeliveryDriverUser(defaultUser);
		} 
		if (newOrder.getFactoryUser().getId()==null) {
			newOrder.setFactoryUser(defaultUser);
		} 
		if (newOrder.getDeliveryVehicle().getId()==null) {
			newOrder.setDeliveryVehicle(defaultVehicle);
		} 
		if (newOrder.getTransportVehicle().getId()==null) {
			newOrder.setTransportVehicle(defaultVehicle);;
		} 
		
		if (newOrder.getFactory().getId()==null) {
			newOrder.setFactory(defaultFactory);
		} 
		System.out.println(JSON.toJSONString(newOrder));
		return orderRepository.save(newOrder);
	}

}
