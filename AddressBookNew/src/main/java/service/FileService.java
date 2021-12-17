package service;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Set;

//import com.google.gson.Gson;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import entity.AddressBook;
import entity.Contact;

public class FileService {

	public void fileWrite(Set<AddressBook> addressBooksSet) {
		Path path = Paths.get("D:/Bridgelabz/BridgeLabz/Assignments/AddressBookNew/src/main/resources/AddressBookFile.txt");
		byte[] byteArray = addressBooksSet.toString().getBytes();
		try {
			Files.write(path, byteArray, StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	
	public void fileRead() {
		Path path = Paths.get("D:/Bridgelabz/BridgeLabz/Assignments/AddressBookNew/src/main/resources/AddressBookFile.txt");
		try {
			List<String> list = Files.readAllLines(path);
			System.out.println(list);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void csvFileRead(Set<AddressBook> addressBooksSet) {
		try {
			CSVReader csvReader = new CSVReader(new FileReader("D:/Bridgelabz/BridgeLabz/Assignments/AddressBookNew/src/main/resources/AddressBookCSVFile.txt"));
			
			String[] row = null;
			while((row=csvReader.readNext()) != null) {
				AddressBook newAddressBook = new AddressBook(row[0]);
				Contact newContact = new Contact(row[1], row[2], row[3], row[4], row[5], row[6], Integer.parseInt(row[7]), Long.parseLong(row[8]));
				newAddressBook.contactsSet.add(newContact);
				addressBooksSet.add(newAddressBook);
			}
			
			System.out.println("printing the addressbooks stored from csvFile:");
			for(AddressBook addressBookObj : addressBooksSet) {
				System.out.println(addressBookObj);
			}
			
			csvReader.close();
		} catch (IOException | CsvValidationException e) {
			e.printStackTrace();
		}
	}
	
	/*
	public List<AddressBook> readData() {
        List<AddressBook> addressBookList = new ArrayList<>();

        try {
            Files.lines(new File("D:/Bridgelabz/BridgeLabz/Assignments/AddressBook/src/Address_Book/Files/AddressBookCSVFile.txt").toPath())
                    .map(line -> line.trim())
                    .forEach(line -> System.out.println(line));
        }catch (IOException e){
        }
        return addressBookList;
    }
	*/
	
	public void csvFileWrite(Set<AddressBook> addressBooksSet) {
		try {
			CSVWriter csvWriter = new CSVWriter(new FileWriter("D:/Bridgelabz/BridgeLabz/Assignments/AddressBookNew/src/main/resources/AddressBookCSVFile.txt", true));
			for(AddressBook obj : addressBooksSet) 
			{
				for(Contact person : obj.contactsSet) 
				{
					String[] contact = {obj.getAddressBookName(),
										person.getFirstName(),
										person.getLastName(),
										person.getAddress(),
										person.getCity(),
										person.getState(),
										person.getEmail(),
										String.valueOf(person.getZip()),
										String.valueOf(person.getPhoneNumber())};
					csvWriter.writeNext(null);
					csvWriter.writeNext(contact);
				}	
			}
			csvWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
//	public void jsonFileWrite(Set<AddressBook> addressBooksSet) {
//		Gson gson = new Gson();
//		String jsonObj = gson.toJson(addressBooksSet);
//		System.out.println(jsonObj);
//	}
}