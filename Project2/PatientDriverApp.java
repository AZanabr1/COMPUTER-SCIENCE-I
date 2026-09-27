/* 

 * Class: CMSC203  

 * Instructor: Ahmed Tarek

 * Description:  In this program, we are plugging patient information, 
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
import java.util.Scanner; 

public class PatientDriverApp {

	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in); 
		System.out.print("Enter First Name: "); 
		String firstName = scan.nextLine(); 
		System.out.print("Enter Middle Name: "); 
		String middleName = scan.nextLine(); 
		System.out.print("Enter Last Name: "); 
		String lastName = scan.nextLine(); 
		System.out.print("Enter Street Address: "); 
		String streetAdd = scan.nextLine(); 
		System.out.print("Enter City: "); 
		String city = scan.nextLine(); 
		System.out.print("Enter State: "); 
		String state = scan.nextLine(); 
		System.out.print("Enter zipcode : "); 
		String zipCode = scan.nextLine(); 
		System.out.print("Enter Phone Number: "); 
		String phoneNumber = scan.nextLine(); 
		System.out.print("Enter Emergency Contact: "); 
		String emergencyContact = scan.nextLine(); 
		System.out.print("Enter Emergency Number: "); 
		String emergencyNumber = scan.nextLine(); 
		Patient myPatient = new Patient(firstName, middleName, lastName, streetAdd, city, state, zipCode, phoneNumber, emergencyContact, emergencyNumber);
		
		
		
		Procedure procedure1 = new Procedure();
		procedure1.setName("Annual Checkup");
		procedure1.setDate("09/25/2026");
		procedure1.setPractitionerName("Dr.Alvarez");
		procedure1.setCharges(150.00); 
		Procedure procedure2 = new Procedure("Blood Work", "10/02/2026");
		procedure2.setPractitionerName("Dr.Johnson");
		procedure2.setCharges(275.50);
		Procedure procedure3 = new Procedure("X-Ray", "10/02/2026", "Dr.Johnson", 100.00);
		
		System.out.println("\n");
		
		displayPatient(myPatient); 
		System.out.println("\n");
		displayProcedure(procedure1);
		displayProcedure(procedure2);
		displayProcedure(procedure3);
		double totalAmount = calculateTotalCharges(procedure1, procedure2, procedure3);
		System.out.println("\n");
		System.out.printf("Total: %,.2f" ,totalAmount); 
		System.out.println("\n");
		System.out.println("Developed by Antonio Zanabria"); 

	}
	
	public static void displayPatient(Patient p){
		System.out.println(p.toString()); 
	}
	public static void displayProcedure(Procedure pr) {
		System.out.println(pr.toString());
	}
	public static double calculateTotalCharges(Procedure p1 ,Procedure p2 ,Procedure p3) {
		
		double charge1 = p1.getCharges(); 
		double charge2 = p2.getCharges(); 
		double charges3 = p3.getCharges(); 
		double total = charge1 + charge2 + charges3; 
		
		return total; 
	}

}
