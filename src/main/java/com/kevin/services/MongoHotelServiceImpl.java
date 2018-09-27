package com.kevin.services;

import java.util.ArrayList;
import java.util.List;


import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.AggregationExpression;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import com.kevin.entities.Hotel;
import com.kevin.entities.Review;
import com.kevin.entities.Address;


@Repository
public class MongoHotelServiceImpl implements HotelService{
	
	private final MongoTemplate mongoTemplate;

	
	@Autowired
	public MongoHotelServiceImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	


	@Override
	public Hotel addHotel(Hotel hotel) {
		mongoTemplate.insert(hotel);
		return hotel;
	}
	

	@Override
	public List<Hotel> findAll() {
		return mongoTemplate.findAll(Hotel.class);
	}

	@Override
	public Hotel findByName(String name) {
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is(name));
		return mongoTemplate.findOne(query, Hotel.class);
	}



	@Override
	public Hotel updateHotel(Hotel hotel) {
		mongoTemplate.save(hotel);
		return hotel;
	}


	@Override
	public List<Address> findByCity(String city) {
		Query query = new Query();
		query.addCriteria(Criteria.where("city").is(city));
		
		return mongoTemplate.find(query, Address.class);
	}


	@Override
	public List<Hotel> findByPricePerNight(int maxPrice) {
		Query query = new Query();
		query.addCriteria(Criteria.where("pricePerNight").is(maxPrice));
		return mongoTemplate.find(query, Hotel.class);
	}




	@Override
	public List<Hotel> findByReviewsUserName(String userName) {
		Query query = new Query();
		query.addCriteria(Criteria.where("reviews.userName").is(userName));
		query.fields().include("_id");
		query.fields().include("name");
		query.fields().include("pricePerNight");
		query.fields().include("address");
		query.fields().include("reviews.$");
		return mongoTemplate.find(query, Hotel.class);
	}




	@Override
	public List<Review> getAverageRating(Integer rating) {
		
//		TypedAggregation<Review> aggregation = newAggregation(Review.class,
//				project("ratingCount")
//				.andExpression("rating * ratingCount").as("totalAmount"),
//				group("rating")
//				.avg("totalAmount").as("avgAmount")
//				.avg("ratingCount").as("avgRatingCount")
//		);
//				
//		AggregationResults<Review> result = mongoTemplate.aggregate(aggregation, Review.class);
//		List<Review> resultList = result.getMappedResults();
		return null;
	}
	
	


//	@Override
//	public void deleteHotel(String id) {
//		mongoTemplate.remove(id);
//	}

	

}
