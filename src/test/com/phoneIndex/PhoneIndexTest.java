package com.phoneIndex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PhoneIndexTest {

	private PhoneIndex phoneIndex;

	@BeforeEach
	void setup() {
		phoneIndex = new PhoneIndex();
	}

	@Test
	void addContact() {
		Contact contact = new Contact();
//		 contact.setFirstName("a");
//		 contact.setLastName("b");

//		phoneIndex.addContact(contact);

		Assertions.assertEquals(1, phoneIndex.getNumberOfContacts());
	}

	@Test
	void removeContact() {
	}
}