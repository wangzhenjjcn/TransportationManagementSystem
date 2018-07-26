package org.myazure.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javassist.expr.NewArray;

import org.myazure.domain.Cushion;
import org.myazure.domain.Customer;
import org.myazure.domain.Driver;
import org.myazure.domain.Factory;
import org.myazure.domain.Order;
import org.myazure.domain.Payment;
import org.myazure.domain.Plan;
import org.myazure.domain.Vehicle;
import org.myazure.repository.CushionRepository;
import org.myazure.repository.CustomerRepository;
import org.myazure.repository.DriverRepository;
import org.myazure.repository.FactoryRepository;
import org.myazure.repository.OrderRepository;
import org.myazure.repository.PaymentRepository;
import org.myazure.repository.PlanRepository;
import org.myazure.repository.VehicleRepository;
import org.myazure.repository.WebUserRepository;
import org.myazure.service.InfoDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service("InfoDataService")
public class InfoDataServiceImpl implements InfoDataService {
	private static final Logger LOG = LoggerFactory
			.getLogger(InfoDataService.class);

	@Autowired
	private WebUserRepository webUserRepository;
	@Autowired
	private VehicleRepository vehicleRepository;
	@Autowired
	private DriverRepository driverRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private FactoryRepository factoryRepository;
	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private CushionRepository cushionRepository;
	@Autowired
	private PlanRepository planRepository;
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public List<Vehicle> getVehicles(String key) {
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		if (key.isEmpty()) {
			for (Vehicle vehicle: vehicleRepository.findAll()) {
				vehicles.add(vehicle);
			}
			return vehicles;
		}
		return vehicleRepository.findByCarLicensePlateContaining(key);
	}

	@Override
	public List<Driver> getDrivers(String key) {
		List<Driver> drivers = new ArrayList<Driver>();
		if (key.isEmpty()) {
			for (Driver driver : driverRepository.findAll()) {
				drivers.add(driver);
			}
			return drivers;
		}
		return driverRepository
				.findByNameContainingOrNamepyContaining(key, key);
	}

	@Override
	public Driver getDriver(String name, String phone) {
		return driverRepository.findFirstByNameAndPhone(name, phone);
	}

	@Override
	public List<Factory> getFactories(String key) {
		List<Factory> factories = new ArrayList<Factory>();
		if (key.isEmpty()) {
			for (Factory factory : factoryRepository.findAll()) {
				factories.add(factory);
			}
			return factories;
		}
		return factoryRepository
				.findByNameContainingOrNamepyContainingOrAddressContainingOrAddresspyContainingOrContactContaining(
						key, key, key, key, key);
	}

	@Override
	public List<Customer> getCustomers(String key) {
		List<Customer> customers = new ArrayList<Customer>();
		if (key.isEmpty()) {
			for (Customer customer : customerRepository.findAll()) {
				customers.add(customer);
			}
			return customers;
		}
		return customerRepository
				.findByNameContainingOrNamepyContainingOrAddressContainingOrAddresspyContainingOrContactContaining(
						key, key, key, key, key);
	}

	@Override
	public List<Payment> getPaymentsByOrderId(Long id) {
		return paymentRepository.findByOrderId(id);
	}

	@Override
	public List<Payment> getPaymentsByCreatorId(Long id) {
		return paymentRepository.findByCreatorUserId(id);
	}

	@Override
	public Payment getPaymentsByPaymentId(Long id) {
		return paymentRepository.findOne(id);
	}

	@Override
	public List<Payment> getPaymentsByRemarks(String key) {
		return paymentRepository.findByRemarksContainingOrRemarkspyContaining(
				key, key);
	}

	@Override
	public List<Cushion> getCushionsByOrderId(Long id) {
		return cushionRepository.findByOrderId(id);
	}

	@Override
	public List<Cushion> getCushionsByCreatorId(Long id) {
		return cushionRepository.findByCreatorUserId(id);
	}

	@Override
	public Cushion getCushionsByCushionId(Long id) {
		return cushionRepository.findOne(id);
	}

	@Override
	public List<Cushion> getCushionsByRemarks(String key) {
		return cushionRepository.findByRemarksContainingOrRemarkspyContaining(
				key, key);
	}

	@Override
	public List<Plan> getPlans(String key) {
		List<Plan> plans = new ArrayList<Plan>();
		if (key.isEmpty()) {
			for (Plan plan : planRepository.findAll()) {
				plans.add(plan);
			}
			return plans;
		}
		return planRepository
				.findByCompanyNameContainingOrSourceContainingOrSourcepyContainingOrDestinationContainingOrDestinationpyContaining(
						key, key, key, key, key);
	}

	@Override
	public List<Order> getOrders(String key) {
		List<Order> orders = new ArrayList<Order>();
		if (key.isEmpty()) {
			for (Order order: orderRepository.findAll()) {
				orders.add(order);
			}
			return orders;
		}
		return orderRepository
				.findByEntryNumberContainingOrCustomerNumberContainingOrPickupNumberContainingOrTransferNumberContainingOrSourceContainingOrSourcepyContainingOrDestinationContainingOrDestinationpyContainingOrTransportVehicleRegistrationNumberContainingOrDeliveryVehicleRegistrationNumberContainingOrContactNameContainingOrContactNamepyContainingOrRemarksContainingOrRemarkspyContaining(
						key, key, key, key, key, key, key, key, key, key, key,
						key, key, key);
	}

	@Override
	public List<Order> getLastFiveOrders() {
		List<Order> orders = new ArrayList<Order>();
		orders=orderRepository.findTop5OrderByCreatAtDesc();
		return orders;
	}

	@Override
	public List<Order> getTodayOrders() {
		List<Order> orders = new ArrayList<Order>();
		orders=orderRepository.findByCreatedAtAfter(new Date(System.currentTimeMillis()-System.currentTimeMillis()%100000));
		return orders;
	}

	@Override
	public List<Order> getYesterdayOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getThisMonthOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getLastMonthOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getThisSeasonOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getThisYearOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getOrdersByState(int state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getOrdersByCreator(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getOrdersByCustomer(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getOrdersByFactory(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getOrdersByVehicle(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getOrdersByTransportDriver(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getOrdersByDeliveryDriver(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getOrdersByEntryNumber(String number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getOrdersByCustomerNumber(String number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getOrdersByPickupNumber(String number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getOrdersByTransferNumber(String number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getOrdersBySource(String source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getOrdersByDestination(String destination) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getOrdersByRemarks(String remarks) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Driver creatDriver(Driver driver) {
		return driverRepository.save(driver);
	}

	@Override
	public Customer getCustomer(String name, String address) {
		return customerRepository.findFirstByNameAndAddress(name, address);
	}

	@Override
	public Customer creatCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Factory getFactory(String name, String address) {
		return factoryRepository.findFirstByNameAndAddress(name, address);
	}

	@Override
	public Factory creatFactory(Factory factory) {
		return factoryRepository.save(factory);
	}

	@Override
	public Vehicle getVehicle(String carLicensePlate) {
		return vehicleRepository.findFirstByCarLicensePlate(carLicensePlate);
	}

	@Override
	public Vehicle creatVehicle(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}

	@Override
	public List<Driver> getDriversByLast5Orders() {
		Map<Long, Driver> driversMap=new HashMap<Long, Driver>();
		for (Order	order : orderRepository.findTop5OrderByCreatAtDesc()) {
			driversMap.put(order.getDeliveryVehicleDriver().getId(), order.getDeliveryVehicleDriver());
			driversMap.put(order.getTransportVehicleDriver().getId(), order.getTransportVehicleDriver());
		}
		List<Driver> drivers=new ArrayList<Driver>();
		for (Driver driver : driversMap.values()) {
			drivers.add(driver);
		}
		return drivers;
	}

	@Override
	public Driver getDrivers(Long id) {
		return driverRepository.findOne(id);
	}

	@Override
	public Factory getFactories(Long id) {
		return factoryRepository.findOne(id);
	}

	@Override
	public Plan getPlans(Long id) {
		return planRepository.findOne(id);
	}

	@Override
	public Plan creatPlan(Plan plan) {
		return planRepository.save(plan);
	}

	@Override
	public Vehicle getVehicle(Long id) {
		return vehicleRepository.findOne(id);
	}

	@Override
	public Customer getCustomer(Long id) {
		return customerRepository.findOne(id);
	}

	@Override
	public Customer findOrCreatCustomer(String name) {
		List<Customer> resault=getCustomers(name);
		if (resault==null||resault.size()<1) {
			Customer customer=new Customer();
			customer.setName(name);
			return creatCustomer(customer);
		}else {
			return resault.get(0);
		}
	}

	@Override
	public Factory findOrCreatFactory(String factoryName) {
		List<Factory> resault=getFactories(factoryName);
		if (resault==null||resault.size()<1) {
			Factory factory=new Factory();
			factory.setName(factoryName);
			return creatFactory(factory);
		}else {
			return resault.get(0);
		}
	}

}
