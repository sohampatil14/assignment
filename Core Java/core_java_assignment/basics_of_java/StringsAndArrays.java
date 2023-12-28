package basics_of_java;

public class StringsAndArrays {

	public static void main(String[] args) {
		
		// declaring a String
		String stringVariable;
		// initializing the string
		stringVariable = "A String Variable";
		System.out.println(stringVariable);
		
		// declaring an array
		int[] intArray;
		intArray = new int[5];

		// initializing the array
		intArray[0] = 0;
		intArray[1] = 1;
		intArray[2] = 4;
		intArray[3] = 9;
		intArray[4] = 16;
		
		// conversely
		// int[] intArray = {0, 1, 4, 9, 16};
		
		// accessing array elements using foreach loop
		for (int element : intArray) {
			System.out.print(element + " ");
		}
		
		// multi-dimensional arrays
		int[][] squareOfNumbers = { {0, 1, 2, 3, 4}, intArray }; // intArray = {0, 1, 4, 9, 16}
		
		// accessing multi-dimensional array using foreach loop
		for (int[] array : squareOfNumbers) {
			System.out.println();
			for (int element : array) {
				System.out.print(element + " ");
			}
		}
	}
}
