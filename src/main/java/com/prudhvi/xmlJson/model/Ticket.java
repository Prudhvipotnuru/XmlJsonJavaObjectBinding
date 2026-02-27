package com.prudhvi.xmlJson.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Data;

@Data
@JacksonXmlRootElement
public class Ticket {
	private Integer ticketId;
	private Integer trainNo;
	private String passengerName;
	private Double price;
}
