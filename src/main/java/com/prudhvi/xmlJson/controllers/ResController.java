package com.prudhvi.xmlJson.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import org.springframework.hateoas.Link;

import com.prudhvi.xmlJson.model.Passenger;
import com.prudhvi.xmlJson.model.Ticket;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

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
			value="/bookTicket"
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
			value="/getTicket/{ticketId}"
	)
	public EntityModel<Ticket> getTicket(@PathVariable Integer ticketId) {
		Ticket ticket = map.get(ticketId);
	    Link selfLink = linkTo(methodOn(ResController.class).getTicket(ticketId)).withSelfRel();
	    Link selfsLink = linkTo(methodOn(ResController.class).getTickets()).withSelfRel();
	    return EntityModel.of(ticket, selfLink ,selfsLink);
	}
	
	@GetMapping(
			value="/getTickets",
			produces={"application/xml","application/json"}
	)
	public CollectionModel<Ticket> getTickets() {
		
	    Link selfLink = linkTo(methodOn(ResController.class).getTickets()).withSelfRel();
	    return CollectionModel.of(map.values(), selfLink );
	}
	
	@GetMapping("/getTicketFeign/{ticketId}")
	public Ticket getTicketFeign(@PathVariable Integer ticketId) {
		Ticket ticket = map.get(ticketId);
		return ticket;
	}
}
