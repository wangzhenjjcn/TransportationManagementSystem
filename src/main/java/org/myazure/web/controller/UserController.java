package org.myazure.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.myazure.configuration.PrimaryConfiguration;
import org.myazure.service.MyazureDataService;
import org.myazure.service.OrderService;
import org.myazure.service.WebUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	private static final Logger LOG = LoggerFactory
			.getLogger(UserController.class);
	@Autowired
	PrimaryConfiguration primaryConfiguration;
	@Autowired
	MyazureDataService myazureDataService;
	@Autowired
	OrderService orderService;
	@Autowired
	WebUserService webUserService;
	
	public UserController(){
		
	}
	
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public void login(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		
		
		
		
		response.getWriter().write( "sucess");
		
	}
	
	
	
	

}
