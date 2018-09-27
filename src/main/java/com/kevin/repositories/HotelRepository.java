package com.kevin.repositories;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import org.springframework.stereotype.Repository;

import com.kevin.entities.Hotel;

@Repository
// Hotel arg will be the entity you want to store to the database
public interface HotelRepository extends MongoRepository<Hotel, String> {
	
	List<Hotel> findByPricePerNight(int maxPrice);
	
	@Query(value = "{'address.city':?0}")
	List<Hotel> findByCity(String city);	
	
	
	
	
}
