package classExamples.array;

public class ArrayLibraryMain {

	public static void main(String[] args) {

		ArrayLibrary al = new ArrayLibrary();
		int[] numbers = new int[10];

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i + 1;
		}
		al.printArray(numbers, "Default initialization");
		
		

		try {
			numbers = al.insertElement(numbers, 40, 15);
			al.printArray(numbers, "After insertion on copy");
		} catch(NegativePositionException npe) {
			System.out.println("Negative Position Exception " + npe.getMessage());
		} catch(PositionTooLargeException ptle) {
			System.out.println("Position Too Large Exception " + ptle.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("This code will be executed in either case no matter what");
		}
		

		
		
		numbers = al.append(numbers, 12);
		al.printArray(numbers, "After element append");
		
		numbers = al.delete(numbers, 2);
		al.printArray(numbers, "After delete anelement");
		
		int position = al.findPositionValue(numbers, 15);
		System.out.println("The position of 15 is " + position);
		
		numbers = al.bubbleSort(numbers);
		al.printArray(numbers, "After bubble sort");

	}

}
