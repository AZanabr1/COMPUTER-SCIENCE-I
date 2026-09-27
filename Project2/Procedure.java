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

public class Procedure {

	private String name, date, practitionerName; 
			Double charges; 
			
	public Procedure() {
		name = ""; 
		date = ""; 
		practitionerName = ""; 
		charges = 0.0; 
	}
	public Procedure(String name, String date) {
		this.name = name; 
		this.date = date; 
	}
	public Procedure(String name, String date, String practitionerName, double charges) {
		this.name = name; 
		this.date = date; 
		this.practitionerName = practitionerName; 
		this.charges = charges; 
	}
	
	//mutators
	public void setName (String name) {
		this.name = name; 
	}
	public void setDate(String date) {
		this.date = date; 
	}
	public void setPractitionerName(String practitionerName) {
		this.practitionerName = practitionerName;
	}
	public void setCharges(double charges) {
		this.charges = charges; 
	}
	
	//getters
	
	public String getName() {
		return name; 
	}
	public String getDate() {
		return date;
	}
	public String getPractitionerName(){ 
		return practitionerName; 
	}
	public Double getCharges() {
		return charges; 
	}
	public String toString() {
		return name + "\t" + date  + "\t" + practitionerName  + "\t" + charges;
	}
	

}
