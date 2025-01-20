Input: nums = [1,2,1,3,5,6,4]

Output: 5

Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.

# Full Explaination
```java
class Solution {
    public int findPeakElement(int[] nums) {
        // If the array has only one element, return 0 (the single element is the peak)
        if (nums.length == 1) return 0;

        int low = 0;
        int high = nums.length - 1;

        // Perform binary search to find the peak element
        while (low <= high) {
            int mid = low + (high - low) / 2; // Calculate the middle index to avoid overflow

            // Case 1: If 'mid' is not on the boundaries (not the first or last element)
            if (mid != 0 && mid != nums.length - 1) {
                // Check if the current element is greater than its neighbors
                if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                    return mid; // 'mid' is a peak element
                } 
                // If the left neighbor is greater, move the search to the left half
                else if (nums[mid - 1] > nums[mid]) {
                    high = mid - 1;
                } 
                // If the right neighbor is greater, move the search to the right half
                else if (nums[mid] < nums[mid + 1]) {
                    low = mid + 1;
                }
            } 
            // Case 2: If 'mid' is the first element (index 0)
            else if (mid == 0) {
                // Compare the first element with the second to determine if it's a peak
                if (nums[0] > nums[1]) {
                    return 0; // The first element is a peak
                } else {
                    return 1; // The second element is the peak
                }
            } 
            // Case 3: If 'mid' is the last element (index nums.length - 1)
            else if (mid == nums.length - 1) {
                // Compare the last element with the second-last to determine if it's a peak
                if (nums[nums.length - 1] > nums[nums.length - 2]) {
                    return nums.length - 1; // The last element is a peak
                } else {
                    return nums.length - 2; // The second-last element is the peak
                }
            }
        }
        return -1; // Return -1 if no peak element is found (this case won't occur for a valid input)
    }
}

```

# Shortform
```java
class Solution {
    public int findPeakElement(int[] nums) {
        // Initialize pointers for the binary search
        int low = 0;
        int high = nums.length - 1;

        // Perform binary search to find the peak element
        while (low <= high) {
            // Calculate the mid-point of the current range
            int mid = low + (high - low) / 2;

            // Check if the current mid element is a peak
            // A peak element is greater than its neighbors (if they exist)
            if ((mid == 0 || nums[mid - 1] < nums[mid]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) {
                return mid; // Return the index of the peak element
            }
            // If the right neighbor is greater, the peak must lie on the right side
            else if (nums[mid] < nums[mid + 1]) {
                low = mid + 1; // Move to the right half
            }
            // Otherwise, the peak lies on the left side
            else {
                high = mid - 1; // Move to the left half
            }
        }

        return -1; // Default return (should not reach here for a valid input)
    }
}

```
