package com.phoneIndex;

import java.util.Objects;

public class Contact {

	//Assign firstName + Last Name + list/ set of phone numbers
	private String firstName;
	private String lastName;
	private String phoneNumber;

	// Generate Getter and Setters
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhoneNumber() { return phoneNumber;	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

	public String getFullName() {
		return  getFirstName() + " " + getLastName();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Contact contact = (Contact) o;
		return phoneNumber == contact.phoneNumber &&
				Objects.equals(firstName, contact.firstName) &&
				Objects.equals(lastName, contact.lastName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, phoneNumber);
	}

	@Override
	public String toString() {
		return "Contact{" +
				"firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", phoneNumber=" + phoneNumber +
				'}';
	}

}
