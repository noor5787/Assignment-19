package in.ineuron.in;
import java.util.Arrays;
public class MergeSortedArrays {

	    public static int[] mergeArrays(int[] arr1, int[] arr2) {
	        int n1 = arr1.length;
	        int n2 = arr2.length;
	        int[] arr3 = new int[n1 + n2];
	        int i = 0, j = 0, k = 0;

	        while (i < n1 && j < n2) {
	            if (arr1[i] <= arr2[j]) {
	                arr3[k] = arr1[i];
	                i++;
	            } else {
	                arr3[k] = arr2[j];
	                j++;
	            }
	            k++;
	        }

	        while (i < n1) {
	            arr3[k] = arr1[i];
	            i++;
	            k++;
	        }

	        while (j < n2) {
	            arr3[k] = arr2[j];
	            j++;
	            k++;
	        }

	        return arr3;
	    }

	    public static void main(String[] args) {
	        int[] arr1 = { 1, 3, 4, 5 };
	        int[] arr2 = { 2, 4, 6, 8 };
	        int[] mergedArray = mergeArrays(arr1, arr2);
	        System.out.println("Merged array: " + Arrays.toString(mergedArray));

	        int[] arr3 = { 5, 8, 9 };
	        int[] arr4 = { 4, 7, 8 };
	        int[] mergedArray2 = mergeArrays(arr3, arr4);
	        System.out.println("Merged array: " + Arrays.toString(mergedArray2));
	    }
	}

