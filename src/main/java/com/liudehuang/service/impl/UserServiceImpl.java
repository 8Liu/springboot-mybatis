package com.liudehuang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liudehuang.dao.RedisDao;
import com.liudehuang.dao.UserDao;
import com.liudehuang.entity.User;
import com.liudehuang.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	@Autowired
	private RedisDao redisDao;
	@Override
	public List<User> listUser() {
		List<User> list = userDao.listUser();
		for(User user:list) {
			redisDao.set(String.valueOf(user.getId()), user.getUsername());
		}
		return list;
	}

}
