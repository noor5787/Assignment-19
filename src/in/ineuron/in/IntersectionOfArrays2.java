package in.ineuron.in;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfArrays2 {
	

	    public static int[] intersect(int[] nums1, int[] nums2) {
	        // Create a map to store the frequency of numbers in nums1
	        Map<Integer, Integer> frequencyMap = new HashMap<>();

	        // Count the frequency of each number in nums1
	        for (int num : nums1) {
	            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
	        }

	        // Create a list to store the intersection elements
	        List<Integer> intersection = new ArrayList<>();

	        // Iterate over nums2 and find the common elements
	        for (int num : nums2) {
	            if (frequencyMap.containsKey(num) && frequencyMap.get(num) > 0) {
	                intersection.add(num);
	                frequencyMap.put(num, frequencyMap.get(num) - 1);
	            }
	        }

	        // Convert the list to an array
	        int[] result = new int[intersection.size()];
	        for (int i = 0; i < intersection.size(); i++) {
	            result[i] = intersection.get(i);
	        }

	        return result;
	    }

	    public static void main(String[] args) {
	        int[] nums1 = {1, 2, 2, 1};
	        int[] nums2 = {2, 2};

	        int[] intersection = intersect(nums1, nums2);

	        System.out.print("Intersection: [");
	        for (int i = 0; i < intersection.length; i++) {
	            if (i > 0) {
	                System.out.print(", ");
	            }
	            System.out.print(intersection[i]);
	        }
	        System.out.println("]");
	    }
	}

