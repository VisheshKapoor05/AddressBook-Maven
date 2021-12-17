package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import entity.Contact;

public class ContactService {

	public void addContacts(HashMap<String, ArrayList<Contact>> cityDictionary, 
							HashMap<String, ArrayList<Contact>> stateDictionary, 
							Set<Contact> contactsSet,
							ArrayList<Contact> contactsList) { // adding contacts
		
		System.out.println("Adding a contact");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the firstname: ");
		String firstName = sc.next();

		System.out.println("Enter the lastname: ");
		String lastName = sc.next();

		System.out.println("Enter the Address: ");
		String Address = sc.next();

		System.out.println("Enter the City: ");
		String City = sc.next();

		System.out.println("Enter the State: ");
		String State = sc.next();

		System.out.println("Enter the email: ");
		String email = sc.next();

		System.out.println("Enter the zip: ");
		int zip = sc.nextInt();

		System.out.println("Enter the phoneNumber: ");
		long phoneNumber = sc.nextLong();

		Contact add_contact = new Contact(firstName, lastName, Address, City, State, email, zip, phoneNumber);
		// System.out.println(add_contact);
		contactsSet.add(add_contact);
		
		dictionary(cityDictionary, add_contact, City);
		dictionary(stateDictionary, add_contact, State);
		
		System.out.println("contacts of Current Address book");
		for(Contact person : contactsSet) {
			System.out.println(person);
		}
	}

	
	public void editContact(Set<Contact> contactsSet) { // editing contacts
		System.out.println("Editing a contact");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the firstname of the contact you want to edit: ");
		String fName = sc.next();
		
		for(Contact person : contactsSet) 
		{
			if(person.getFirstName().equals(fName)) 
			{				
				System.out.println("What do you want to edit?");
				System.out.println("Enter a number to edit value: ");
				System.out.println("1: firstName, " + "2: lastName, " + "3: Address, " + "4: City, " + "5: State, "
						+ "6: email, " + "7: zip, " + "8: phoneNumber");
				int num = sc.nextInt();
				switch (num) {
				case 1:
					System.out.println("Enter the value: ");
					String fname = sc.next();
					person.setFirstName(fname);
					break;
				case 2:
					System.out.println("Enter the value: ");
					String lname = sc.next();
					person.setLastName(lname);
					break;
				case 3:
					System.out.println("Enter the value: ");
					String Address = sc.next();
					person.setAddress(Address);
					break;
				case 4:
					System.out.println("Enter the value: ");
					String City = sc.next();
					person.setCity(City);
					break;
				case 5:
					System.out.println("Enter the value: ");
					String State = sc.next();
					person.setState(State);
					break;
				case 6:
					System.out.println("Enter the value: ");
					String email = sc.next();
					person.setEmail(email);
					break;
				case 7:
					System.out.println("Enter the value: ");
					int zip = sc.nextInt();
					person.setZip(zip);
					break;
				case 8:
					System.out.println("Enter the value: ");
					int phoneNumber = sc.nextInt();
					person.setPhoneNumber(phoneNumber);
					break;
				default:
					System.out.println("Please enter a valid number");
				}
			} 
		}
		System.out.println("the selected contact edited successfully: ");
	}

	public void deleteContact(Set<Contact> contactsSet) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the firstname of the contact you want to delete: ");
		String fName = sc.next();
		
		for(Contact person : contactsSet) 
		{
			if(person.getFirstName().equals(fName)) 
			{				
				contactsSet.remove(person);
				System.out.println("the selected contact deleted successfully");
			} else {
				System.out.println("No contact matches the first name you gave");
			}
		}
	}
	
	
	public void dictionary(HashMap<String, ArrayList<Contact>> dictionary, Contact add_contact, String place) {
		if(dictionary.isEmpty()) 
		{	
			// if dictionary is empty, creating a new contactsList, adding the contact and storing it in dictionary
			ArrayList<Contact> newContactsList = new ArrayList<Contact>();
			newContactsList.add(add_contact);
			dictionary.put(place, newContactsList);
			//System.out.println("New dictionary: "+dictionary);
			//System.out.println();
		}
		else if(!dictionary.containsKey(place)) 
		{
			// if dictionary doesn't have the city key, creating a new contactsList, adding the contact and storing key & value in dictionary
			ArrayList<Contact> newContactsList = new ArrayList<Contact>();
			newContactsList.add(add_contact);
			dictionary.put(place, newContactsList);
			//System.out.println("New place in the dictionary detected: "+dictionary);
			//System.out.println();
		}
		else 
		{
			// if dictionary has the city key, adding the contact to the contactList(value) of the respective city(key)
			for(Map.Entry<String, ArrayList<Contact>> obj : dictionary.entrySet()) {
				System.out.println("City: "+place);
				if(obj.getKey().equals(place)) {
					obj.getValue().add(add_contact);
			//		System.out.println("adding contact to same place in the dictionary: "+dictionary);
			//		System.out.println();
				}
			}
		}	
	}

}