import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Csv {
	public static void generateCSV(String sFileName){
		try {
			FileWriter writer = new FileWriter(sFileName);
			
			writer.append("Course");
			writer.append(',');
			writer.append("ID number");
			writer.append(',');
			writer.append("Coursework");
			writer.append(',');
			writer.append("Exam");
			writer.append(',');
			writer.append("Total");
		    writer.append('\n');
		    
		    writer.flush();
			writer.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
