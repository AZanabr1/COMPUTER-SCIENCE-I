/* 

 * Class: CMSC203  

 * Instructor: Ahmed Tarek

 * Description: In this project we will be reading and writing into the designated file. We are using the values
 				from the file and finding the average and overall grade to give the student a letter grade.  

 * Due: 09/26/2026

 * Platform/compiler: Eclipse IDE

 * I pledge that I have completed the programming assignment independently. I have not copied the code from a student or
 * any source. I have not given my code to any student. 

 * Print your Name here: Antonio Zanabria 

*/


package GradeCalc;
import java.util.Scanner; 
import java.io.*;

public class GradeCalculator {

	public static void main(String[] args) throws java.io.IOException {
		
		
		
		File f = new File("gradeconfig.txt");
		String courseName, projects, quizzes, exams; 
		int gradedCategories, projectWeighted,quizzWeighted, examsWeighted, projectCount, quizzesCount, examCount; 
		double projectSum = 0, projectAverage, quizSum = 0, quizzAverage, examSum = 0, examAverage; 
		int i = 0, x = 0, j = 0 ; 
	    boolean useofDefault = false; 
	    
		
	    System.out.println("======================================== "); 
		System.out.println("CMSC203 Project 1 - Grade Calculator"); 
		System.out.println("======================================== "); 
		System.out.println("\n");
		System.out.println("Loading configuration from gradeconfig.txt..)");
		System.out.println("\n");
		
		if(!f.exists())
		{
			courseName = "CMSC203 Computer Science I";
			gradedCategories = 3; 
			projects = "Projects"; 
			projectWeighted = 40; 
			quizzes = "Quizzes"; 
			quizzWeighted = 30; 
			exams = "Exams"; 
			examsWeighted = 30; 
			
			System.out.println("File not found. We will be using the default configuration"); 
			useofDefault = true;
		}
		else
		{
			Scanner scan = new Scanner(f); 
			courseName = scan.next(); 
			gradedCategories = scan.nextInt();
			projects = scan.next(); 
			projectWeighted = scan.nextInt(); 
			quizzes = scan.next(); 
			quizzWeighted = scan.nextInt(); 
			exams = scan.next(); 
			examsWeighted = scan.nextInt(); 
		}
		
		File fl = new File("grades_input.txt"); 
		Scanner scan2 = new Scanner(fl); 
		
		if (!fl.exists()) 
		{
			System.out.println("grades_input.txt not found. Exiting program...");
			System.exit(0); 
		}
		
		String name = scan2.next(); 
		String lastName = scan2.next(); 
		String readCat = scan2.next(); 
		if(!readCat.equalsIgnoreCase("Projects"))
			System.out.println("Error! Category Not Found!"); 
		projectCount = scan2.nextInt();
		
		System.out.println(fl);
		System.out.println("\n");
		System.out.println("Reading student scores.."); 
		System.out.println("\n");
		
		while(i < projectCount) 
		{
			projectSum += scan2.nextDouble();
			i += 1; 
		}
		projectAverage = projectSum / projectCount; 
		
		readCat = scan2.next(); 
		if(!readCat.equalsIgnoreCase("Quizzes"))
			System.out.println("Error! Category Not Found!");
		quizzesCount = scan2.nextInt(); 
		while(j < quizzesCount)
		{
			quizSum += scan2.nextDouble(); 
			j += 1 ; 
		}
		quizzAverage = quizSum / quizzesCount; 
		
		readCat = scan2.next(); 
		if(!readCat.equalsIgnoreCase("Exams"))
			System.out.println("Error! Category Not Found!");
		examCount = scan2.nextInt(); 
		while(x < examCount)
		{
			examSum += scan2.nextDouble(); 
			x += 1; 
		}
		examAverage = examSum / examCount; 
		
		double overallProjectAverage = projectAverage * projectWeighted / 100; 
		double overallQuizzAverage = quizzAverage * quizzWeighted/100; 
		double overallExamAverage = examAverage * examsWeighted /100; 
		
		double overallAverage = overallProjectAverage + overallQuizzAverage + overallExamAverage; 
		
		String letterGrade; 
		if(overallAverage >= 90.0)
			letterGrade = "A"; 
		else if(overallAverage >= 80.0)
			letterGrade = "B"; 
		else if (overallAverage >= 70.0)
			letterGrade = "C"; 
		else if (overallAverage >= 60.0)
			letterGrade = "D"; 
		else 
			letterGrade = "F"; 
		
		Scanner scan3 = new Scanner(System.in); 
		String userInput = ""; 
		boolean validInput = false; 
		
		while (!validInput) 
		{
			System.out.print("Apply +/- grading? (Y/N): "); 
			userInput = scan3.nextLine(); 
			if(userInput.equalsIgnoreCase("Y") || userInput.equalsIgnoreCase("N")) {
				validInput = true; 
			}
			else
			{
				System.out.println("Input Invalid. Please enter Y or N. "); 
			}
		}
	    
		if(userInput.equalsIgnoreCase("Y"))
		{
			if(letterGrade.equalsIgnoreCase("A")) {
				if(overallAverage >= 97.0) {
					letterGrade = "A+";
				}
				else if (overallAverage >= 93.0) {
					letterGrade = "A"; 
				}
				else {
					letterGrade = "A-";
				}
			}
			if(letterGrade.equalsIgnoreCase("B")) {
				if(overallAverage >= 87.0) {
					letterGrade = "B+"; 
				}
				else if(overallAverage >= 83.0) {
					letterGrade = "B"; 
				}
				else {
					letterGrade = "B-"; 
				}
			}
			if(letterGrade.equalsIgnoreCase("C")) {
				if(overallAverage >= 78.0) {
					letterGrade = "C+";
				}
				else if(overallAverage >= 73.0) {
					letterGrade = "C";
				}
				else {
					letterGrade = "C-";
				}
			}		
			if(letterGrade.equalsIgnoreCase("D")) {
				if(overallAverage >= 68.0) {
					letterGrade = "D+";
				}
				else if(overallAverage >= 63.0) {
					letterGrade = "D";
				}
				else {
					letterGrade = "D-";
				}
			}
		}
		System.out.println("\n");
		System.out.println("Course: " + courseName);
		System.out.println("Student Name: " + name + " " + lastName);
		System.out.println("\n");
		System.out.println("Category Results: ");
		System.out.println("Project (" + projectWeighted + "%): "+ "average = " + projectAverage); 
		System.out.println("Quizzes (" + quizzWeighted + "%): "+ "average = " + quizzAverage); 			
		System.out.println("Exams (" + examsWeighted + "%): "+ "average = " + examAverage); 
		System.out.println("\n");
		System.out.println("Overall Numeric Average: " + overallAverage);
		System.out.println("Final Letter Grade: " + letterGrade);
		if(useofDefault)
			System.out.println("Default Configuration(Y/N): Y" );
		else
			System.out.println("Default Configuration(Y/N): N"); 
			
		PrintWriter pw = new PrintWriter("grades_report.txt"); 
		pw.println("Course: " + courseName);
		pw.println("Student Name: " +  name + " " + lastName);
		pw.println("Project Average and Weight: " + projectAverage + " " + projectWeighted); 
		pw.println("Quizzes Average and Weight: " + quizzAverage + " " +quizzWeighted); 
		pw.println("Exams Average and Weight: " + examAverage + " " + examsWeighted);
		pw.println("Overall Average: " + overallAverage);
		pw.println("Final Letter Grade: " + letterGrade);
		if(useofDefault)
			pw.println("Default Configuration(Y/N): Y" );
		else
			pw.println("Default Configuration(Y/N): N");
		
		
		System.out.println("\n");
		System.out.println("Summary written to grades_report.txt");
		System.out.println("Program complete. Goodbye!"); 
			
		pw.close(); 
		scan2.close(); 
		scan3.close(); 
		
		
		System.exit(0);

		

	}
}
