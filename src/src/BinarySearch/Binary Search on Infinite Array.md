```java
public class BinarySearchOnInfiniteArray {
    public static int BinarySearch(int[] nums, int target) {
        int low = 0;
        int high = 1;

        // Expand the search range until the target is within [low, high]
        while (high < nums.length && nums[high] < target) {
            low = high;       // Move the lower bound to the current upper bound
            high = 2 * high;  // Double the high index to expand the search range
        }

        // Adjust `high` to the last valid index if it exceeds the array size
        high = Math.min(high, nums.length - 1);

        // Perform standard binary search within the identified range
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid; // Target found
            } else if (nums[mid] < target) {
                low = mid + 1; // Search in the right half
            } else {
                high = mid - 1; // Search in the left half
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int target = 8;

        System.out.println(BinarySearch(nums, target));

        /*
        * Constraints:
               2<nums.length<10^9
        */
    }
}


```
