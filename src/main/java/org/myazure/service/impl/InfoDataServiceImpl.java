package org.myazure.service.impl;

import java.util.List;

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
		return vehicleRepository.findByCarLicensePlateContaining(key);
	}

	@Override
	public List<Driver> getDrivers(String key) {
		return driverRepository
				.findByNameContainingOrNamepyContaining(key, key);
	}

	@Override
	public List<Factory> getFactories(String key) {
		return factoryRepository
				.findByNameContainingOrNamepyContainingOrAddressContainingOrAddresspyContainingOrContactContaining(
						key, key, key, key, key);
	}

	@Override
	public List<Customer> getCustomers(String key) {
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
		return planRepository
				.findByCompanyNameContainingOrSourceContainingOrSourcepyContainingOrDestinationContainingOrDestinationpyContaining(
						key, key, key, key, key);
	}

	@Override
	public List<Order> getOrders(String key) {
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

}
