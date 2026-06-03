A peak element is an element that is strictly greater than its neighbors.

Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.

You must write an algorithm that runs in O(log n) time.

 

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.

```java
class Solution {

    public int findPeakElement(int[] nums) {
        //Higher value ki side move kro
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if ((mid == 0 || nums[mid - 1] < nums[mid]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) {
                //mid ki value peak value h
                return mid;
            } else if (mid != 0 && mid != nums.length - 1) { //agar mid terminal index nhi h toh -1,+1 indexes check krlo
                if (nums[mid - 1] > nums[mid + 1]) { //higher value ki side move kro
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (mid == 0) { //mid left terminal index h toh right ki trf jao
                low = mid + 1;
            } else {//right terminal index h toh left ki trf jao
                high = mid - 1;
            }
        }

        return -1;
    }
}

```
