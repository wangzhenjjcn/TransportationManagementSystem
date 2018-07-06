package org.myazure.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.myazure.domain.Driver;
import org.myazure.domain.Factory;
import org.myazure.domain.Order;
import org.myazure.domain.Plan;
import org.myazure.domain.Vehicle;
import org.myazure.domain.WebUser;
import org.myazure.transportation.response.DatasResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;

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

	@RequestMapping(path = "/creatOrder", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void creatOrder(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		if (!checkUser(request)) {
			sentUnauthorizedResponse(response);
			return;
		}
		if (checkParams(request)) {

		}
		LOG.debug(JSON.toJSONString(request.getParameterNames()));
		WebUser creatorUser = webUserService.checkUser(request);
		Order order = new Order();
		order.setCreatorUser(creatorUser);
		order.setOrderState(0);
		order.setTransportVehicle(infoDataService.getVehicle(Long.valueOf(request
				.getParameter("transport_vehicle_id"))));
		order.setDeliveryVehicle(infoDataService.getVehicle(Long.valueOf(request
				.getParameter("delivery_vehicle_id"))));
		order.setTransportVehicleDriver(infoDataService.getDrivers(Long
				.valueOf(request.getParameter("transport_driver_id"))));
		order.setDeliveryVehicleDriver(infoDataService.getDrivers(Long
				.valueOf(request.getParameter("delivery_driver_id"))));
		order.setFactory(infoDataService.getFactories(Long.valueOf(request
				.getParameter("factory_id"))));
		order.setPlan(infoDataService.getPlans(Long.valueOf(request
				.getParameter("plan_id"))));
		order.setWeight(Integer.valueOf(request.getParameter("weight")));
		order.setSize(Integer.valueOf(request.getParameter("size")));
		order.setDistence(Integer.valueOf(request.getParameter("distance")));
		order.setEntryNumber(request.getParameter("entry_number"));
		order.setCustomerNumber(request.getParameter("customer_number"));
		order.setCustomer(infoDataService.getCustomer(Long.valueOf(request.getParameter("customer_id"))));
		order.setPickupNumber(request.getParameter("pickup_number"));
		order.setTransferNumber(request.getParameter("transfer_number"));
		order.setSource(request.getParameter("source"));
		order.setDestination(request.getParameter("destination"));
		order.setPakages(Integer.valueOf(request.getParameter("packages")));
		order.setFreightType(Integer.valueOf(request.getParameter("freight_tpye")));
		order.setCarriageFee(Integer.valueOf(request
				.getParameter("carriage_fee")));
		order.setCushionFee(Integer.valueOf(request.getParameter("cushion_fee")));
		order.setContactName(request.getParameter("contact"));
		order.setContactPhone(request.getParameter("phone"));
		order.setChartered(request.getParameter("isChartered") == "true" ? true
				: false);
		order.setFeeTime(Integer.valueOf(request.getParameter("fee_time")));
		order.setRemarks(request.getParameter("remarks"));
		DatasResponse<Order> data = new DatasResponse<Order>();
		data.addData(orderService.saveOrder(order));
		data.setOrders(data.getData());
		sentResponse(response, data);
	}

	@RequestMapping(path = "/updateOrder", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void updateOrder(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		if (!checkUser(request)) {
			sentUnauthorizedResponse(response);
			return;
		}
		if (checkParams(request)) {

		}
		String key = request.getParameter("order_id");
		if (key == null || key.isEmpty()) {
			sentMissParamResponse(response);
			return;
		}
		
		LOG.debug(JSON.toJSONString(request.getParameterNames()));
		WebUser currentUser = webUserService.checkUser(request);
		Order order = orderService.getOrder(Long.valueOf(request.getParameter("order_id")));
		if (order==null) {
			sentMissParamResponse(response);
			return;
		}
		if (currentUser.getRoleId() < order.getCreatorUser().getRole()) {
			sentMissParamResponse(response);
			return;
		}
		order.setOrderState(0);
		order.setTransportVehicle(infoDataService.getVehicle(Long.valueOf(request
				.getParameter("transport_vehicle_id"))));
		order.setDeliveryVehicle(infoDataService.getVehicle(Long.valueOf(request
				.getParameter("delivery_vehicle_id"))));
		order.setTransportVehicleDriver(infoDataService.getDrivers(Long
				.valueOf(request.getParameter("transport_driver_id"))));
		order.setDeliveryVehicleDriver(infoDataService.getDrivers(Long
				.valueOf(request.getParameter("delivery_driver_id"))));
		order.setFactory(infoDataService.getFactories(Long.valueOf(request
				.getParameter("factory_id"))));
		order.setPlan(infoDataService.getPlans(Long.valueOf(request
				.getParameter("plan_id"))));
		order.setWeight(Integer.valueOf(request.getParameter("weight")));
		order.setSize(Integer.valueOf(request.getParameter("size")));
		order.setDistence(Integer.valueOf(request.getParameter("distance")));
		order.setEntryNumber(request.getParameter("entry_number"));
		order.setCustomer(infoDataService.getCustomer(Long.valueOf(request.getParameter("customer_id"))));
		order.setCustomerNumber(request.getParameter("customer_number"));
		order.setPickupNumber(request.getParameter("pickup_number"));
		order.setTransferNumber(request.getParameter("transfer_number"));
		order.setSource(request.getParameter("source"));
		order.setDestination(request.getParameter("destination"));
		order.setPakages(Integer.valueOf(request.getParameter("packages")));
		order.setFreightType(Integer.valueOf(request.getParameter("freight_tpye")));
		order.setCarriageFee(Integer.valueOf(request
				.getParameter("carriage_fee")));
		order.setCushionFee(Integer.valueOf(request.getParameter("cushion_fee")));
		order.setContactName(request.getParameter("contact"));
		order.setContactPhone(request.getParameter("phone"));
		order.setChartered(request.getParameter("isChartered") == "true" ? true
				: false);
		order.setFeeTime(Integer.valueOf(request.getParameter("fee_time")));
		order.setRemarks(request.getParameter("remarks"));
		DatasResponse<Order> data = new DatasResponse<Order>();
		data.addData(orderService.saveOrder(order));
		data.setOrders(data.getData());
		sentResponse(response, data);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(path = "/creatFactory", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void creatFactory(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		if (!checkUser(request)) {
			sentUnauthorizedResponse(response);
			return;
		}
		if (checkParams(request)) {

		}
		LOG.debug(JSON.toJSONString(request.getParameterNames()));
		Factory factory = infoDataService.getFactory(
				request.getParameter("name"), request.getParameter("address"));
		DatasResponse<Factory> data = new DatasResponse<Factory>();
		if (factory != null) {
			data.setMessage("driver already exists");
			data.setSuccess(false);
		} else {
			factory = new Factory();
			factory.setName(request.getParameter("name"));
			factory.setAddress(request.getParameter("address"));
			factory.setContact(request.getParameter("contact"));
			factory.setPhone(request.getParameter("phone"));
			factory = infoDataService.creatFactory(factory);
			data.setMessage("creat sucess");
			data.setSuccess(true);
		}
		data.addData(factory);
		data.setFactories(data.getData());
		sentResponse(response, data);
	}

	@RequestMapping(path = "/getVehicles", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void getVehicles(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		if (!checkUser(request)) {
			sentUnauthorizedResponse(response);
			return;
		}
		String key = request.getParameter("key");
		if (key == null) {
			sentMissParamResponse(response);
			return;
		}
		DatasResponse<Vehicle> datasResponse = new DatasResponse<Vehicle>();
		datasResponse.setCode(0);
		datasResponse.setMessage("sucess");
		datasResponse.setSuccess(true);
		List<Vehicle> vehicles = infoDataService.getVehicles(key);
		System.out.println(vehicles.size());
		for (Vehicle vehicle : vehicles) {
			datasResponse.addData(vehicle);
		}
		datasResponse.setVehicles(vehicles);
		sentResponse(response, datasResponse);
	}

	@RequestMapping(path = "/creatVehicle", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void creatVehicle(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		if (!checkUser(request)) {
			sentUnauthorizedResponse(response);
			return;
		}
		if (checkParams(request)) {

		}
		LOG.debug(JSON.toJSONString(request.getParameterNames()));
		Vehicle vehicle = infoDataService.getVehicle(request
				.getParameter("car_license_plate"));
		DatasResponse<Vehicle> data = new DatasResponse<Vehicle>();
		if (vehicle != null) {
			data.setMessage("driver already exists");
			data.setSuccess(false);
		} else {
			vehicle = new Vehicle();
			vehicle.setCarLicensePlate(request
					.getParameter("car_license_plate"));
			vehicle = infoDataService.creatVehicle(vehicle);
			data.setMessage("creat sucess");
			data.setSuccess(true);
		}
		data.addData(vehicle);
		data.setVehicles(data.getData());
		sentResponse(response, data);
	}

	@RequestMapping(path = "/getPlans", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void getPlans(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		if (!checkUser(request)) {
			sentUnauthorizedResponse(response);
			return;
		}
		String key = request.getParameter("key");
		if (key == null) {
			sentMissParamResponse(response);
			return;
		}
		DatasResponse<Plan> datasResponse = new DatasResponse<Plan>();
		datasResponse.setCode(0);
		datasResponse.setMessage("sucess");
		datasResponse.setSuccess(true);
		List<Plan> plans = infoDataService.getPlans(key);
		System.out.println(plans.size());
		for (Plan plan : plans) {
			datasResponse.addData(plan);
		}
		datasResponse.setPlans(plans);
		sentResponse(response, datasResponse);
	}

	@RequestMapping(path = "/creatPlan", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void creatPlan(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		if (!checkUser(request)) {
			sentUnauthorizedResponse(response);
			return;
		}
		if (checkParams(request)) {

		}
		LOG.debug(JSON.toJSONString(request.getParameterNames()));
		DatasResponse<Plan> data = new DatasResponse<Plan>();
		Plan plan = new Plan();
		plan.setFreight_tpye(Integer.valueOf(request
				.getParameter("freight_tpye")));
		plan.setPrice(Integer.valueOf(request.getParameter("price")));
		plan.setCharteredPrice(Integer.valueOf(request
				.getParameter("chartered_price")));
		plan.setWeight(Integer.valueOf(request.getParameter("weight")));
		plan.setSize(Integer.valueOf(request.getParameter("size")));
		plan.setDistance(Integer.valueOf(request.getParameter("distance")));
		plan.setCompanyName(request.getParameter("company_name"));
		plan.setSource(request.getParameter("source"));
		plan.setDestination(request.getParameter("destination"));
		plan = infoDataService.creatPlan(plan);
		data.setMessage("creat sucess");
		data.setSuccess(true);
		data.addData(plan);
		data.setPlans(data.getData());
		sentResponse(response, data);
	}

}
