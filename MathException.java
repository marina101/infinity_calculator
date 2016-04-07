package com.example.user.calculatorv2;

/**
 * Exception that should be created if an error is encountered during the evaluation of a mathematical expression.
 * 
 * @author Jerome Charriere
 */
 
public class MathException extends Exception {



	/**
	 * Class constructor.
	 * 
	 * @param message Mandatory message that should give information about the exception.
	 */
	public MathException(String message) { super(message); }
		
}

