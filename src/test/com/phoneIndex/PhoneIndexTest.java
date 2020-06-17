package com.phoneIndex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PhoneIndexTest {

	private PhoneIndex phoneIndex;

	@BeforeEach
	void setup() {
		phoneIndex = new PhoneIndex("contacts.txt");
	}

	@Test
	void addContact() {
		Contact contact = new Contact();
		 contact.setFirstName("test5");
		 contact.setLastName("test5");
		 contact.setPhoneNumber("05");

		phoneIndex.addContact(contact);

		Assertions.assertEquals(5, phoneIndex.getNumberOfContacts());
	}
	@Test
	void getContact() {
		phoneIndex.getContact("new", "world");
		String[] expectedOutput = {"new", "world", "123"};
		String[] methodOutput = {"new", "world", "123"};


		Assertions.assertArrayEquals(expectedOutput, methodOutput);
	}

	@Test
	void removeContact() {
	}
}
//
//import org.junit.Before;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.Assert.assertEquals;
//
//class PhoneIndexTest {
//
//	private PhoneIndex phoneIndex;
//
//
//	@Before
//	public void setUp() {
//		phoneIndex = new PhoneIndex("contacts.txt");
//	}
////	@Test
////	void addContact() {
//		// ِِ---- Add contact to Index ----
//
////		Assertions.assertEquals("bla", str);
//
////		 contact.setFirstName("a");
////		 contact.setLastName("b");
//
//
////		Assertions.assertEquals(1, phoneIndex.getNumberOfContacts());
////	}
//	@Test
//	public void addContact() {
//		Contact result = phoneIndex.getContact("Hello", "World");
//		assertEquals(result, "Hello World");
//
//	}
//
//	@Test
//	void removeContact() {
//	}
//}