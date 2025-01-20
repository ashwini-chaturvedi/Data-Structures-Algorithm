Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.

Return the minimized largest sum of the split.

A subarray is a contiguous part of the array.

 

Example 1:

Input: nums = [7,2,5,10,8], k = 2
Output: 18
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.
```java
class Solution {

    // Helper function to determine if it is possible to split the array into `Subarrays`
    // such that the sum of elements in each subarray does not exceed `maxAllowed`.
    public boolean isValid(int[] nums, int Subarrays, int maxAllowed) {
        int subarray = 1; // Start with the first subarray
        int sum = 0; // Sum of the current subarray

        // Iterate through the array to form subarrays
        for (int num : nums) {
            sum += num; // Add the current number to the current subarray's sum

            // If the sum exceeds the allowed maximum (`maxAllowed`):
            if (sum > maxAllowed) {
                subarray++; // Start a new subarray
                sum = num; // The new subarray starts with the current number
            }

            // If the number of subarrays exceeds the allowed number (`Subarrays`), return false
            if (subarray > Subarrays) {
                return false;
            }
        }
        return true; // If all numbers can be split within the constraints, return true
    }

    // Main function to find the minimum largest sum among `k` subarrays
    public int splitArray(int[] nums, int k) {
        // Initialize the search bounds
        int low = 0; // The minimum possible largest sum (the largest single element in the array)
        int high = 0; // The maximum possible largest sum (sum of all elements in the array)

        // Set `low` to the maximum element and `high` to the total sum of the array
        for (int num : nums) {
            low = Math.max(low, num); // The largest number sets the minimum bound
            high += num; // The sum of all elements sets the maximum bound
        }

        int res = -1; // Variable to store the result (minimum largest sum)

        // Perform binary search to find the minimum largest sum
        while (low <= high) {
            int mid = low + (high - low) / 2; // Calculate the midpoint of the current range

            // Check if it is possible to split the array into `k` subarrays
            // such that no subarray's sum exceeds `mid`
            if (isValid(nums, k, mid)) {
                res = mid; // Update the result with the current valid maximum
                high = mid - 1; // Try to minimize further by reducing the upper bound
            } else {
                low = mid + 1; // Increase the lower bound to find a valid maximum
            }
        }

        return res; // Return the minimum largest sum
    }
}

```
