package com.prudhvi.xmlJson.controller;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prudhvi.xmlJson.model.Passenger;
import com.prudhvi.xmlJson.model.Ticket;

@RestController
public class ResController {
	@GetMapping(
			value ="/passenger",
			produces= {"application/xml","application/json"}
	)
	public Passenger passenger() {
		Passenger p=new Passenger();
		p.setAge(10);
		p.setName("ding dong");
		return p;
	}
	
	@PostMapping(
			value="/bookTicket",
			produces={"application/xml","application/json"},
			consumes={"application/xml","application/json"}
	)
	public Ticket bookTicket(@RequestBody Passenger passenger) {
		Ticket t=new Ticket();
		t.setPassengerName(passenger.getName());
		t.setPrice(passenger.getAge()>18?200.0:100.0);
		t.setTrainNo(12235);
		Random r =new Random();
		t.setTicketId(r.nextInt());
		return t;
	}
	
}
