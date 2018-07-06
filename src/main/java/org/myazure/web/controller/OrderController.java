package org.myazure.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.myazure.transportation.response.DatasResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OrderController extends BaseController {

	public OrderController() {

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(path = "/getOrder", method = RequestMethod.GET)
	public void getOrder(HttpServletRequest request,
			HttpServletResponse response) {
		if (!checkUser(request)) {
			sentUnauthorizedResponse(response);
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
		if (!checkUser(request)) {
			sentUnauthorizedResponse(response);
			return;
		}
		DatasResponse orders = new DatasResponse();
		for (int i = 0; i < 16; i++) {
			orders.addData(orderService.getNewOrder());
		}
		sentResponse(response, orders);
	}

}
