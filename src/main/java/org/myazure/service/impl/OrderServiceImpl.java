package org.myazure.service.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.Check;
import org.myazure.domain.Customer;
import org.myazure.domain.Factory;
import org.myazure.domain.Order;
import org.myazure.domain.Payment;
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
import org.myazure.utils.S;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

@Service("OrderService")
public class OrderServiceImpl implements OrderService {
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
	public static Factory defaultFactory;
	public static Customer defaultCustomer;
	public static Plan defaultPlan;

	protected void Check() {
		if (defaultUser == null) {
			defaultUser = webUserRepository.findOne(1L);
		}
		if (defaultVehicle == null) {
			defaultVehicle = vehicleRepository.findOne(1L);
		}
		if (defaultFactory == null) {
			defaultFactory = factoryRepository.findOne(1L);
		}
		if (defaultCustomer == null) {
			defaultCustomer = customerRepository.findOne(1L);
		}
		if (defaultPlan == null) {
			defaultPlan = planRepository.findOne(1L);
		}

	}

	@Override
	public List<Order> getLast5Orders() {
		return orderRepository.findTop5ByOrderByOrderIdDesc();
	}

	@Override
	public Order saveOrder(Order order) {
		Check();
		Order newOrder = order;
		if (newOrder.getCreatorUser().getId() == null) {
			newOrder.setCreatorUser(defaultUser);
		}
		if (newOrder.getDeliveryDriverUser().getId() == null) {
			newOrder.setDeliveryDriverUser(defaultUser);
		}
		if (newOrder.getCustomerUser().getId() == null) {
			newOrder.setCustomerUser(defaultUser);
		}
		if (newOrder.getTransportDriverUser().getId() == null) {
			newOrder.setTransportDriverUser(defaultUser);
		}
		if (newOrder.getDeliveryDriverUser().getId() == null) {
			newOrder.setDeliveryDriverUser(defaultUser);
		}
		if (newOrder.getFactoryUser().getId() == null) {
			newOrder.setFactoryUser(defaultUser);
		}
		if (newOrder.getDeliveryVehicle().getId() == null) {
			newOrder.setDeliveryVehicle(defaultVehicle);
		}
		if (newOrder.getTransportVehicle().getId() == null) {
			newOrder.setTransportVehicle(defaultVehicle);
		}
		if (newOrder.getFactory().getId() == null) {
			newOrder.setFactory(defaultFactory);
		}
		System.out.println(JSON.toJSONString(newOrder));
		return orderRepository.save(newOrder);
	}

	@Override
	public Order getNewOrder() {
		Check();
		Order order = new Order();
		order.setCreatorUser(defaultUser);
		order.setDeliveryDriverUser(defaultUser);
		order.setCustomerUser(defaultUser);
		order.setTransportDriverUser(defaultUser);
		order.setDeliveryDriverUser(defaultUser);
		order.setFactoryUser(defaultUser);
		order.setDeliveryVehicle(defaultVehicle);
		order.setTransportVehicle(defaultVehicle);
		order.setFactory(defaultFactory);
		order.setCarriageFee(S.getRandomNum(3));
		order.setChartered(false);
		order.setContactName("王师傅");
		order.setContactPhone("139" + S.getRandomNumString(8));
		order.setCustomerNumber("CSN" + S.getRandomNumString(5));
		order.setDestination("苏州");
		order.setDistence(S.getRandomNum(5));
		order.setEntryNumber(S.getRandomString(8));
		order.setFeeTime(S.getRandomNum(1));
		order.setFreightType(1);
		order.setSource("上海");
		order.setOrderDate(new Date(System.currentTimeMillis()));
		order.setOrderCreatDate(new Date(System.currentTimeMillis()));
		order.setPakages(S.getRandomNum(2));
		order.setPickUpNumber(S.getRandomString(12));
		order.setTransferNumber(S.getRandomString(8));
		order.setRemarks(S.getRandomString(10));
		order.setSize(S.getRandomNum(2));
		order.setWeight(S.getRandomNum(2));
		order.setPlan(defaultPlan);
		order.setCreatorUser(defaultUser);
		order.setCustomerUser(defaultUser);
		order.setDeliveryVehicle(defaultVehicle);
		order.setTransportVehicle(defaultVehicle);
		order.setFactory(defaultFactory);
		order.setCustomer(defaultCustomer);
		orderRepository.save(order);
		return order;
	}

	@Override
	public Order getOrder(long id) {
		return orderRepository.findOne(id);
	}

}
