package classExamples.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileExample {

	public static void main(String[] args) {

		File file = new File("src/classExamples/file");

		System.out.println(file.getAbsolutePath());

		if (file.isDirectory()) {
			System.out.println(file.getName() + " is a directory");
			System.out.println(file.getParent() + " is the parent directory");

			for (File f : file.listFiles()) {
				System.out.println(f.getName());
			}
		}

		
		
		File code = new File("./src/classExamples/file/Example.java"); // or "./src/classExamples/file/Example.java"
		System.out.println("The file exists = " + code.exists());
		try {
			if (code.createNewFile()) {
				System.out.println("New File created!");
			} else {
				System.out.println("The file already exists.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("===============");

		System.out.println("File Name: " + code.getName());
		System.out.println("File Path: " + code.getPath());
		System.out.println("Is path absolute: " + code.isAbsolute());
		System.out.println("Return Absolute path of the File " + code.getAbsolutePath());
		System.out.println("Return Parent folder of the given File " + code.getParent());
		System.out.println("File is Exist " + code.exists());
		System.out.println(code.exists() ? "Yes file exists" : "file does not exist");

		if (code.exists()) { // return true or False
			System.out.println("File is Found");
			System.out.println("IS file Readable " + code.canRead());
			System.out.println("IS file Writeable " + code.canWrite());
			System.out.println("File size in a bytes " + code.length()); // file size in byte
		}
		
		System.out.println("===============");
		
		File f = new File("./src/classExamples/file/FileExample.java");
		System.out.println("The file exists = " + f.exists());
		
		System.out.println("===============");
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line = br.readLine();
			while(line != null) {
				System.out.println(line);
				line = br.readLine();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
