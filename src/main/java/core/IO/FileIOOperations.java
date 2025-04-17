package core.IO;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOOperations {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("C:\\Users\\10830079\\Downloads\\java-projects\\java-programming\\src\\main\\java\\core\\IO\\Tutorials.txt");
		FileOutputStream fos = new FileOutputStream("");
		int in;
		while (( in = fis.read()) !=-1){
			System.out.println((char) in);
        }





	}

}
class Sample<Integer> {
	Integer age;
	String name;
}