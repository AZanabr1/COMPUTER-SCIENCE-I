/* 

 * Class: CMSC203  

 * Instructor: Ahmed Tarek

 * Description: In this program, we are plugging patient information, 
				displaying patient information, and displaying the type 
				of procedures and the prices of the procedures. The total 
				price is displayed at the end of the program.

 * Due: 09/28/2026 

 * Platform/compiler: Eclipse

 * I pledge that I have completed the programming  

 * assignment independently. I have not copied the code  

 * from a student or any source. I have not given my code  

 * to any student. 

   Print your Name here: Antonio Zanabria

*/ 

package Assigment2;

public class Patient {
	
	private String firstName, 
					middleName,
					lastName, 
					streetAdd, 
					city, 
					state, 
					phoneNumber, 
					emergencyContact,
					emergencyNumber,
					zipCode; 

	public Patient()// no-arg argument 
	{
		firstName = "";
		middleName = ""; 
		lastName = ""; 
		streetAdd = "";  
		city =""; 
		state = ""; 
		phoneNumber = "";
		emergencyContact ="";
		emergencyNumber ="";
		zipCode ="";
		 
	}
	public Patient(String firstName, String middleName, String lastName) {
		this.firstName = firstName;
		this.middleName = middleName; 
		this.lastName = lastName; 
	}
	public Patient(String firstName, String middleName, String lastName, String streetAdd, String city, String state, String zipCode, String phoneNumber, String emergencyContact, String emergencyNumber) {
		this.firstName = firstName;
		this.middleName = middleName; 
		this.lastName = lastName; 
		this.streetAdd = streetAdd; 
		this.city = city; 
		this.state = state; 
		this.zipCode = zipCode; 
		this.phoneNumber = phoneNumber; 
		this.emergencyContact = emergencyContact; 
		this.emergencyNumber = emergencyNumber; 
		}
	//mutators
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setMIddleName(String middleName) {
		this.middleName = middleName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setStreetAdd(String streetAdd) {
		this.streetAdd = streetAdd;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}
	public void setEmergencyNumber(String emergencyNumber) {
		this.emergencyNumber = emergencyNumber;
	}
	//getter
	public String getFirstName() {
		return firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getStreetAdd() {
		return streetAdd;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getEmergencyContact() {
		return emergencyContact;
	}
	public String getEmergencyNumber() {
		return emergencyNumber;
	}
	
	//methods
	public String buildFullName() {
		return firstName + "\n" + middleName + "\n" + lastName; 
	}
	public String buildAddress() {
		return streetAdd + "\n" + city + "\n" + state + "\n" + zipCode;
	}
	public String buildEmergencyContact() {
		return emergencyContact + "\n" + emergencyNumber; 
	}
	public String toString() {
		return buildFullName() + "\n" + buildAddress() + "\n" + buildEmergencyContact();
	}
}


