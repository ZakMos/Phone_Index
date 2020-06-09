package com.phoneIndex;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main (String [] args) throws IOException {

		PhoneIndex phoneIndex = new PhoneIndex("contacts.txt");

		Scanner input = new Scanner(System.in);
		try {
			Contact contact = new Contact();

			String firstName = getFirstName(input);
			contact.setFirstName(firstName);

			String lastName = getLastName(input);
			contact.setLastName(lastName);

			System.out.println("Enter Your Phone Number:");
			contact.setPhoneNumber(input.next());

			// added contact to Index
			phoneIndex.addContact(contact);
			System.out.println(("Contact saved successfully. Details: " + contact));

			// ---- DELETE CONTACT ----
			phoneIndex.removeContact("new1 contact1");

			// Print all contacts
			phoneIndex.printAllContacts();
			System.out.println(contact);

		} finally {
			input.close();
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
