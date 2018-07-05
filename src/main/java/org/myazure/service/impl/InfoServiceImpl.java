package org.myazure.service.impl;

import java.util.List;

import org.myazure.domain.Customer;
import org.myazure.domain.Driver;
import org.myazure.domain.Factory;
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
		return null;
	}
	@Override
	public List<Driver> getDrivers(String key) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Factory> getFactories(String key) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Customer> getCustomers(String key) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
}
