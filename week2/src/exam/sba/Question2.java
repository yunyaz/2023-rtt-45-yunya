package exam.sba;

public class Question2 {
	
	// position : 0 1 2 3 4 5
	// values   : a b c d e f
	
	private static final int ARRAY_SIZE = 5;
	
	private int[] arr;
	
	public static void main(String[] args) {
		
		Question2 q2 = new Question2();
	
		int[] avg = { 1, 2, 3, 4, 5, 6, 7};
		
		q2.calculateAverage(avg);
		
		q2.setValue(4);
		q2.setValue(5);
		
		q2.setValue(4);
		
		q2.move(50, 3);
		
		q2.move(30, 3);
		
		q2.move(30, 4);
	}
	
	Question2() {
		
		arr = new int[ARRAY_SIZE + 1];
		for (int i = 0; i < ARRAY_SIZE + 1; i++) {
			arr[i] = -1;
		}
		
	}
	
	public void calculateAverage(int[] arr) {
		double sum = 0;
		for (int num : arr) {
			sum += num;
		}
		double avg = sum / ARRAY_SIZE;
		
		System.out.format("The average is %.2f\n", avg);
		
	}
	
	public void setValue(int index) {
//		for (int num : arr) {
//			System.out.println(num);
//		}
		
		if (arr[index] == -1) {
			System.out.println("Set the value at position " + index + " to 1");
			arr[index] = 1;
		} else {
			System.out.println("The value was already changed");
		}
	}
	
	public void move(int value, int id) {
		if (arr[id] == -1) {
			System.out.println("Value with id : " + id + " is moved to " + value + " and set the value to -1");
			arr[id] = 1;
		} else {
			System.out.println("Value is already 1");
		}
	}

}
