package com.phoneIndex;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main (String [] args) throws IOException {

		PhoneIndex phoneIndex = new PhoneIndex("contacts.txt");

		try (Scanner input = new Scanner(System.in)) {
			Contact contact = new Contact();

			String firstName = getFirstName(input);
			contact.setFirstName(firstName);

			String lastName = getLastName(input);
			contact.setLastName(lastName);

			System.out.println("Enter Your Phone Number:");
			contact.setPhoneNumber(input.next());

			// ِِ---- Add contact to Index ----
			phoneIndex.addContact(contact);
			System.out.println(("Contact saved successfully. Details: " + contact));

			// ---- DELETE CONTACT ----
			phoneIndex.removeContact("new1 contact1");
			System.out.println("Contact Deleted");

			// ---- Print all contacts ----
			phoneIndex.printAllContacts();
			System.out.println(contact);

			// ---- Get contact details ----
			phoneIndex.getContact("Redi", "School");
			System.out.println("Get contact details " + phoneIndex.getContact("Redi", "School"));

			// ---- Total contacts number ----
			phoneIndex.getNumberOfContacts();
			System.out.println("Total Number of Contacts = " + phoneIndex.getNumberOfContacts());
		}
	}

	private static String getFirstName(Scanner input){
		System.out.println("Enter Your First Name: ");
		String firstName = input.nextLine();
		if(firstName.isEmpty() || firstName.length() > 15) {
			System.out.println("invalid first name");
			return getFirstName(input);
		}
		return firstName;
	}

	private static String getLastName(Scanner input){
		System.out.println("Enter Your Last Name: ");
		String lastName = input.nextLine();
		if(lastName.isEmpty() || lastName.length() > 15) {
			System.out.println("invalid last name");
			return getLastName(input);
		}
		return lastName;
	}
}
