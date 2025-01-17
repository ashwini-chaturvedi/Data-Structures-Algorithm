```java
class Solution {
    public int findMin(int[] nums) {
        int n = nums.length; // Length of the input array
        int low = 0; // Initialize the low pointer
        int high = nums.length - 1; // Initialize the high pointer

        // Binary search to find the minimum element in the rotated sorted array
        while (low <= high) {
            // If the subarray [low, high] is already sorted, return the first element
            if (nums[low] <= nums[high]) {
                return nums[low];
            }

            // Calculate the mid-point of the current range
            int mid = low + (high - low) / 2;

            // Calculate the indices of the previous and next elements for the mid element
            int prevIdx = (mid - 1 + n) % n; // Handles wrap-around for the start of the array
            int nextIdx = (mid + 1) % n; // Handles wrap-around for the end of the array

            // Check if the mid element is the minimum
            if (nums[prevIdx] >= nums[mid] && nums[mid] <= nums[nextIdx]) {
                return nums[mid];
            }
            // If the left half [low, mid] is sorted, the minimum must be in the right half
            else if (nums[low] <= nums[mid]) {
                low = mid + 1; // Move to the right half
            }
            // Otherwise, the right half [mid, high] is sorted, and the minimum is in the left half
            else if (nums[mid] <= nums[high]) {
                high = mid - 1; // Move to the left half
            }
        }

        return 0; // Default return (should not reach here for a valid rotated sorted array)
    }
}

```
