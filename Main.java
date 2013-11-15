/*
 * Name: PSD Spike Prototype for first story 
 * Author: Team A
 * Version 1.3
 * Description: admin should be able to export all recorded information
 *  for a single student(choosing "course", then course name "example_course", then student id from a list)
 *  Also, admin should be able to export all recorded information about courses taken by student(choosing student,
 *  then student name "student"
 * 
 */
import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose information about student or course: ");
		String choice = sc.next();
		if (choice.equals("student")) {
			StudentCoursesTable sct = new StudentCoursesTable();
			System.out.println("Enter student name: ");
		
			while (sc.hasNext()) {
				String studentName = sc.next();
				sct.createTable(studentName + ".txt");
		
			}
		}
		else if(choice.equals("course")) {
			CourseTable ct = new CourseTable();
			System.out.println("Enter course name: ");
			String course = sc.next();
			ct.createTable(course + ".csv");
			String studentId = sc.next();
			System.out.println(ct.getTable().get(studentId));
		}
		else {
			System.out.println("No such choice.");
		}
	}
}