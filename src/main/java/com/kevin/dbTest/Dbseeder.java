package com.kevin.dbTest;

import java.util.Arrays;
import java.util.List;
import org.springframework.boot.CommandLineRunner;

import com.kevin.entities.Address;
import com.kevin.entities.Hotel;
import com.kevin.entities.Review;
import com.kevin.repositories.HotelRepository;

public class Dbseeder implements CommandLineRunner {
	
	private HotelRepository hotelRepository;
	 
	
	public Dbseeder(HotelRepository hotelRepository) {
		super();
		this.hotelRepository = hotelRepository;
	}



	@Override
	public void run(String... strings) throws Exception {
//		Hotel marriot = new Hotel(
//                "Marriot",
//                130,
//                new Address("Paris", "France"),
//                Arrays.asList(
//                        new Review("John", 8, false),
//                        new Review("Mary", 7, true)
//                )
//        );
	}
	
//	this.hotelRepository.deletAll();
//	
//	List<Hotel> hotels = Arrays.asList(marrior);
//	this.hotRepository.save(hotels);
}
