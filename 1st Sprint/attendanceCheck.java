import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class attendanceCheck{

        public static void main(String[] args){


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
                                students[counter] = new Student(parts[0], parts[1], parts[2], "p");
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
                 *      if student is found mark that student as "a" and break out the loop
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
                File output = new File("output.csv");

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

}




