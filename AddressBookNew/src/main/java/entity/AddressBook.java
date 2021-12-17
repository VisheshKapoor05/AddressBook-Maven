package entity;

import java.util.HashSet;
import java.util.Set;

public class AddressBook {
	
	public String addressBookName;
	public Set<Contact> contactsSet;
	
	public AddressBook(String addressbookName) {
		this.addressBookName = addressbookName;
		contactsSet = new HashSet<Contact>();
	}
	
	public String getAddressBookName() {
		return addressBookName;
	}

	@Override
	public String toString() {
		return "AddressBooks [AddressBookName=" + addressBookName + ", contacts= " + contactsSet + "]";
	}
	
}
