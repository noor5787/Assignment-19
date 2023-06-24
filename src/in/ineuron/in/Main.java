package in.ineuron.in;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private int[] count;

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        count = new int[nums.length];
        int[] indexes = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            indexes[i] = i;
        }

        mergeSort(nums, indexes, 0, nums.length - 1);

        for (int num : count) {
            result.add(num);
        }

        return result;
    }

    private void mergeSort(int[] nums, int[] indexes, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;

        mergeSort(nums, indexes, start, mid);
        mergeSort(nums, indexes, mid + 1, end);

        merge(nums, indexes, start, mid, end);
    }

    private void merge(int[] nums, int[] indexes, int start, int mid, int end) {
        int leftIndex = start;
        int rightIndex = mid + 1;
        int rightCount = 0;
        int[] newIndexes = new int[end - start + 1];

        int sortIndex = 0;

        while (leftIndex <= mid && rightIndex <= end) {
            if (nums[indexes[rightIndex]] < nums[indexes[leftIndex]]) {
                newIndexes[sortIndex] = indexes[rightIndex];
                rightCount++;
                rightIndex++;
            } else {
                newIndexes[sortIndex] = indexes[leftIndex];
                count[indexes[leftIndex]] += rightCount;
                leftIndex++;
            }
            sortIndex++;
        }

        while (leftIndex <= mid) {
            newIndexes[sortIndex] = indexes[leftIndex];
            count[indexes[leftIndex]] += rightCount;
            leftIndex++;
            sortIndex++;
        }

        while (rightIndex <= end) {
            newIndexes[sortIndex++] = indexes[rightIndex++];
        }

        System.arraycopy(newIndexes, 0, indexes, start, end - start + 1);
    }
}


public class Main {

	
	    public static void main(String[] args) {
	        int[] nums = {5, 2, 6, 1};
	        Solution solution = new Solution();
	        List<Integer> result = solution.countSmaller(nums);
	        System.out.println(result);
	    }
	}

