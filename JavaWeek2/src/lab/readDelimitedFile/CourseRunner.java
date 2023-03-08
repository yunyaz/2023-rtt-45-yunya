package lab.readDelimitedFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseRunner {

	public static void main(String[] args) {

		try {
			
			String location = "/Users/yunya/TEK/slides/303/Week_2/Lab/CourseData.csv";
			File file = new File(location);
			
			Scanner input = new Scanner(file);
			ArrayList<Course> data = new ArrayList<Course>();

			while (input.hasNextLine()) {
				String Line = input.nextLine();
				String[] splitedLine = Line.split(",");
				Course cObj = new Course();
				cObj.setCode(splitedLine[0]);
				cObj.setCourseName(splitedLine[1]);
				cObj.setInstructorName(splitedLine[2]);
				data.add(cObj);
			}
			
			for (Course c : data) {
				System.out.println(c.getCode() + " | " + c.getCourseName() + "| " + c.getInstructorName());
				System.out.println("===============================");
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found! ");
			e.printStackTrace();
		}

	}

}
