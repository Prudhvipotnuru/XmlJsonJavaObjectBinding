package com.prudhvi.xmlJson.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prudhvi.xmlJson.model.Passenger;
import com.prudhvi.xmlJson.model.Ticket;

@RestController
public class ResController {
	
	private static Map<Integer,Ticket> map=new HashMap<>();
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
		t.setTrainNo(passenger.getTrainNo());
		Random r =new Random();
		t.setTicketId(r.nextInt(1000, 9999));
		map.put(t.getTicketId(), t);
		return t;
	}
	
	@GetMapping(
			value="/getTicket/{ticketId}",
			produces={"application/xml","application/json"}
	)
	public Ticket getTicket(@PathVariable Integer ticketId) {
		Ticket ticket = map.get(ticketId);
		return ticket;
	}
	
}
