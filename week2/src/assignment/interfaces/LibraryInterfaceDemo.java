package assignment.interfaces;

import java.util.ArrayList;
import java.util.List;

public class LibraryInterfaceDemo {

	public static void main(String[] args) {
		
		
		System.out.println("------ Test case #1 ------");
		
		KidUser kid = new KidUser();
		
		kid.setAge(10);
		kid.registerAccount();
		kid.setAge(18);
		kid.registerAccount();
		
		kid.setBookType("Kids");
		kid.requestBook();
		kid.setBookType("Fiction");
		kid.requestBook();
		
		
		System.out.println("------ Test case #2 ------");
		
		AdultUser adult = new AdultUser();
		
		adult.setAge(5);
		adult.registerAccount();
		adult.setAge(23);
		adult.registerAccount();
		
		adult.setBookType("Kids");
		adult.requestBook();
		adult.setBookType("Fiction");
		adult.requestBook();
		
		System.out.println("------ ArrayList ------");
		
		KidUser sam = new KidUser();
		sam.setAge(10);
		
		KidUser john = new KidUser();
		john.setAge(5);
		
		AdultUser david = new AdultUser();
		david.setAge(25);
		
		AdultUser steven = new AdultUser();
		steven.setAge(30);
		
		List<LibraryUser> users = new ArrayList<>();
		users.add(sam);
		users.add(david);
		users.add(john);
		users.add(steven);
		
		
		// can not use this to directly print out users
		// it will print out the memory address for the each user object in users
//		System.out.println(users);
		
		
		// need to use for loop to go through the users list
		// because need to use "users.get(i)" to access the individual "registerAccount()" method
		
//		for (int i = 0; i < users.size(); i++) {
//			users.get(i).registerAccount();
//		}
		
		// or can instantiate an object
		// then can call the method that is associated with the object to print out
		LibraryInterfaceDemo demo = new LibraryInterfaceDemo();
		demo.printList(users);
	}
	
	
	// the parameter type that passed in is "List<LibraryUser>"
	// if declare as "ArrayList<LibraryUser> users = new ArrayList<>()" on line 54, 
	// then need to pass in "ArrayList<LibraryUser>"
	public void printList(List<LibraryUser> users) {
		for (int i = 0; i < users.size(); i++) {
			users.get(i).registerAccount();
		}
	}

}
