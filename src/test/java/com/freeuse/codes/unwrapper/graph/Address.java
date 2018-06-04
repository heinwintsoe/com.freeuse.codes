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
public class Address {

	@UnwrappedProperty("country")
	private String country;
	@UnwrappedProperty("city")
	private String city;
	@UnwrappedProperty("street")
	private String street;
	@UnwrappedProperty("postal_code")
	private String postalCode;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

}
