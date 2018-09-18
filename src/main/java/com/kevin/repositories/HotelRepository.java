package com.kevin.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
//import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.kevin.entities.Hotel;

@Repository
// Hotel arg will be the entity you want to store to the database
public interface HotelRepository extends MongoRepository<Hotel, String> {
	Optional<Hotel> findById(String id); 
	List<Hotel> findByPricePerNight(int maxPrice);
	
	
	
	@Query(value = "{'address.city':?0}")
	List<Hotel> findByCity(String city); 
	
	
//	@Query(value = "{'address.country':?0}")
//	List<Hotel> findByCountry(String country); 
//	
	
	
	
	
	
}
