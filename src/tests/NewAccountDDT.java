package tests;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value= Parameterized.class)
public class NewAccountDDT {
	String email;
	String gender;
	String firstName;
	String lastName;
	String password;
	String address;
	String city;
	String zipcode;
	String state;
	String phone;
	String newsletter;
	String optin;
	
	// This is our test method
	@Test
	public void newAccountTest() {
		System.out.println("NEW RECORD: " + firstName + " " + lastName + " " + phone);
		if (phone.equals("2342342345")) {
			Assert.fail();
		}
	}
	
	// This annotated method is designed to pass parameters into the class via constructor
	@Parameters
	public static List<String[]> getData() {
		return utilities.CSV.get("C:\\Users\\JDAVI\\OneDrive\\Documents\\BACKUPS\\ACADEMYPGH\\PROJECTS\\Java\\SeleniumTesting\\UserAccounts.csv");
	}
	
	// Constructor that passes parameters to the test method
	public NewAccountDDT(String email, String gender, String firstName, String lastName, String password, String address, 
			String city, String zipcode, String state, String phone, String newsletter, String optin) {
		this.email = email;
		this.gender = gender;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.address = address;
		this.city = city;
		this.zipcode = zipcode;
		this.state = state;
		this.phone = phone;
		this.newsletter = newsletter;
		this.optin = optin;
		
	}
	
}
