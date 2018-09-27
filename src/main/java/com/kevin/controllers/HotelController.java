package com.kevin.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.kevin.entities.*;
import com.kevin.services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	private HotelService hotelService;
	
	@Autowired	
	public HotelController(HotelService hotelService) {
			this.hotelService = hotelService;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Hotel> getAllHotels() {
		return hotelService.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Hotel addHotel(@RequestBody Hotel hotel){
		return hotelService.addHotel(hotel);
	}
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public Hotel getHotel(@PathVariable String name) {
        return hotelService.findByName(name);
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	Hotel updateHotel(@PathVariable String id, @RequestBody Hotel hotel){
		hotel.setId(id);
		return hotelService.updateHotel(hotel);
	}
	
	
	@RequestMapping(value = "/price/{maxPrice}", method = RequestMethod.GET)
	List<Hotel> getByPricePerNight(@PathVariable int maxPrice) {
		return hotelService.findByPricePerNight(maxPrice);
	}
	
	
	
	@RequestMapping(value = "/address/{city}", method = RequestMethod.GET)
	List<Address> getByCity(@PathVariable String city) {
		return hotelService.findByCity(city);
	}

	
//	@DeleteMapping(value = "/hotels/{id}")
//    public String deleteHotel(@PathVariable("id") String id){
//		Hotel hotel = hotelService.findByName(id);
//		hotelService.deleteHotel(hotel);
//        return "Hotel Deleted";
//    }
	
}
