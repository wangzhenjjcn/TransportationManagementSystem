package org.myazure.service.impl;

import java.util.List;

import org.myazure.domain.Cushion;
import org.myazure.domain.Customer;
import org.myazure.domain.Driver;
import org.myazure.domain.Factory;
import org.myazure.domain.Payment;
import org.myazure.domain.Plan;
import org.myazure.domain.Vehicle;
import org.myazure.repository.CustomerRepository;
import org.myazure.repository.DriverRepository;
import org.myazure.repository.FactoryRepository;
import org.myazure.repository.PaymentRepository;
import org.myazure.repository.VehicleRepository;
import org.myazure.repository.WebUserRepository;
import org.myazure.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("InfoService")
public class InfoServiceImpl implements InfoService {
	@Autowired
	private WebUserRepository webUserRepository;

	@Autowired
	private VehicleRepository vehicleRepository;

	@Autowired
	private DriverRepository driverRepository;

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private  CustomerRepository customerRepository;
	@Autowired
	private FactoryRepository factoryRepository;
	@Override
	public List<Vehicle> getVehicles(String key) {
		return vehicleRepository.findByCarLicensePlateLike(key);
	}
	@Override
	public List<Driver> getDrivers(String key) {
		return driverRepository.findByNameOrNamepyLike(key);
	}
	@Override
	public List<Factory> getFactories(String key) {
		return factoryRepository.findByNameOrNamepyOrAddressOrContactLike(key);
	}
	@Override
	public List<Customer> getCustomers(String key) {
		return customerRepository.findByNameOrNamepyOrAddressOrAddresspyOrContactLike(key);
	}
	
	@Override
	public List<Payment> getPayments(String key) {
		return null;
	}
	@Override
	public List<Cushion> getCushions(String key) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Plan> getPlans(String key) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
}
