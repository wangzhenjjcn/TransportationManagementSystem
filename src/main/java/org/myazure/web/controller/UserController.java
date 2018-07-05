package org.myazure.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.myazure.domain.Customer;
import org.myazure.domain.Driver;
import org.myazure.response.StatusResponse;
import org.myazure.service.InfoDataService;
import org.myazure.transportation.response.DatasResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController extends BaseController {

	@Autowired
	InfoDataService infoDataService;

	public UserController() {

	}

	@RequestMapping(path = "/login", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		StatusResponse loginStatusResponse = null;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String JSSESSION = request.getRequestedSessionId();
		String logonIp = request.getRemoteAddr();
		if (!webUserService.login(username, password, JSSESSION, logonIp)) {
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

	@RequestMapping(path = "/getDrivers", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void getDrivers(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		if (!checkUser(request)) {
			sentUnauthorizedResponse(response);
			return;
		}
		String key = request.getParameter("key");
		if (key==null || key .isEmpty()) {
			sentMissParamResponse(response);
			return;
		}
		DatasResponse<Driver> datasResponse = new DatasResponse<Driver>();
		datasResponse.setCode(0);
		datasResponse.setMessage("sucess");
		datasResponse.setSuccess(true);
		List<Driver> drivers=infoDataService.getDrivers(key);
		System.out.println(drivers.size());
		for (Driver driver : drivers) {
			datasResponse.addData(driver);
		}
		datasResponse.setDivers(drivers);
		sentResponse(response, datasResponse);
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
		if (key==null || key .isEmpty()) {
			sentMissParamResponse(response);
			return;
		}
		DatasResponse<Customer> datasResponse = new DatasResponse<Customer>();
		datasResponse.setCode(0);
		datasResponse.setMessage("sucess");
		datasResponse.setSuccess(true);
		List<Customer> customers=infoDataService.getCustomers(key);
		System.out.println(customers.size());
		for (Customer customer : customers) {
			datasResponse.addData(customer);
		}
		datasResponse.setCustomers(customers);
		sentResponse(response, datasResponse);
	}
	
}
