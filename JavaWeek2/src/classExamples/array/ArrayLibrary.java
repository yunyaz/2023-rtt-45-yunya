package classExamples.array;

import java.util.Arrays;

public class ArrayLibrary {
	
	public void printArray(int[] arr, String message) {
		System.out.println(message + "\t= "+ Arrays.toString(arr));
	}
	
	public int[] append(int[] arr, int value) {
		int[] arrNew = new int[arr.length + 1];
		for (int i = 0; i < arr.length; i++) {
			arrNew[i] = arr[i];
		}
		
		arrNew[arrNew.length - 1] = value;
		return arrNew;
	}
	
	public int[] delete(int[] arr, int position) {
		for (int i = position; i < arr.length - 1; i++) {
			arr[i] = arr[i + 1]; 
		}
		int[] arrNew =  new int[arr.length - 1];
		for (int i = 0; i < arrNew.length; i++) {
			arrNew[i] = arr[i];
		}
		return arrNew;
	}

	public int[] insertElement(int[] arr, int position, int value) throws NegativePositionException, PositionTooLargeException {
		if (position < 0) {
			throw new NegativePositionException("Position must be greater than 0");
		}
		
		if (position >= arr.length) {
			throw new PositionTooLargeException("Position must be less than " + arr.length);
		}
		
		
		int[] arrNew = new int[arr.length + 1];
		for (int i = 0; i < arr.length; i++) {
			arrNew[i] = arr[i];
		}
		
		// printArray(arrNew, "Copy initialized");
		
		for (int i = position; i < arr.length; i++) {
			arrNew[i + 1] = arr[i]; 
		}
		
		// printArray(arrNew, "Copy shift right");
		
		arrNew[position] = value;
		
		// printArray(arrNew, "After insertion on copy");
		
		return arrNew;
	}
	
	public int findPositionValue(int[] arr, int value) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == value) {
				return i;
			}
		}
		return -1;
	}
	
	public int[] bubbleSort(int[] arr) {
		
		for (int outer = 0; outer < arr.length - 1; outer++) {
			for (int inner = outer + 1; inner < arr.length; inner++) {
				if (arr[outer] < arr[inner]) {
					int temp = arr[outer];
					arr[outer] = arr[inner];
					arr[inner] = temp;
				}
			}
		}
		return arr;
	}
	
	
	
	
	

}
