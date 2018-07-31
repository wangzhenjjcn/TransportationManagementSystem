package org.myazure.service.impl;

import java.util.Date;
import java.util.List;

import org.myazure.domain.Customer;
import org.myazure.domain.Driver;
import org.myazure.domain.Factory;
import org.myazure.domain.Order;
import org.myazure.domain.Plan;
import org.myazure.domain.Vehicle;
import org.myazure.domain.WebUser;
import org.myazure.repository.CustomerRepository;
import org.myazure.repository.DriverRepository;
import org.myazure.repository.FactoryRepository;
import org.myazure.repository.OrderRepository;
import org.myazure.repository.PlanRepository;
import org.myazure.repository.VehicleRepository;
import org.myazure.repository.WebUserRepository;
import org.myazure.service.OrderService;
import org.myazure.utils.S;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

@Service("OrderService")
@Component
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

	@Autowired
	private DriverRepository driverRepository;

	public static WebUser defaultUser;
	public static Vehicle defaultVehicle;
	public static Factory defaultFactory;
	public static Customer defaultCustomer;
	public static Plan defaultPlan;
	public static Driver defaultDriver;

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
		if (defaultDriver == null) {
			defaultDriver = driverRepository.findOne(1L);
		}

	}

	@Override
	public List<Order> getLast5Orders() {
		return orderRepository.findFiveByOrderDateAfter(new Date(System.currentTimeMillis()));
	}

	@Override
	public Order saveOrder(Order order) {
		Check();
		Order newOrder = order;
		if (newOrder.getCreatorUser() == null) {
			newOrder.setCreatorUser(defaultUser);
		} else if (newOrder.getCreatorUser().getId() == null) {
			newOrder.setCreatorUser(defaultUser);
		}

		if (newOrder.getDeliveryDriverUser() == null) {
			newOrder.setDeliveryDriverUser(defaultUser);
		} else if (newOrder.getDeliveryDriverUser().getId() == null) {
			newOrder.setDeliveryDriverUser(defaultUser);
		}

		if (newOrder.getCustomerUser() == null) {
			newOrder.setCustomerUser(defaultUser);
		} else if (newOrder.getCustomerUser().getId() == null) {
			newOrder.setCustomerUser(defaultUser);
		}
		if (newOrder.getTransportDriverUser() == null) {
			newOrder.setTransportDriverUser(defaultUser);
		} else if (newOrder.getTransportDriverUser().getId() == null) {
			newOrder.setTransportDriverUser(defaultUser);
		}
		if (newOrder.getDeliveryDriverUser() == null) {
			newOrder.setDeliveryDriverUser(defaultUser);
		} else if (newOrder.getDeliveryDriverUser().getId() == null) {
			newOrder.setDeliveryDriverUser(defaultUser);
		}
		if (newOrder.getFactoryUser() == null) {
			newOrder.setFactoryUser(defaultUser);
		} else if (newOrder.getFactoryUser().getId() == null) {
			newOrder.setFactoryUser(defaultUser);
		}
		if (newOrder.getDeliveryVehicle() == null) {
			newOrder.setDeliveryVehicle(defaultVehicle);
		} else if (newOrder.getDeliveryVehicle().getId() == null) {
			newOrder.setDeliveryVehicle(defaultVehicle);
		}
		if (newOrder.getTransportVehicle() == null) {
			newOrder.setTransportVehicle(defaultVehicle);
		} else if (newOrder.getTransportVehicle().getId() == null) {
			newOrder.setTransportVehicle(defaultVehicle);
		}
		if (newOrder.getFactory() == null) {
			newOrder.setFactory(defaultFactory);
		} else if (newOrder.getFactory().getId() == null) {
			newOrder.setFactory(defaultFactory);
		}
		
		
		if (newOrder.getTransportVehicleDriver() == null) {
			newOrder.setTransportVehicleDriver(defaultDriver);
		} else if (newOrder.getTransportVehicleDriver().getId() == null) {
			newOrder.setTransportVehicleDriver(defaultDriver);
		}
		
		

		if (newOrder.getDeliveryVehicleDriver() == null) {
			newOrder.setDeliveryVehicleDriver(defaultDriver);
		} else if (newOrder.getDeliveryVehicleDriver().getId() == null) {
			newOrder.setDeliveryVehicleDriver(defaultDriver);
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
		order.setFreightType(S.getRandomNum(1));
		order.setSource("上海");
		order.setOrderDate(new Date(System.currentTimeMillis()));
		order.setOrderCreatDate(new Date(System.currentTimeMillis()));
		order.setPakages(S.getRandomNum(2));
		order.setPickupNumber(S.getRandomString(12));
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
		order.setDeliveryVehicleDriver(defaultDriver);
		order.setTransportVehicleDriver(defaultDriver);
		orderRepository.save(order);
		return order;
	}

	@Override
	public Order getOrder(long id) {
		return orderRepository.findOne(id);
	}

}
