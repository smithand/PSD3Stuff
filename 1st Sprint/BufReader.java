import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.io.FileWriter;
import java.util.Scanner;


public class BufReader {
	

	public static void main(String args[]) {
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
		} catch (IOException e) {
			System.out.println("no information about this student");
		}
	}
}
