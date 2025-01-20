The Array is in
          Sorted in Ascending Order + Peak Element + Sorted in Descending Order
so,
1. Find Peak Element and Index
2. Binary Search Ascending in First Part
3. Binary Search Descending in Second Part
```java
public class Solution {

    // Binary search method to search for the target in a sorted subarray
    public int BinarySearch(ArrayList<Integer> nums, int target, int low, int high, boolean inAsc) {
        while (low <= high) {
            // Calculate the middle index
            int mid = low + (high - low) / 2;

            // If the mid element is the target, return the index
            if (nums.get(mid) == target) {
                return mid;
            } 
            // If the target is greater than the mid element
            else if (nums.get(mid) < target) {
                if (inAsc) { // If the array is sorted in ascending order, move right
                    low = mid + 1;
                } else {    // If the array is sorted in descending order, move left
                    high = mid - 1;
                }
            } 
            // If the target is smaller than the mid element
            else { 
                if (inAsc) { // If the array is sorted in ascending order, move left
                    high = mid - 1;
                } else {    // If the array is sorted in descending order, move right
                    low = mid + 1;
                }
            }
        }

        // Return -1 if the target is not found
        return -1;
    }

    // Method to find the peak index in a bitonic array
    public int getPeakIndex(ArrayList<Integer> nums) {
        int low = 0;
        int high = nums.size() - 1;

        // Binary search to find the peak element
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if the mid element is the peak
            if ((mid == 0 || nums.get(mid - 1) < nums.get(mid)) && 
                (mid == nums.size() - 1 || nums.get(mid) > nums.get(mid + 1))) {
                return mid; // Return the index of the peak element
            } 
            // If the mid element is smaller than the next element, the peak lies on the right
            else if (nums.get(mid) < nums.get(mid + 1)) {
                low = mid + 1;
            } 
            // Otherwise, the peak lies on the left
            else {
                high = mid - 1;
            }
        }

        // Return -1 if no peak is found (should not happen in a valid bitonic array)
        return -1;
    }

    // Main method to solve the problem
    public int solve(ArrayList<Integer> nums, int target) {
        // Step 1: Find the peak index in the bitonic array
        int peakIdx = getPeakIndex(nums);

        // Step 2: Check if the peak element is the target
        if (peakIdx != -1 && nums.get(peakIdx) == target) {
            return peakIdx; // Return the peak index if it's the target
        }

        // Step 3: Search in the ascending part of the array (left of the peak)
        int left = BinarySearch(nums, target, 0, peakIdx - 1, true);
        if (left != -1) return left; // If found, return the index

        // Step 4: Search in the descending part of the array (right of the peak)
        int right = BinarySearch(nums, target, peakIdx, nums.size() - 1, false);
        if (right != -1) return right; // If found, return the index

        // Step 5: If the target is not found in either part, return -1
        return -1;
    }
}

```
