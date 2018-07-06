package org.myazure.service;

import java.util.List;

import org.myazure.domain.Cushion;
import org.myazure.domain.Customer;
import org.myazure.domain.Driver;
import org.myazure.domain.Factory;
import org.myazure.domain.Order;
import org.myazure.domain.Payment;
import org.myazure.domain.Plan;
import org.myazure.domain.Vehicle;

public interface InfoDataService {
	List<Vehicle> getVehicles(String key);

	List<Driver> getDrivers(String key);

	Driver getDriver(String name, String phone);

	Driver creatDriver(Driver driver);
	
	List<Factory> getFactories(String key);

	List<Customer> getCustomers(String key);

	List<Payment> getPaymentsByOrderId(Long id);

	List<Payment> getPaymentsByCreatorId(Long id);

	Payment getPaymentsByPaymentId(Long id);

	List<Payment> getPaymentsByRemarks(String key);

	List<Cushion> getCushionsByOrderId(Long id);

	List<Cushion> getCushionsByCreatorId(Long id);

	Cushion getCushionsByCushionId(Long id);

	List<Cushion> getCushionsByRemarks(String key);

	List<Plan> getPlans(String key);

	List<Order> getOrders(String key);

	List<Order> getOrdersByState(int state);

	List<Order> getOrdersByCreator(Long id);

	List<Order> getOrdersByCustomer(Long id);

	List<Order> getOrdersByFactory(Long id);

	List<Order> getOrdersByVehicle(Long id);

	List<Order> getOrdersByTransportDriver(Long id);

	List<Order> getOrdersByDeliveryDriver(Long id);

	List<Order> getOrdersByEntryNumber(String number);

	List<Order> getOrdersByCustomerNumber(String number);

	List<Order> getOrdersByPickupNumber(String number);

	List<Order> getOrdersByTransferNumber(String number);

	List<Order> getOrdersBySource(String source);

	List<Order> getOrdersByDestination(String destination);

	List<Order> getOrdersByRemarks(String remarks);

	Customer getCustomer(String name, String address);

	Customer creatCustomer(Customer customer);

	Factory getFactory(String name, String address);

	Factory creatFactory(Factory factory);

	Vehicle getVehicle(String carLicensePlate);

	Vehicle creatVehicle(Vehicle vehicle);

	List<Driver> getDriversByLast5Orders();
}
