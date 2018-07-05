package org.myazure.web.controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.myazure.configuration.PrimaryConfiguration;
import org.myazure.domain.WebUser;
import org.myazure.response.StatusResponse;
import org.myazure.service.InfoDataService;
import org.myazure.service.MyazureDataService;
import org.myazure.service.OrderService;
import org.myazure.service.WebUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

@Controller
public class BaseController {
	private static final Logger LOG = LoggerFactory
			.getLogger(BaseController.class);
	@Autowired
	PrimaryConfiguration primaryConfiguration;
	@Autowired
	OrderService orderService;
	@Autowired
	WebUserService webUserService;
	@Autowired
	InfoDataService infoDataService;

	public BaseController() {

	}

	protected boolean checkUser(HttpServletRequest request) {
		WebUser user = webUserService
				.checkUser(request.getRequestedSessionId());
		if (user == null) {
			return false;
		}
		return true;
	}

	protected void sentUnauthorizedResponse(HttpServletResponse response) {
		response.addCookie(new Cookie("4682543566466", System
				.currentTimeMillis() + ""));
		sentResponse(response, new StatusResponse(
				"invalid username/password logon denied", 6, false));
	}

	protected void sentAuthorizedResponse(HttpServletResponse response) {
		response.addCookie(new Cookie("4682543566466", ""));
		sentResponse(response, new StatusResponse("logon sucess", 0, true));
	}

	protected void sentResponse(HttpServletResponse response, Object object) {
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("");
			response.getWriter().write(
					JSON.toJSONString(object,
							SerializerFeature.DisableCircularReferenceDetect,
							SerializerFeature.WriteMapNullValue));
			response.getWriter().close();
			return;
		} catch (IOException e) {
			LOG.debug(e.getMessage());
			e.printStackTrace();
		}
	}

}