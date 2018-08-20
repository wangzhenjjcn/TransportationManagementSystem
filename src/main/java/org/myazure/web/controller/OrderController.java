package org.myazure.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.myazure.domain.Customer;
import org.myazure.domain.Driver;
import org.myazure.domain.Factory;
import org.myazure.domain.Order;
import org.myazure.domain.Plan;
import org.myazure.domain.Vehicle;
import org.myazure.domain.WebUser;
import org.myazure.exception.MissingParamException;
import org.myazure.response.StatusResponse;
import org.myazure.transportation.response.DatasResponse;
import org.myazure.utils.S;
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
	@RequestMapping(path = "/getOrders", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void getOrders(HttpServletRequest request,
			HttpServletResponse response) {
		System.err.println(System.currentTimeMillis() + "");

		String JSSESSION = request.getRequestedSessionId();
		System.err.println(JSSESSION);
		if (!checkUser(request)) {
			sentUnauthorizedResponse(response);
			return;
		}
		String key = request.getParameter("key");
		List<Order> orders = new ArrayList<Order>();
		DatasResponse data = new DatasResponse();
		if (key == null || key.isEmpty()) {
			orders = infoDataService.getTodayOrders();
			for (Order order : orders) {
				data.addData(order);
			}
		} else {
			orders = infoDataService.getOrders(key);
			for (Order order : orders) {
				data.addData(order);
			}
		}
		data.setCode(0);
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

	@RequestMapping(path = "/creataOrder", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void creataOrder(HttpServletRequest request,
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
		order.setTransportVehicle(infoDataService.getVehicle(Long
				.valueOf(request.getParameter("transport_vehicle_id"))));
		order.setDeliveryVehicle(infoDataService.getVehicle(Long
				.valueOf(request.getParameter("delivery_vehicle_id"))));
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
		order.setCustomer(infoDataService.getCustomer(Long.valueOf(request
				.getParameter("customer_id"))));
		order.setPickupNumber(request.getParameter("pickup_number"));
		order.setTransferNumber(request.getParameter("transfer_number"));
		order.setSource(request.getParameter("source"));
		order.setDestination(request.getParameter("destination"));
		order.setPakages(Integer.valueOf(request.getParameter("packages")));
		order.setFreightType(Integer.valueOf(request
				.getParameter("freight_tpye")));
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
		Order order = orderService.getOrder(Long.valueOf(request
				.getParameter("order_id")));
		if (order == null) {
			sentMissParamResponse(response);
			return;
		}
		if (currentUser.getRoleId() < order.getCreatorUser().getRole()) {
			sentMissParamResponse(response);
			return;
		}
		order.setOrderState(0);
		order.setTransportVehicle(infoDataService.getVehicle(Long
				.valueOf(request.getParameter("transport_vehicle_id"))));
		order.setDeliveryVehicle(infoDataService.getVehicle(Long
				.valueOf(request.getParameter("delivery_vehicle_id"))));
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
		order.setCustomer(infoDataService.getCustomer(Long.valueOf(request
				.getParameter("customer_id"))));
		order.setCustomerNumber(request.getParameter("customer_number"));
		order.setPickupNumber(request.getParameter("pickup_number"));
		order.setTransferNumber(request.getParameter("transfer_number"));
		order.setSource(request.getParameter("source"));
		order.setDestination(request.getParameter("destination"));
		order.setPakages(Integer.valueOf(request.getParameter("packages")));
		order.setFreightType(Integer.valueOf(request
				.getParameter("freight_tpye")));
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

	@RequestMapping(path = "/importOrder", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void importOrder(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		String data = "";
		Enumeration<String> e = request.getParameterNames();
		while (e.hasMoreElements()) {
			String paramName = (String) e.nextElement();
			String value2 = request.getParameter(paramName);
			// System.err.println(paramName + "=" + value2);
			if (paramName.equals("editor1")) {
				data = value2;
			}
		}
		List<Order> orders = getOrderByTable(data);
		for (Order order : orders) {
			orderService.saveOrder(order);
		}
		sentResponse(response, new StatusResponse("sucess", 0, true));
	}

	@RequestMapping(path = "/submit", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void submit(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		StatusResponse resault = new StatusResponse("unknown", 0, true);
		Map<String, String> datas = getRequestDatas(request);
		String op = datas.get("operation");
		if (op == null) {
			resault.setMessage("operation needed!!");
		} else {
			try {
				if (op == "save" || op.equals("save")) {
					LOG.debug("NEW SAVE REQUEST:" + request.getRemoteAddr());
					resault.setMessage(saveFormData(datas));
				}
			} catch (Exception e2) {
				e2.printStackTrace();
				resault.setMessage(e2.getMessage());
			}

		}
		sentResponse(response, resault);
	}

	private String saveFormData(Map<String, String> datas)
			throws MissingParamException {
		for (String key : datas.keySet()) {
			LOG.debug(key + " is " + datas.get(key));
		}
		String dataType = datas.get("datatype");
		if (dataType == null) {
			LOG.debug("No data Type Request!!!!!!!!!");
			return "NoDataType";
		} else {
			LOG.debug("DataType:" + dataType);
		}
		switch (dataType.toLowerCase().trim().toString()) {
		case "orders":
			LOG.debug("NEW ORDER SAVE REQUEST RECIEVED");
			return saveOrders(datas);
		case "order":
			LOG.debug("NEW ORDER SAVE REQUEST RECIEVED");
			return saveOrder(datas);
		case "driver":
			return saveDriver(datas);
		case "customer":
			if (checkParam(datas, Customer.NotNullList)) {
				Customer customer = new Customer();
				infoDataService.save(customer);
			} else {
				LOG.debug("More Param Required");
				return checkParamString(datas, Order.NotNullList);
			}
			break;
		case "factory":
			if (checkParam(datas, Factory.NotNullList)) {
				Factory factory = new Factory();
				infoDataService.save(factory);
			} else {
				LOG.debug("More Param Required");
				return checkParamString(datas, Order.NotNullList);
			}
			break;
		case "vehicle":
			if (checkParam(datas, Vehicle.NotNullList)) {
				Vehicle vehicle = new Vehicle();
				infoDataService.save(vehicle);
			} else {
				LOG.debug("More Param Required");
				return checkParamString(datas, Order.NotNullList);
			}
			break;

		case "plan":
			if (checkParam(datas, Plan.NotNullList)) {
				Plan plan = new Plan();
				infoDataService.save(plan);
			} else {
				LOG.debug("More Param Required");
				return checkParamString(datas, Order.NotNullList);
			}
			break;

		default:
			break;
		}
		return "";
	}

	private String saveOrders(Map<String, String> datas) {
		List<Order> orders = new ArrayList<Order>();
		if (datas.get("orders")!=null) {
			infoDataService.save(orders);
			orders=getOrderByTable(datas.get("orders"));
			return JSON.toJSONString(orders);
		} else {
			LOG.debug("More Param Required");
			return checkParamString(datas, Order.NotNullList);
		}
	}

	private String saveDriver(Map<String, String> datas) {
		Driver driverSaved = new Driver();
		if (checkParam(datas, Driver.NotNullList)) {
			Driver driver = new Driver();
			driver.setName(datas.get("name"));
			driver.setPhone(datas.get("phone"));
			driverSaved = infoDataService.save(driver);
		} else {
			LOG.debug("More Param Required");
			return checkParamString(datas, Order.NotNullList);
		}
		return JSON.toJSONString(driverSaved);
	}

	private String saveOrder(Map<String, String> datas) {
		if (checkParam(datas, Order.NotNullList)) {
			Order order = new Order();
			order.setEntryNumber(datas.get("entry_number"));
			order.setCustomerNumber(datas.get("customer_number"));
			order.setOrderState(0);
			order.setTransportVehicle(infoDataService.getVehicle(Long
					.valueOf(datas.get("transport_vehicle_id"))));
			order.setDeliveryVehicle(infoDataService.getVehicle(Long
					.valueOf(datas.get("delivery_vehicle_id"))));
			order.setTransportVehicleDriver(infoDataService.getDrivers(Long
					.valueOf(datas.get("transport_driver_id"))));
			order.setDeliveryVehicleDriver(infoDataService.getDrivers(Long
					.valueOf(datas.get("delivery_driver_id"))));
			order.setFactory(infoDataService.getFactories(Long.valueOf(datas
					.get("factory_id"))));
			order.setPlan(infoDataService.getPlans(Long.valueOf(datas
					.get("plan_id"))));
			order.setWeight(Integer.valueOf(datas.get("weight")));
			order.setSize(Integer.valueOf(datas.get("size")));
			order.setDistence(Integer.valueOf(datas.get("distance")));
			order.setEntryNumber(datas.get("entry_number"));
			order.setCustomer(infoDataService.getCustomer(Long.valueOf(datas
					.get("customer_id"))));
			order.setCustomerNumber(datas.get("customer_number"));
			order.setPickupNumber(datas.get("pickup_number"));
			order.setTransferNumber(datas.get("transfer_number"));
			order.setSource(datas.get("source"));
			order.setDestination(datas.get("destination"));
			order.setPakages(Integer.valueOf(datas.get("packages")));
			order.setFreightType(Integer.valueOf(datas.get("freight_tpye")));
			order.setCarriageFee(Integer.valueOf(datas.get("carriage_fee")));
			order.setCushionFee(Integer.valueOf(datas.get("cushion_fee")));
			order.setContactName(datas.get("contact"));
			order.setContactPhone(datas.get("phone"));
			order.setChartered(datas.get("isChartered") == "true" ? true
					: false);
			order.setFeeTime(Integer.valueOf(datas.get("fee_time")));
			order.setRemarks(datas.get("remarks"));
			Order orderSaved = infoDataService.save(order);
			LOG.debug("ORDER SAVED!!");
			return JSON.toJSONString(orderSaved);
		} else {
			LOG.debug("More Param Required");
			return checkParamString(datas, Order.NotNullList);
		}
	}

	@SuppressWarnings("deprecation")
	public static List<Order> getOrderByTable(String tableString) {
		List<Order> resaultsList = new ArrayList<Order>();
		Document doc = Jsoup.parse(tableString);
		Elements table = doc.getElementsByTag("table");
		// LOG.debug(table.size() + "  tables");
		Elements tablebody = table.get(0).select("tbody");
		int hang = 0;
		int lie = 0;
		int header = 0;
		// LOG.debug(tablebody.size() + "  tablebody");
		Elements trs = tablebody.get(0).select("tr");
		// LOG.debug(trs.size() + "  tr");
		hang = trs.size();
		LOG.debug("一共" + (hang) + "行数据");
		for (int i = 0; i < trs.size(); ++i) {
			Element tr = trs.get(i);
			Elements tds = tr.select("td");
			if (trs.get(i).outerHtml().contains("日期")) {
				lie = tds.size();
				hang -= i + 1;
				header = i;
			}
		}
		String[][] datas = new String[hang][lie];
		for (int i = 0; i < hang; i++) {
			int datajnum = trs.get(i + header + 1).select("td").size();
			for (int j = 0; j < datajnum; j++) {
				if (trs.get(i + header + 1).select("td").get(j)
						.hasAttr("rowspan")) {
					int sameHangShu = Integer.valueOf(trs.get(i + header + 1)
							.select("td").get(j).attr("rowspan"));
					String sameString = trs.get(i + header + 1).select("td")
							.get(j).ownText();
					for (int k = 0; k < sameHangShu; k++) {
						if (trs.get(header).select("td").get(j).ownText()
								.contains("费")
								&& k > 0) {
							sameString = "0";
						}
						datas[i + k][j] = sameString;
					}

				}
			}

		}
		for (int i = 0; i < hang; i++) {
			int datajnum = trs.get(i + header + 1).select("td").size();
			for (int j = 0; j < datajnum; j++) {
				if (trs.get(i + header + 1).select("td").get(j)
						.hasAttr("rowspan")) {
					continue;
				}
				for (int k = j; k < lie; k++) {
					if (datas[i][k] == null) {
						datas[i][k] = trs.get(i + header + 1).select("td")
								.get(j).ownText();
						k = lie;
					}
				}
			}
		}

		for (int i = 0; i < hang; i++) {
			System.out.print(i + "   ");
			for (int j = 0; j < lie; j++) {
				System.out.print(datas[i][j] + "=");
			}
			System.out.println();
		}
		for (int i = 0; i < hang; i++) {
			try {
				Order order = new Order();
				order.setOrderDate(new Date((Integer.valueOf(datas[i][0]
						.split("-")[0])) % 1900, (Integer.valueOf(datas[i][0]
						.split("-")[1])), (Integer.valueOf(datas[i][0]
						.split("-")[2]))));
				order.setOrderCreatDate(new Date(System.currentTimeMillis()));
				order.setSource(datas[i][2]);
				order.setTransferNumber(datas[i][3]);
				order.setEntryNumber(datas[i][4]);
				order.setPakages(S.getInteger(datas[i][5]));
				order.setWeight(S.getInteger(datas[i][6]));
				order.setSize(S.getInteger(datas[i][7]));
				order.setDestination(datas[i][8]);
				if (datas[i][9].contains("+")) {
					String[] toadd = datas[i][9].replace("￥", "").split("+");
					int sum = 0;
					for (int j = 0; j < toadd.length; j++) {
						sum += Integer.valueOf(toadd[j]);
					}
					order.setCarriageFee(sum);
				} else {
					order.setCarriageFee(Integer.valueOf(datas[i][9].replace(
							"￥", "").replace(".00", "")));
				}
				if (datas[i][10].contains("+")) {
					String[] toadd = datas[i][10].replace("￥", "")
							.replace(".00", "").split("+");
					int sum = 0;
					for (int j = 0; j < toadd.length; j++) {
						sum += Integer.valueOf(toadd[j]);
					}
					order.setCushionFee(sum);
				} else {
					order.setCushionFee(S.getInteger(datas[i][10].replace("￥",
							"").replace(".00", "")));
				}
				order.setRemarks(datas[i][11]);
				resaultsList.add(order);
			} catch (Exception e2) {
				e2.printStackTrace();
				continue;
			}
		}
		return resaultsList;

	}

}
