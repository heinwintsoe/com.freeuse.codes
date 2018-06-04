package com.freeuse.codes.unwrapper.graph;

import java.util.List;

import com.freeuse.codes.unwrapper.UnwrappableListGraph;
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
public class ContactInfo {

	@UnwrappedProperty("contact_email")
	private String email;
	@UnwrappedProperty("contact_phone")
	private String phonenumber;
	@UnwrappableListGraph
	private List<Address> addresses;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

}
