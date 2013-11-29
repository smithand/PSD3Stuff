import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

public class StudentCoursesTable {
	
	private Hashtable<String, Value> table;
	
	public Hashtable<String, Value> getTable() {
		return table;
	}
	
	public void createTable(String path) {
		
		table = new Hashtable<String, Value>();
		
		WriteToCsv writer = new WriteToCsv();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String sCurrentLine;
			br.readLine();
		
			while ((sCurrentLine = br.readLine()) != null) {
				
				String courses = sCurrentLine;
				String delims = "[,]";
				String[] tokens = courses.split(delims);
				
				StudentCourses course = new StudentCourses(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4]);
			    String key = course.getCourse();
			    
			    Value val = new Value(course.getId(), course.getCw(), course.getExam(), course.getTotal());
				table.put(key, val);
				
				String content = key + "," + table.get(key) + "\n";
				writer.writeToFile(content);
				
				System.out.println(key + "," + table.get(key));
			}
		} catch (IOException e) {
			System.out.println("no information about this student");
		}
	}
}