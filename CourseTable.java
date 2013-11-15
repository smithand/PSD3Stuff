import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

public class CourseTable {
	
	private Hashtable<String, ValueStudent> table;
	
	public Hashtable<String, ValueStudent> getTable() {
		return table;
	}
	
	public void createTable(String path) throws IOException {
		
		table = new Hashtable<String, ValueStudent>();
		
		WriteToCsv writer = new WriteToCsv();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String sCurrentLine;
			br.readLine();
			
			while ((sCurrentLine = br.readLine()) != null) {
				
				String courses = sCurrentLine;
				String delims = "[,]";
				String[] tokens = courses.split(delims);
				
				Course student = new Course(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], tokens[5], tokens[6], tokens[7]);
				
				String key = student.getId();
				ValueStudent val = new ValueStudent(student.getAssignmentLab1(), 
						student.getAssignmentLab2(), student.getAssignmentLab3(), student.getAssignmentLab4(), student.getAssignmentLab5());
				table.put(key, val);
				
				String content = student.getFirstName() + "," + student.getSurname() + "," + key + "," + table.get(key) + "\n";
				
				writer.writeToFile(content);
				System.out.println(student.getFirstName() + "," + student.getSurname() + "," + key);
			}
		} catch (IOException e) {
			System.out.println("no information about this course");
		}
	}
}