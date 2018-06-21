package org.myazure.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.myazure.configuration.PrimaryConfiguration;
import org.myazure.service.MyazureDataService;
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

	public WebController() {

	}

	@RequestMapping(path = "/hello", method = RequestMethod.POST)
	public void helloWord(HttpServletRequest request,
			HttpServletResponse response) {
		sentResponse(response, "HELLO");
	}

	protected void sentResponse(HttpServletResponse response, Object object) {
		try {
			response.getWriter().write(JSON.toJSONString(object));
			response.getWriter().close();
			return;
		} catch (IOException e) {
			LOG.debug(e.getMessage());
			e.printStackTrace();
		}
	}
}
