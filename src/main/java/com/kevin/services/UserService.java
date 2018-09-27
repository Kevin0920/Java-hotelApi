package com.kevin.services;

import java.util.List;

import com.kevin.entities.UserInfo;

public interface UserService {

	List<UserInfo> findAll();

	UserInfo createUser(UserInfo userInfo);

	List<UserInfo> findByName(String name);

}
