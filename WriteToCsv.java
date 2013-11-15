import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;


public class WriteToCsv {
	public void writeToFile(String content) throws IOException {
		
		try{
    		String data = content;
 
    		File file =new File("test.csv");
 
    		if(!file.exists()){
    			file.createNewFile();
    		}
 
    		FileWriter fileWritter = new FileWriter(file.getName(),true);
    	        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
    	        bufferWritter.write(data);
    	        bufferWritter.close();
 
    	}catch(IOException e){
    		e.printStackTrace();
    	}
		
	}
}