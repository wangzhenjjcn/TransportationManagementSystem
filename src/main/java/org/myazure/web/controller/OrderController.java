package org.myazure.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.myazure.domain.Driver;
import org.myazure.domain.Factory;
import org.myazure.domain.Order;
import org.myazure.domain.Plan;
import org.myazure.domain.Vehicle;
import org.myazure.domain.WebUser;
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
		System.err.println(System.currentTimeMillis()+"");
		
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
		}else {
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

	@RequestMapping(path = "/debug", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void debugInfo(HttpServletRequest request,
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
				// LOG.debug("一共有" + trs.size() + "行数据");
				// LOG.debug("一共有" + (hang + 1) + "行有效数据");
				// LOG.debug("日期所在行：" + (i + 1));
			}
		}
		// LOG.debug("hang:" + (hang) + "，lie:" + (lie) + ",header:" + (header)
		// + "!");
		// LOG.debug("一共" + (hang) + "行，" + (lie) + "列,表头在第" + (header + 1) +
		// "行");
		// for (int i = 0; i < lie; ++i) {
		// LOG.debug("第" + (i + 1) + "个表头是："
		// + trs.get(header).select("td").get(i).ownText());
		// }
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
