package com.codemetal.tapi.metadata;

import java.io.Serializable;

/**
 * This class represents a TestSuite which will be executed as a JUnit TestSuite
 * @author Raghuveer Bhandarkar
 *
 */
public class TestSuite implements Serializable{

	private static final long serialVersionUID = 102L;
	
	/*Name of the TestSuite*/
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
