package com.freeuse.codes.unwrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.freeuse.codes.unwrapper.graph.Address;
import com.freeuse.codes.unwrapper.graph.ContactInfo;
import com.freeuse.codes.unwrapper.graph.Name;
import com.freeuse.codes.unwrapper.graph.Person;
import com.freeuse.codes.unwrapper.graph.ProfileType;

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
public class ObjGraphUnwrapperTest {
	
	@Test
	public void testUnwrapping() throws UnwrappingFailedException {
		
		Name name = new Name();
		name.setFirstName("John");
		name.setLastName("Htet");
		
		Address address1 = new Address();
		address1.setCountry("Myanmar");
		address1.setCity("Yangon");
		
		Address address2 = new Address();
		address2.setCountry("Myanmar");
		address2.setCity("Mandalay");
		
		List<Address> addresses = new ArrayList<>();
		addresses.add(address2);
		addresses.add(address1);
		
		ContactInfo contactInfo = new ContactInfo();
		contactInfo.setEmail("johnhtet@gmail.com");
		contactInfo.setPhonenumber("+95 84863724");
		contactInfo.setAddresses(addresses);
		
		Person person = new Person();
		person.setName(name);
		person.setGender("Male");
		person.setContactInfo(contactInfo);

		// Example 1. Testing with Employee profile
		Map<String, Object> mappedValues = ObjGraphUnwrapper.of(person).setProfile(ProfileType.EMPLOYEE).unwrap();
		System.out.println("\n### Printing Employee Profile Map -");
		mappedValues.entrySet().forEach(entry -> {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		});
		
		// Example 1. Testing with Person profile
		mappedValues = ObjGraphUnwrapper.of(person).setProfile(ProfileType.PERSON).unwrap();
		System.out.println("\n### Printing Person Profile Map -");
		mappedValues.entrySet().forEach(entry -> {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		});


	}
}
