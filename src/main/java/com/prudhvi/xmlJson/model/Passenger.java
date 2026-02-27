package com.prudhvi.xmlJson.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Data;

@Data
@JacksonXmlRootElement
public class Passenger {
	private String name;
	private Integer age;
}
