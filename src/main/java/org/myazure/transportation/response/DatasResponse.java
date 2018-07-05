package org.myazure.transportation.response;

import java.util.ArrayList;
import java.util.List;

import org.myazure.domain.Customer;
import org.myazure.domain.Driver;
import org.myazure.domain.Factory;
import org.myazure.domain.Order;
import org.myazure.domain.Plan;
import org.myazure.domain.Vehicle;
import org.myazure.domain.WebUser;
import org.myazure.response.StatusResponse;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DatasResponse<T> extends StatusResponse {

	@JsonProperty("data")
	@JSONField(name = "data")
	private List<T> data = new ArrayList<T>();

	@JsonProperty("num")
	@JSONField(name = "num")
	private int num = 0;

	@JsonProperty("last_order")
	@JSONField(name = "last_order")
	private Order lastOrder;

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@JsonProperty("warnning_orders")
	@JSONField(name = "warnning_orders")
	private List<Order> warnningOrders = new ArrayList<Order>();

	@JsonProperty("vehicles")
	@JSONField(name = "vehicles")
	private List<Vehicle> vehicles = new ArrayList<Vehicle>();

	@JsonProperty("divers")
	@JSONField(name = "divers")
	private List<Driver> divers = new ArrayList<Driver>();

	@JsonProperty("customers")
	@JSONField(name = "customers")
	private List<Customer> customers = new ArrayList<Customer>();

	@JsonProperty("factories")
	@JSONField(name = "factories")
	private List<Factory> factories = new ArrayList<Factory>();

	@JsonProperty("plans")
	@JSONField(name = "plans")
	private List<Plan> plans = new ArrayList<Plan>();

	@JsonProperty("users")
	@JSONField(name = "users")
	private List<WebUser> webUsers = new ArrayList<WebUser>();

	@JsonProperty("orders")
	@JSONField(name = "orders")
	private List<Order> orders = new ArrayList<Order>();

	public DatasResponse() {
		super();
	}

	public Order getLastOrder() {
		return lastOrder;
	}

	public void setLastOrder(Order lastOrder) {
		this.lastOrder = lastOrder;
	}

	public List<Order> getWarnningOrders() {
		return warnningOrders;
	}

	public void setWarnningOrders(List<Order> warnningOrders) {
		this.warnningOrders = warnningOrders;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public List<Driver> getDivers() {
		return divers;
	}

	public void setDivers(List<Driver> divers) {
		this.divers = divers;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Factory> getFactories() {
		return factories;
	}

	public void setFactories(List<Factory> factories) {
		this.factories = factories;
	}

	public List<Plan> getPlans() {
		return plans;
	}

	public void setPlans(List<Plan> plans) {
		this.plans = plans;
	}

	public List<WebUser> getWebUsers() {
		return webUsers;
	}

	public void setWebUsers(List<WebUser> webUsers) {
		this.webUsers = webUsers;
	}

	public List<T> addData(T t) {
		data.add(t);
		num = data.size();
		return data;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
