package com.codemetal.tapi.assertion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.codemetal.tapi.metadata.DataType;
import com.codemetal.tapi.metadata.Operator;


/**
 * This class would Compare homogenous DataTypes against each other (expected value vs actual value depending on the data type) 
 * @author Raghuveer Bhandarkar
 *
 */
public class DataComparator {
	
	/*Expected value to be compared*/
	private String expectedValue;
	
	/*Actual value to be compared*/
	private String actualValue;
	
	/*Data Type of the value to be compared*/
	private DataType dataType;
	
	/*Operator used for comparison*/
	private Operator operator;
	
	/*Format of the data to be compared (if any)*/
	private String dataFormat;
	
	public DataComparator(String expectedValue, String actualValue, DataType dataType, Operator operator, String dataFormat){
		this.expectedValue= expectedValue;
		this.actualValue= actualValue;
		this.dataType= dataType;
		this.operator= operator;
		this.dataFormat= dataFormat;
	}
	
	/**
	 * Compares the actual the expected values based on data type and operator
	 * @return  Returns true/false based on expected value matches or not
	 */
	public boolean compare(){
		int result = compareTo();
		if(Operator.EQUALS.equals(operator)){
			return result == 0;
		}
		else if(Operator.MORETHAN.equals(operator)){
			return result > 0;
		}
		else if(Operator.MORETHANOREQ.equals(operator)){
			return result >= 0;
		}
		else if(Operator.LESSTHAN.equals(operator)){
			return result < 0;
		}
		else if(Operator.LESSTHANOREQ.equals(operator)){
			return result <= 0;
		}
		else if(Operator.CONTAINS.equals(operator)){
			return actualValue.contains(expectedValue);
		}
		return false;
	}
	
	/**
	 * Compares the actual the expected values based on data type (invokes compareTo of the base type of objects)
	 * @return
	 */
	private int compareTo(){
		if(dataType.equals(DataType.STRING) || dataType.equals(DataType.DOUBLE) || dataType.equals(DataType.NUMBER)){
			return expectedValue.compareTo(actualValue);
		}
		else if(dataType.equals(DataType.DATE)){
			 SimpleDateFormat sdf = new SimpleDateFormat(dataFormat);
			 Date expectedDate = null;
			 Date actualDate = null;
			 try {
				expectedDate = sdf.parse(expectedValue);
				
			 } catch (ParseException e) {
				 throw new RuntimeException("Invalid expected value Date: "+expectedValue);
			 }
			 try {
				 actualDate = sdf.parse(actualValue);
					
			 } catch (ParseException e) {
				 throw new RuntimeException("Invalid actual value Date: "+actualValue);
			 }
			 return actualDate.compareTo(expectedDate);
			 
		}
		
		
		throw new RuntimeException("Invalid DataType: "+dataType);
	}
	
	
}
