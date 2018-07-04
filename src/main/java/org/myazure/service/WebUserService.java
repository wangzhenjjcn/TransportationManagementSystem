package org.myazure.service;

import java.util.List;

import org.myazure.domain.WebUser;

public interface WebUserService {
	boolean checkUser(Long id,String token);
	String login(String username,String password);
	WebUser getWebUser(long id);
	List<WebUser> getWebUsers(List<Long> ids);
	void creatWebUser(WebUser webUser);
	void deleteWebUser(WebUser webUser);
	void modifyWebUser(WebUser webUser);
	WebUser searchWebUser(String key);
	List<WebUser> searchWebUsers(String key);
	
}
