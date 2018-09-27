package com.kevin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kevin.services.HotelService;
import com.kevin.services.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication	
public class HotelApiApplication implements CommandLineRunner {
	private static final Logger LOG = LoggerFactory.getLogger("AppsDeveloper");
	
//	private HotelService hotelService;
	
	@Autowired
	private UserService userService;
	
//	@Autowired
//	public HotelApiApplication(HotelService hotelService) {
//		this.hotelService = hotelService;
//	}
	
	@Autowired
	public HotelApiApplication(UserService userService) {
		super();
		this.userService = userService;
	}


	public static void main(String[] args) {
		SpringApplication.run(HotelApiApplication.class, args);
		
	}


	@Override
	public void run(String... args) throws Exception {
		
//		LOG.info("Getting all data from MongoDB: \n{}",
//				hotelService.findByReviewsUserName("Me"));
		
		LOG.info("Getting all user from mongoDB: \n{}",
				userService.findAll());
		
		LOG.info("searching one: \n{}",
				userService.findByName("Kevin Ke"));
		
		
	}
}
