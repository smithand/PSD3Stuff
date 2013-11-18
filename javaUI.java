import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.util.Hashtable;



public class javaUI {

	public static void main(String[] args){
		// Creates a new scanner for input
		Scanner input = new Scanner(System.in);
		// choice will be used to determine what the user chooses
		String choice;
		
		loginTest loginTest = new loginTest();

		System.out.println("Login to the system: \nIf administrator, use username admin\nIf tutor, use username tutor\npassword: 1234\n");
                System.out.print("Please enter your username: ");
                String username = input.nextLine();
                System.out.print("Please enter your password: ");
                String password = input.nextLine();
                loginTest.userLogin(username, password);
		
		// Print out a menu to the screen.
		System.out.println("Sprint Week 1");
		System.out.println("\nChoose operation:\n1.CSV Export\n2. Attendance Monitoring\n");
		
		// take in the users input
		choice = input.next();
		
		// if the user types 1 or 2, call the methods CSVExport() or AttendanceMonitor() respectively
		if(choice.equals("1")){
			csvExportStudent();
		}
		else if(choice.equals("2")){
			attendanceCheck();
		}

		

	}

	public static void attendanceCheck(){
		/*
                * Two flags for student found and continue,
                * Instantiate 10 students
                * Counter is used to access relevant student
                * Create new file from attendanceTest.txt
                */
                boolean found = false;
                boolean cont = true;
                Student[] students = new Student[11];
                int counter = 0;
                File file = new File("attendanceTest.csv");

                try{
                        // Create a new scanner to read the file
                        Scanner input = new Scanner(file);

                        /*
                        * While there is a line to read
                        * read the line into a string called line
                        * split up the string into an array of strings by splitting with the comma
                        * assign the array elements into a new instance of student and assign "p" as default for present
                        * increase the counter by one
                        */
                        while(input.hasNextLine()) {
                                String line = input.nextLine();
                                String parts[] = line.split(",");
                                students[counter] = new Student(parts[0], parts[1], parts[2], parts[3]);
                                if(counter != 0)
                                System.out.println(students[counter].secondName + "\t" +  students[counter].firstName + "\t" + students[counter].studentNumber + "\t" + students[counter].attendance);
                                counter++;
                        }
                        // close the scanner
                        input.close();
                // print error if the file isn't found
                } catch (FileNotFoundException e) {
                        e.printStackTrace();
                }
                /*
                 *      While the continue flag is true(true by default)
                 *      create a new scanner based upon the input provided
                 *      ask the user for the student number
                 *      loop through all the students until either the student 
                 *      is found or all students have been searched
                 *      if student is found mark that student as what has been chosen by the user
                 *      
		*/

 		while(cont){
                        Scanner userInput = new Scanner(System.in);
                        System.out.println("Please enter the student number of those you wish to change attendance: ");
                        String userNum = userInput.next();
                        for(int i= 1; i < students.length; i++){
                                if(students[i].studentNumber.equals(userNum)){
                                        found = true;
                                        System.out.println("Enter new attendance(a/p/mv)");
                                        String chosenAttendance = userInput.next();
                                        switch(chosenAttendance){
                                                case "a":
                                                        students[i].attendance = "a";
                                                        break;
                                                case "p":
                                                        students[i].attendance = "p";
                                                        break;
                                                case "mv":
                                                        students[i].attendance = "mv";
                                                        break;
                                                default:
                                                        System.out.println("ERROR: Invalid input.");
                                                        cont = true;
                                                        continue;


                                        }

                                        break;
                                }
                        }
                        if(found == false)
                                System.out.println("User not found");

                        displayStudents(students);
                        System.out.println("Do you wish to change another students attendance(y/n): ");
                        String choice = userInput.next();
                        if(choice.equals("y"))
                                cont = true;
                        else if(choice.equals("n"))
                                cont = false;
                        else
                                cont = false;
                }
                // Output the students data to a text file
                writeStudentsOut(students);

	}
	public static void csvExportStudent(){
		
		BufReader bf = new BufReader();
		System.out.println("Enter student name: (type exit to quit)");
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String studentName = sc.next();
			if(studentName.equals("exit")){
				return;
			}
			bf.getTable(studentName + ".csv");
			System.out.println("Enter student name: (type exit to quit)");
			
			
		}
	}

	public void getTable(String path) {
		
		
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String sCurrentLine;
			br.readLine();
			
			File output = new File("output.csv");

			if(!output.exists())
				output.createNewFile();
			
			FileWriter fw = new FileWriter(output.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write("Course, ID Number, Coursework, Exam, Total \n");
			
			while ((sCurrentLine = br.readLine()) != null) {
				
				String courses = sCurrentLine;
				String delims = "[,]";
				String[] tokens = courses.split(delims);
				
				StudentCourses course = new StudentCourses(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4]);
			    
				
				bw.write(course.getCourse() + "," + course.getId() + ", " + course.getCw() + "," + course.getExam() + "," + course.getTotal() + "\n");

		
			}
			bw.close();
			System.out.print("CSVExport successful");
		} catch (IOException e) {
			System.out.println("no information about this student");
		}
	}
	
        /*
                Passed in parameter: Student array
                
                Loop through the amount of students in the file and print the results to screen.
        */
        public static void displayStudents(Student[] s){
                for(int i = 1; i < s.length;i++)
                        System.out.println(s[i].secondName + "\t" +  s[i].firstName + "\t" + s[i].studentNumber + "\t" + s[i].attendance);
        }

        /*
                Passed in parameter: Student array

                Create new file if the file doesn't exist
                write to file all the variables for the student.
        */
        public static void writeStudentsOut(Student[] s){

                try{
                File output = new File("attendanceTest.csv");

                if(!output.exists())
                        output.createNewFile();

                FileWriter fw = new FileWriter(output.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);

                bw.write("Surname,Forename,StudentID,attendance\n");
                for(int i = 1; i< s.length;i++)
                        bw.write(s[i].secondName + "," +  s[i].firstName + "," + s[i].studentNumber + "," + s[i].attendance + "\n");

                bw.close();
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }
        
        
        public boolean userLogin(String username, String password){
                String adminUser = "admin";
                String tutorUser = "tutor";
                String pass = "1234";
                if (username.equals(adminUser) || username.equals(tutorUser)){
                        if (password.equals(pass)){
                                System.out.print("Successful login\n");
                                return true;
                        }
                        else {System.out.print("Incorrect password\n");
                                return false;}
                }
                else{System.out.print("Incorrect username\n");
                        return false;}                                
        }
        


}
