package com.freeuse.codes.unwrapper.graph;

import com.freeuse.codes.unwrapper.UnwrappedProperty;

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
 * 1.0      4 Jun 2018         Hein            Initial Coding
 *
 *        </pre>
 */
public class Name {

	@UnwrappedProperty("first_name")
	private String firstName;
	@UnwrappedProperty("last_name")
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
