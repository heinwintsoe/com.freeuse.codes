package com.freeuse.codes.unwrapper.graph;

import com.freeuse.codes.unwrapper.UnwrappableObjGraph;
import com.freeuse.codes.unwrapper.UnwrappedProfile;
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
public class Person {

	@UnwrappableObjGraph
	private Name name;
	@UnwrappedProperty(profiles = {
		@UnwrappedProfile(profile=ProfileType.PERSON, value="person_gender"),
		@UnwrappedProfile(profile=ProfileType.EMPLOYEE, value="employee_gender")
		})
	private String gender;
	@UnwrappableObjGraph
	private ContactInfo contactInfo;

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public ContactInfo getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}

}
