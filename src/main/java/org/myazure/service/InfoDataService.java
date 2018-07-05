package org.myazure.service;

import java.util.List;

import org.myazure.domain.Cushion;
import org.myazure.domain.Customer;
import org.myazure.domain.Driver;
import org.myazure.domain.Factory;
import org.myazure.domain.Payment;
import org.myazure.domain.Plan;
import org.myazure.domain.Vehicle;

public interface InfoDataService {
	List<Vehicle> getVehicles(String key);

	List<Driver> getDrivers(String key);

	List<Factory> getFactories(String key);

	List<Customer> getCustomers(String key);

	List<Payment> getPayments(String key);

	List<Cushion> getCushions(String key);

	List<Plan> getPlans(String key);

}
