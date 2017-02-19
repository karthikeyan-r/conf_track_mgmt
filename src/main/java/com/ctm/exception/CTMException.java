package com.ctm.exception;

/***
 * Custom Exception Handler class
 * 
 * @author Karthikeyan R
 *
 */
public class CTMException extends Exception {

	private static final long serialVersionUID = 1L;
	String errMsg = "";

	public CTMException(String errMsg) {
		this.errMsg = errMsg;
	}

}
