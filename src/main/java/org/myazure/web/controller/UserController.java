package org.myazure.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.myazure.domain.Customer;
import org.myazure.domain.Driver;
import org.myazure.domain.Factory;
import org.myazure.domain.Vehicle;
import org.myazure.response.StatusResponse;
import org.myazure.service.InfoDataService;
import org.myazure.transportation.response.DatasResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;

@Controller
public class UserController extends BaseController {
	private static final Logger LOG = LoggerFactory
			.getLogger(UserController.class);
	@Autowired
	InfoDataService infoDataService;

	public UserController() {

	}

	@RequestMapping(path = "/login", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		LOG.debug("ClientSESSION:" + request.getRequestedSessionId());
		LOG.debug("ServerSESSION:" + request.getSession().getId());
		StatusResponse loginStatusResponse = null;
		String username = request.getParameter("username");
		LOG.debug("User:" + username);
		String password = request.getParameter("password");
		String logonIp = request.getRemoteAddr();
		if (!webUserService.login(username, password, request.getSession()
				.getId(), logonIp)) {
			loginStatusResponse = new StatusResponse(
					"invalid username/password logon denied", 6, false);
			response.addCookie(new Cookie("4682543566466", System
					.currentTimeMillis() + ""));
		} else {
			loginStatusResponse = new StatusResponse("user:" + username
					+ " logon sucess", 0, true);
		}
		sentResponse(response, loginStatusResponse);

	}

	@RequestMapping(path = "/loogout", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void logout(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		System.out.println("aaaaaaaa");
		StatusResponse loginStatusResponse = null;
		String ServerSESSIONID = request.getSession().getId();
		System.out.println(ServerSESSIONID);
		String logonIp = request.getRemoteAddr();
		if (!webUserService.logout(ServerSESSIONID, logonIp)) {
			loginStatusResponse = new StatusResponse("denied", 6, false);
		} else {
			loginStatusResponse = new StatusResponse("logout sucess", 0, true);
		}
		sentResponse(response, loginStatusResponse);

	}

	@RequestMapping(path = "/getDrivers", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void getDrivers(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		DatasResponse<Driver> datasResponse = new DatasResponse<Driver>();
		List<Driver> drivers = new ArrayList<Driver>();
		if (!checkUser(request)) {
			sentUnauthorizedResponse(response);
			return;
		}
		String key = request.getParameter("key");
		if (key == null) {
			sentMissParamResponse(response);
			return;
		}
		if (key.equals("last")) {
			datasResponse.setCode(0);
			datasResponse.setMessage("sucess");
			datasResponse.setSuccess(true);
			drivers = infoDataService.getDriversByLast5Orders();
			for (Driver driver : drivers) {
				datasResponse.addData(driver);
			}
			datasResponse.setDivers(drivers);
			sentResponse(response, datasResponse);
			return;
		}
		datasResponse.setCode(0);
		datasResponse.setMessage("sucess");
		datasResponse.setSuccess(true);
		drivers = infoDataService.getDrivers(key);
		for (Driver driver : drivers) {
			datasResponse.addData(driver);
		}
		datasResponse.setDivers(drivers);
		sentResponse(response, datasResponse);
	}

	@RequestMapping(path = "/creatDriver", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void creaatDriver(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		if (!checkUser(request)) {
			sentUnauthorizedResponse(response);
			return;
		}
		if (checkParams(request)) {

		}
		LOG.debug(JSON.toJSONString(request.getParameterNames()));
		Driver driver = infoDataService.getDriver(request.getParameter("name"),
				request.getParameter("phone"));
		DatasResponse<Driver> data = new DatasResponse<Driver>();
		if (driver != null) {
			data.setMessage("driver already exists");
			data.setSuccess(false);
		} else {
			driver = new Driver();
			driver.setName(request.getParameter("name"));
			driver.setPhone(request.getParameter("phone"));
			driver = infoDataService.creatDriver(driver);
			data.setMessage("creat sucess");
			data.setSuccess(true);
		}
		data.addData(driver);
		data.setDivers(data.getData());
		sentResponse(response, data);
	}

	@RequestMapping(path = "/getCustomers", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void getCustomers(HttpServletRequest request,
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
		DatasResponse<Customer> datasResponse = new DatasResponse<Customer>();
		datasResponse.setCode(0);
		datasResponse.setMessage("sucess");
		datasResponse.setSuccess(true);
		List<Customer> customers = infoDataService.getCustomers(key);
		System.out.println(customers.size());
		for (Customer customer : customers) {
			datasResponse.addData(customer);
		}
		datasResponse.setCustomers(datasResponse.getData());
		sentResponse(response, datasResponse);
	}

	@RequestMapping(path = "/creatCustomer", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void creaatCustomer(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		if (!checkUser(request)) {
			sentUnauthorizedResponse(response);
			return;
		}
		if (checkParams(request)) {

		}
		LOG.debug(JSON.toJSONString(request.getParameterNames()));
		Customer customer = infoDataService.getCustomer(
				request.getParameter("name"), request.getParameter("address"));
		DatasResponse<Customer> data = new DatasResponse<Customer>();
		if (customer != null) {
			data.setMessage("driver already exists");
			data.setSuccess(false);
		} else {
			customer = new Customer();
			customer.setName(request.getParameter("name"));
			customer.setAddress(request.getParameter("address"));
			customer.setContact(request.getParameter("contact"));
			customer.setPhone(request.getParameter("phone"));
			customer = infoDataService.creatCustomer(customer);
			data.setMessage("creat sucess");
			data.setSuccess(true);
		}
		data.addData(customer);
		data.setCustomers(data.getData());
		sentResponse(response, data);
	}

	@RequestMapping(path = "/getFactories", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void getFactories(HttpServletRequest request,
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
		DatasResponse<Factory> datasResponse = new DatasResponse<Factory>();
		datasResponse.setCode(0);
		datasResponse.setMessage("sucess");
		datasResponse.setSuccess(true);
		List<Factory> factories = infoDataService.getFactories(key);
		System.out.println(factories.size());
		for (Factory factory : factories) {
			datasResponse.addData(factory);
		}
		datasResponse.setFactories(factories);
		sentResponse(response, datasResponse);
	}


}
