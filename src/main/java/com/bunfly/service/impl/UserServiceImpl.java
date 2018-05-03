package com.bunfly.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bunfly.dao.IUserDao;
import com.bunfly.model.User;
import com.bunfly.service.IUserService;
@Service
public class UserServiceImpl implements IUserService {
	@Resource
	private IUserDao ud;
	
	public void saveUser(User user) {
		
		 ud.saveUser(user);
	}

}
