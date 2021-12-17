package demo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import service.AddressBookService;
import service.DictionaryServices;
import service.FileService;
import entity.AddressBook;
import entity.Contact;

public class AddressBookDemo {

		public static Set<AddressBook> addressBooksSet = new HashSet<AddressBook>();
		
		public static HashMap<String, ArrayList<Contact>> cityDictionary = new HashMap<String, ArrayList<Contact>>();
		public static HashMap<String, ArrayList<Contact>> stateDictionary = new HashMap<String, ArrayList<Contact>>();
		
		public static void main(String[] args) {
			
			System.out.println("Welcome to address book");
			
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Press 1 to add an address book, 10 to read the addressBooks from the file, 11 to read from csvFile, 12 to read from JSON file");
			int num = sc.nextInt();
			
			AddressBookService addressBookServiceObj = new AddressBookService();
			DictionaryServices dictionaryServiceObj = new DictionaryServices();
			FileService file = new FileService();
			
			while(num != 0) {
				
				if(num==1) 
				{
					System.out.println("Adding a new address book");
					System.out.println("Enter the name of the address book: ");
					String addressbookName = sc.next();
					 
					addressBookServiceObj.addAddressBook(addressbookName);
					addressBooksSet.add(addressBookServiceObj.newAddressBook);
					//AddressBookDemo.fileWrite(addressBooksSet);
					//file.csvFileWrite(addressBooksSet);
					file.jsonFileWrite(addressBooksSet);
				}
				else if(num==2) {
					System.out.println("Enter the city or state you want to the person to be searched in");
					String place = sc.next();
					
					dictionaryServiceObj.searchContact(place);
				}
				else if(num == 3 || num == 4) {
					if(num == 3) {
						System.out.println("Enter the city you want to view persons of");
						String city = sc.next();
						dictionaryServiceObj.viewContacts(city, num);
						
					}
					else{
						System.out.println("Enter the state you want to view persons of");
						String state = sc.next();
						dictionaryServiceObj.viewContacts(state, num);
					}
				}
				else if(num == 5 || num == 6) {
					if(num == 5) {
						System.out.println("Enter the city you want the total count of persons of");
						String city = sc.next();
						int count = dictionaryServiceObj.countContacts(city, num);
						System.out.println("Count: " +count);
					}
					if(num == 6) {
						System.out.println("Enter the state you want the total count of persons of");
						String state = sc.next();
						int count = dictionaryServiceObj.countContacts(state, num);
						System.out.println("Count: " +count);
					}
				}
				else if(num==7) {
					System.out.println("Enter the addressBook name you want to sorted contacts of");
					String addressBook = sc.next();
					System.out.println("Enter the following numbers you want to sort contacts: ");
					System.out.println("1: to sort by firstName");
					System.out.println("2: to sort by city");
					System.out.println("3: to sort by state");
					System.out.println("4: to sort by zip");
					int sortByNum = sc.nextInt();
					dictionaryServiceObj.sortContacts(addressBook, sortByNum);
				}
				else if(num==10) {
					file.fileRead();
				}
				else if(num==11) {
					file.csvFileRead(addressBooksSet);
				}
				else if(num==12) {
					//file.jsonFileRead();
				}
				else
					System.out.println("Please enter a valid number");
				
				System.out.println();
				System.out.println("Press 1 again if you want to add another address book");
				System.out.println("or Press 2 to search any person across all the addressBooks");
				System.out.println("or Press 3 to view persons by city, 4 to view by state");
				System.out.println("or Press 5 to get total count of persons by city, 6 to get count by state");
				System.out.println("or Press 7 to sort contacts of addressbook and print them");
				System.out.println("or Press 0 to display the AddressBooks and end");
				num = sc.nextInt();
				
				if(num == 0) {
					System.out.println("list of Address book:");
					for(AddressBook addressBookObj : addressBooksSet) {
						System.out.println(addressBookObj);
					}
				}
				
			}			
		}
}
