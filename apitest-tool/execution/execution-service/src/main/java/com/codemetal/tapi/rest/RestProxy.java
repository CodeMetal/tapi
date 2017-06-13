package com.codemetal.tapi.rest;

import java.io.IOException;
/**
 * Proxy Interface for invoking HTTP end points
 * @author Raghuveer Bhandarkar
 *
 */
public interface RestProxy {
	
	public void invoke() throws IOException;
}
