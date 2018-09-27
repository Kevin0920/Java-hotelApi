package com.kevin.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.kevin.entities.UserInfo;
import com.kevin.services.UserService;



@RestController
@RequestMapping("/api")
public class UserController {
	 
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	
	@Autowired
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "/allUsers", method = RequestMethod.GET)
	public List<UserInfo> getAllUsersInfo() {
		log.info("get all user in this case");
		return userService.findAll();
		
	}
	
	@RequestMapping(value = "/newUser", method = RequestMethod.POST)
	public UserInfo createUser(@RequestBody UserInfo userInfo) {
		log.info("Create use info document");
		return userService.createUser(userInfo);
	}
	
	@RequestMapping(value = "/{name}")
	public List<UserInfo> getUserInfo(@PathVariable String name) {
		return userService.findByName(name);
	}
	
	
	
}
