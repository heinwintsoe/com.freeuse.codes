package com.freeuse.codes.unwrapper;

/**
 * 
 *
 * @author Hein
 * @since 1.0
 * 
 *        <pre>
 * Revision History:
 * Version  Date            Author          Changes
 * ------------------------------------------------------------------------------------------------------------------------
 * 1.0      1 Jun 2018         Hein            Initial Coding
 *
 *        </pre>
 */
public class UnwrappingFailedException extends Exception {

	public UnwrappingFailedException() {
		super();
	}

	public UnwrappingFailedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UnwrappingFailedException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnwrappingFailedException(String message) {
		super(message);
	}

	public UnwrappingFailedException(Throwable cause) {
		super(cause);
	}

}
