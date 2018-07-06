package org.myazure.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.myazure.domain.Order;
import org.myazure.transportation.response.DatasResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OrderController extends BaseController {
	private static final Logger LOG = LoggerFactory
			.getLogger(OrderController.class);

	public OrderController() {

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(path = "/getOrder", method = RequestMethod.GET)
	public void getOrder(HttpServletRequest request,
			HttpServletResponse response) {
		String JSSESSION = request.getRequestedSessionId();
		System.err.println(JSSESSION);
		if (!checkUser(request)) {
			sentUnauthorizedResponse(response);
			return;
		}
		String key = request.getParameter("key");
		if (key == null || key.isEmpty()) {
			sentMissParamResponse(response);
			return;
		}

		DatasResponse orders = new DatasResponse();
		orders.addData(orderService.getOrder(1L));
		orders.setOrders(orders.getData());
		sentResponse(response, orders);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(path = "/getOrders", method = RequestMethod.GET)
	public void getOrders(HttpServletRequest request,
			HttpServletResponse response) {
		String JSSESSION = request.getRequestedSessionId();
		System.err.println(JSSESSION);
		if (!checkUser(request)) {
			sentUnauthorizedResponse(response);
			return;
		}
		String key = request.getParameter("key");
		if (key == null || key.isEmpty()) {
			sentMissParamResponse(response);
			return;
		}
		List<Order> orders = new ArrayList<Order>();
		DatasResponse data = new DatasResponse();
		orders = infoDataService.getOrders(key);
		for (Order order : orders) {
			data.addData(order);
		}
		sentResponse(response, data);
	}

	@RequestMapping(path = "/creatSampleOrders", method = RequestMethod.GET)
	public void creatSampleOrders(HttpServletRequest request,
			HttpServletResponse response) {
		String JSSESSION = request.getRequestedSessionId();
		System.err.println(JSSESSION);
		if (!checkUser(request)) {
			sentUnauthorizedResponse(response);
			return;
		}
		DatasResponse<Order> data = new DatasResponse<Order>();
		Order order = orderService.getNewOrder();
		for (int i = 0; i < 5; i++) {
			data.addData(order);
		}
		data.setOrders(data.getData());
		sentResponse(response, data);
	}

}
