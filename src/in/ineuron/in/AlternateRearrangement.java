package in.ineuron.in;

import java.util.Arrays;
public class AlternateRearrangement {
   


	    public static void rearrangeArray(int[] arr) {
	        int n = arr.length;
	        int i = -1;
	        
	        // Rearrange positive and negative numbers separately
	        for (int j = 0; j < n; j++) {
	            if (arr[j] < 0) {
	                i++;
	                swap(arr, i, j);
	            }
	        }
	        
	        // Swap positive numbers with negative numbers alternatively
	        int pos = i + 1;
	        int neg = 0;
	        
	        while (pos < n && neg < pos && arr[neg] < 0) {
	            swap(arr, neg, pos);
	            pos++;
	            neg += 2;
	        }
	    }
	    
	    public static void swap(int[] arr, int i, int j) {
	        int temp = arr[i];
	        arr[i] = arr[j];
	        arr[j] = temp;
	    }
	    
	    public static void main(String[] args) {
	        int[] arr = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
	        
	        System.out.println("Original array: " + Arrays.toString(arr));
	        
	        rearrangeArray(arr);
	        
	        System.out.println("Rearranged array: " + Arrays.toString(arr));
	    }
	}

