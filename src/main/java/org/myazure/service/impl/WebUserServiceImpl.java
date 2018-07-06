package org.myazure.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.myazure.domain.WebUser;
import org.myazure.repository.WebUserRepository;
import org.myazure.service.WebUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

@Service("WebUserService")
public class WebUserServiceImpl implements WebUserService {
	@Autowired
	private WebUserRepository webUserRepository;

	@Override
	public WebUser getWebUser(long id) {
		if (id > 0) {
			return webUserRepository.findOne(id);
		}
		return null;
	}

	@Override
	public List<WebUser> getWebUsers(List<Long> ids) {
		List<WebUser> webUsers = new ArrayList<WebUser>();
		for (Long id : ids) {
			WebUser user = getWebUser(id);
			if (user != null) {
				webUsers.add(user);
			}
		}
		return webUsers;
	}

	@Override
	public void creatWebUser(WebUser webUser) {
		webUserRepository.save(webUser);
	}

	@Override
	public void deleteWebUser(WebUser webUser) {
		if (webUser == null) {
			return;
		}
		if (webUser.getId() == null) {
			return;
		}
		if (webUser.getId() < 0) {
			return;
		}
		if (webUserRepository.findOne(webUser.getId()) == null) {
			return;
		}
		webUserRepository.delete(webUser.getId());
	}

	@Override
	public void modifyWebUser(WebUser webUser) {
		if (webUser == null) {
			return;
		}
		if (webUser.getId() == null) {
			return;
		}
		if (webUser.getId() < 0) {
			return;
		}
		if (webUserRepository.findOne(webUser.getId()) == null) {
			return;
		}
		webUserRepository.save(webUser);
	}

	@Override
	public WebUser searchWebUser(String key) {
		WebUser webUser = null;
		if (key == null) {
			return webUser;
		}
		if (Long.valueOf(key) != null) {
			if (Long.valueOf(key) > 0) {
				if (webUserRepository.findOne(Long.valueOf(key)) != null) {
					webUser = webUserRepository.findOne(Long.valueOf(key));
					return webUser;
				}
			}
		}
		return webUser;
	}

	@Override
	public List<WebUser> searchWebUsers(String key) {
		return null;
	}

	@Override
	public WebUser checkUser(String token) {
		return webUserRepository.findFirstByToken(token);
	}

	@Override
	public boolean login(String username, String password, String sessionId,
			String logonIp) {
		if (username==null) {
			return false;
		}
		if (password==null) {
			return false;
		}
		if (username.isEmpty()||password.isEmpty()) {
			return false;
		}
		if (sessionId==null) {
			return false;
		}
		if (sessionId.isEmpty()) {
			return false;
		}
		WebUser user = webUserRepository.findFirstByUsernameAndPassword(
				username, password);
		if (user != null) {
			user.setToken(sessionId);
			user.setLastLoginTime(System.currentTimeMillis() + "");
			user.setLastLoginIp(logonIp);
			webUserRepository.save(user);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean logout(String serverSESSIONID, String logonIp) {
		if (serverSESSIONID==null) {
			return false;
		}
		if (serverSESSIONID.isEmpty()) {
			return false;
		}
		WebUser user = webUserRepository.findFirstByToken(serverSESSIONID);
		if (user != null) {
			user.setToken("");
			user.setLastLoginTime(System.currentTimeMillis() + "");
			user.setLastLoginIp(logonIp);
			webUserRepository.save(user);
			return true;
		} else {
			return false;
		}
	}

}
