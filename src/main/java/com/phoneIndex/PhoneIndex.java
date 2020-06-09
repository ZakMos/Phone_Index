package com.phoneIndex;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneIndex {
	// list/set of Contacts
	private List<Contact> contacts = new ArrayList<>();
	private String fileName;

	public PhoneIndex(String fileName) {
		this.fileName = fileName;
		load();
	}

	public void addContact(Contact contact) {
		// added and save contact to the list
		contacts.add(contact);
		save();
	}

	public void removeContact(Contact contact) {
		// remove contact from the list
		contacts.remove(contact);
		save();
	}

	public void removeContact(String fullName) {
		String firstName = fullName.split(" ")[0];
		String lastName = fullName.split(" ")[1];
		Contact contact = getContact(firstName, lastName);
		removeContact(contact);
	}

	public Contact getContact(String firstName, String lastName) {
		for(Contact contact : contacts) {
			if(contact.getFirstName().equals(firstName) &&
					contact.getLastName().equals(lastName)) {
				return contact;
			}
		}
		return null;
	}

	public void printAllContacts() {
		// print all contacts in the list here
		System.out.println("All your contacts:");
		contacts.forEach(contact -> {
			System.out.println("----------");
			System.out.println("Full Name: " + contact.getFullName() +  "\n" + "Phone Number: " + contact.getPhoneNumber() + "\n");
			System.out.println("----------");
		});
	}

	public int getNumberOfContacts() {
		return contacts.size();
	}

	private void save(){
		try {
			final FileWriter fw = new FileWriter(fileName, false);
			for(Contact contact : contacts) {
				fw.write(contact.getFirstName() + "," + contact.getLastName() + "," + contact.getPhoneNumber()+"\n");
			}
			fw.flush();
			fw.close();
		} catch (IOException e) {
			System.out.println("Writing to file "+ fileName + " failed.");
		}
	}

	private void load(){
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while((line = br.readLine())!= null) {
				String[] parts = line.split(",");
				Contact contact = new Contact();
				contact.setFirstName(parts[0]);
				contact.setLastName(parts[1]);
				contact.setPhoneNumber(parts[2]);
				contacts.add(contact);
			}
			br.close();
		} catch (Exception e) {
			System.out.println("Reading from file "+fileName + " failed");
		}
	}
}