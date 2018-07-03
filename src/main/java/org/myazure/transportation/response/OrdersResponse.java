package org.myazure.transportation.response;

import java.util.ArrayList;
import java.util.List;

import org.myazure.domain.Order;
import org.myazure.response.StatusResponse;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OrdersResponse  extends StatusResponse {
	
	
	@JsonProperty("data")
	@JSONField(name = "data")
	private List<Order> orders=new ArrayList<Order>();
	
	@JsonProperty("num")
	@JSONField(name = "num")
	private int num=0;
	
	
	public OrdersResponse(){
		super();
	}


	public List<Order> getOrders() {
		return orders;
	}

	
	public List<Order>  addOrder(Order order) {
		orders.add(order);
		num=orders.size();
		return orders;
	}


	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}
	
	
	
	

}
