package org.myazure.web.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.myazure.configuration.PrimaryConfiguration;
import org.myazure.domain.Customer;
import org.myazure.domain.Factory;
import org.myazure.domain.Order;
import org.myazure.domain.Plan;
import org.myazure.domain.Vehicle;
import org.myazure.domain.WebUser;
import org.myazure.service.MyazureDataService;
import org.myazure.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;

@Controller
public class WebController {
	private static final Logger LOG = LoggerFactory
			.getLogger(WebController.class);
	@Autowired
	PrimaryConfiguration primaryConfiguration;
	@Autowired
	MyazureDataService myazureDataService;
	@Autowired
	OrderService orderService;
	

	public WebController() {

	}

	// just for test
	@RequestMapping(path = "/getOrder", method = RequestMethod.GET)
	public void helloWord(HttpServletRequest request,
			HttpServletResponse response) {
		orderService.saveOrder(Order.getOrderExp());
		sentResponse(response, Order.getOrderExp());
	}

	@RequestMapping(path = "/getOrders", method = RequestMethod.GET)
	public void helloWords(HttpServletRequest request,
			HttpServletResponse response) {
		Order [] orders=new Order[10];
		for (int i = 0; i < orders.length; i++) {
			orders[i]=Order.getOrderExp();
			orderService.saveOrder(Order.getOrderExp());
		}
		sentResponse(response, orders);
	}
	
	
	
	protected void sentResponse(HttpServletResponse response, Object object) {
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("");
			response.getWriter().write(JSON.toJSONString(object));
			response.getWriter().close();
			return;
		} catch (IOException e) {
			LOG.debug(e.getMessage());
			e.printStackTrace();
		}
	}
}
