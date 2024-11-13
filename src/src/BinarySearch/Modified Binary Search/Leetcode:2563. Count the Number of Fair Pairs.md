# Modified Binary Search Algorithm to find the right bound and left bound
```java
class Solution {

    // This method finds the left boundary (first index where nums[i] + nums[j] >= lower)
    public long findLeftBounds(int[] nums, int startIdx, int target) {
        int low = startIdx;
        int high = nums.length - 1;

        // Standard binary search loop to locate the first valid index
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // If nums[mid] is greater than or equal to target, this could be a valid lower bound which means we want to go as lower as we want to find the lowest possible bound
            if (nums[mid] >= target) {
                high = mid - 1; // Narrow down to potentially find a lower valid index
            } else {
                low = mid + 1; // Move right since nums[mid] is less than target
            }
        }
        return low; // 'low' now points to the first index where nums[i] + nums[j] >= lower
    }

    // This method finds the right boundary (first index where nums[i] + nums[j] > upper)
    public long findRightBounds(int[] nums, int startIdx, int target) {
        int low = startIdx;
        int high = nums.length - 1;

        // Standard binary search loop to locate the first index that exceeds the upper limit
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // If nums[mid] is greater than target, move left to narrow down  which means we want to go as lower as we want to find the lowest possible bound
            if (nums[mid] > target) {
                high = mid - 1; // Continue searching in the left half
            } else {
                low = mid + 1; // Move right as nums[mid] <= target
            }
        }
        return low; // 'low' now points to the first index where nums[i] + nums[j] > upper
    }

    // This method counts the fair pairs in the array
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums); // Sort the array for efficient searching

        long pairs = 0; // Initialize pair count
        for (int i = 0; i < nums.length; i++) {
            // Find the left boundary (first index where nums[i] + nums[j] >= lower)
            long leftBound = findLeftBounds(nums, i + 1, lower - nums[i]);
            // Find the right boundary (first index where nums[i] + nums[j] > upper)
            long rightBound = findRightBounds(nums, i + 1, upper - nums[i]);


/*for eg.:[0,1,4,4,5,7] =>
    1.leftBound=2 because at nums[2]==4 which is the least value found in nums whose sum with nums[i] will be less than or equal to the lower Bound
    2. rightBound=5 because at nums[5]==7 which is the Greatest value found in nums whose sum with nums[i] will be Greater than  to the upper Bound
and all the elements in between this will form a valid pair with 'i' whose sum with nums[i] will be in the bounds...*/

            // All indices between leftBound and rightBound - 1 form valid pairs
            pairs += (rightBound - leftBound);
        }
        return pairs;
    }
}
```
