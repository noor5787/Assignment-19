package in.ineuron.in;

public class MoveZeroesToEnd {

	    public static void moveZeroesToEnd(int[] arr) {
	        int count = 0; // Count of non-zero elements

	        // Traverse the array and move non-zero elements to the beginning
	        for (int i = 0; i < arr.length; i++) {
	            if (arr[i] != 0) {
	                arr[count] = arr[i];
	                count++;
	            }
	        }

	        // Fill the remaining elements with zeroes
	        while (count < arr.length) {
	            arr[count] = 0;
	            count++;
	        }
	    }

	    public static void main(String[] args) {
	        int[] arr = {1, 2, 0, 4, 3, 0, 5, 0};
	        System.out.println("Original Array: ");
	        printArray(arr);

	        moveZeroesToEnd(arr);

	        System.out.println("Modified Array: ");
	        printArray(arr);
	    }

	    public static void printArray(int[] arr) {
	        for (int i = 0; i < arr.length; i++) {
	            System.out.print(arr[i] + " ");
	        }
	        System.out.println();
	    }
	}
	

