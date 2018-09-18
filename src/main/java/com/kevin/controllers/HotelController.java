package com.kevin.controllers;

import java.util.List;
import java.util.Optional;
import com.querydsl.core.types.dsl.BooleanExpression;


import org.springframework.web.bind.annotation.*;


import com.kevin.entities.Hotel;
import com.kevin.repositories.HotelRepository;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	private HotelRepository hotelRepository;
	
	public HotelController(HotelRepository hotelRepository) {
		super();
		this.hotelRepository = hotelRepository;
	}
	
	@GetMapping("/all")
	public List<Hotel> getAllHotels() {
		List<Hotel> hotels = this.hotelRepository.findAll();
		return hotels;
	}
	
	@GetMapping("/{id}")
	public Optional<Hotel> getHotelById(@PathVariable("id") String id) {
		Optional<Hotel> hotel = this.hotelRepository.findById(id);
		
		return hotel;
	}
	
	
	@GetMapping("/price /{maxPrice}")
	public List<Hotel> getByPricePerNight(@PathVariable("maxPrice") int maxPrice) {
		List<Hotel> hotels = this.hotelRepository.findByPricePerNight(maxPrice);
		return hotels;
	}
	
	
	@GetMapping("/address/{city}")
	public List<Hotel> getByCity(@PathVariable("city") String city) {
		List<Hotel> hotels = this.hotelRepository.findByCity(city);
		
		return hotels;
	}

//	@GetMapping("/address/{country}")
//	public List<Hotel> getByCountry(@PathVariable("country") String country) {
//		List<Hotel> hotels = this.hotelRepository.findByCountry(country);
//		
//		return hotels;
//	}	
	
	@PostMapping
    public void addHotel(@RequestBody Hotel hotel){
        this.hotelRepository.save(hotel);
	}
	
	@PutMapping
    public void updateHotel(@RequestBody Hotel hotel){
        this.hotelRepository.save(hotel);
    }
	
	@DeleteMapping("/hotels/{id}")
    public void deletHotel(@PathVariable("id") String id){
        this.hotelRepository.deleteById(id);
    }
	
}
