package com.kevin.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.kevin.entities.UserInfo;
import com.kevin.services.UserService;


@Repository
public class UserServiceImpl implements UserService {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	
	@Autowired
	public UserServiceImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}



	@Override
	public List<UserInfo> findAll() {
		return mongoTemplate.findAll(UserInfo.class);
	}



	@Override
	public UserInfo createUser(UserInfo userInfo) {
		mongoTemplate.insert(userInfo);
		return userInfo;
	}



	@Override
	public List<UserInfo> findByName(String name) {
		Query defineUser = new Query();
		defineUser.addCriteria(Criteria.where("name").is(name).and("visit_count").lt(1000));
		return mongoTemplate.find(defineUser, UserInfo.class);
	}

}
