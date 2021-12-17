package entity;

import java.util.Objects;

public class Contact {
	private String firstName;
	private String lastName;
	private String Address;
	private String City;
	private String State;
	private String email;
	private int zip;
	private long phoneNumber;
	
	
	public Contact(String firstName, String lastName, String address, String city, String state, String email, int zip,
					long phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.Address = address;
		this.City = city;
		this.State = state;
		this.email = email;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
	}
	
	
	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
	}


	public String getCity() {
		return City;
	}


	public void setCity(String city) {
		City = city;
	}


	public String getState() {
		return State;
	}


	public void setState(String state) {
		State = state;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getZip() {
		return zip;
	}


	public void setZip(int zip) {
		this.zip = zip;
	}


	public long getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	@Override
	public String toString() {
		return "Contacts [firstName=" + firstName + ", lastName=" + lastName + ", Address=" + Address + ", City=" + City
				+ ", State=" + State + ", email=" + email + ", zip=" + zip + ", phoneNumber=" + phoneNumber + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		return Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName);
	}
	

}
