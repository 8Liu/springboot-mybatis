package com.liudehuang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liudehuang.dao.UserDao;
import com.liudehuang.entity.User;
import com.liudehuang.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;

	@Override
	public List<User> listUser() {
		List<User> list = userDao.listUser();
		return list;
	}

}
