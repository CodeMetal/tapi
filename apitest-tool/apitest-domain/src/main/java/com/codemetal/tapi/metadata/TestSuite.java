package com.codemetal.tapi.metadata;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

/**
 * This class represents a TestSuite which will be executed as a JUnit TestSuite
 * @author Raghuveer Bhandarkar
 *
 */
public class TestSuite implements Serializable{

	private static final long serialVersionUID = 102L;
	
	/*Mongodb id for the TestSuite*/
	@Id
    public String id;
	
	/*Name of the TestSuite*/
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
