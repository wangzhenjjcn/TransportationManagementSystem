package org.myazure.web.controller;

import org.myazure.configuration.PrimaryConfiguration;
import org.myazure.service.MyazureDataService;
import org.myazure.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
	
	
	public UserController(){
		
	}
	
	
	
	
	
	

}
