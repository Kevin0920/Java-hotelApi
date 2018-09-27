package com.kevin.services;

import java.util.List;

import com.kevin.entities.Address;
import com.kevin.entities.Hotel;
import com.kevin.entities.Review;


public interface HotelService {
	
	Hotel addHotel(Hotel hotel);
	
	Hotel findByName(String name);
	
	List<Hotel> findAll();
	
	Hotel updateHotel(Hotel hotel);
	
	List<Hotel> findByPricePerNight(int maxPrice);
	
	List<Address> findByCity(String city);
	
	// get hotels by top rating
	List<Hotel> findByReviewsUserName(String userName);
	
	// get average rating
	List<Review> getAverageRating(Integer rating);
	
	
//	void deleteHotel(hotel);
	
}
