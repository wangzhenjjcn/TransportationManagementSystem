package org.myazure.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.myazure.domain.WebUser;

public interface WebUserService {
	WebUser checkUser(String token);

	boolean login(String username, String password, String sessionId,
			String logonIp);

	boolean logout(String serverSESSIONID, String logonIp);

	WebUser getWebUser(long id);

	List<WebUser> getWebUsers(List<Long> ids);

	void creatWebUser(WebUser webUser);

	void deleteWebUser(WebUser webUser);

	void modifyWebUser(WebUser webUser);

	WebUser searchWebUser(String key);

	List<WebUser> searchWebUsers(String key);

	WebUser checkUser(HttpServletRequest request);

}
