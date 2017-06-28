package com.codemetal.tapi.metadata;
/**
 * This enumeration represents the various types of Assertions which could be used while evaluating Test Case results
 * @author Raghuveer Bhandarkar
 *
 */
public enum AssertionType {
	/*Expressions to select values from Json objects*/
	PREDICATE, 
	
	/*HTTP Response code status*/
	RESPONSE_STATUS
}
