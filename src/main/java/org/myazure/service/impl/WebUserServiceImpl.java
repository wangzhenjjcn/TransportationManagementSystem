package org.myazure.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.myazure.domain.WebUser;
import org.myazure.repository.WebUserRepository;
import org.myazure.service.WebUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public boolean checkUser(Long id, String token) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
