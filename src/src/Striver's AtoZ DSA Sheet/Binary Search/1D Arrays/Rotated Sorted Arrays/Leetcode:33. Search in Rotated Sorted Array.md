There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly left rotated at an unknown index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be left rotated by 3 indices and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

```java
class Solution {

    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[low] <= nums[mid]) {//agar left part sorted h 
                if (nums[low] <= target && target <= nums[mid]) {//target left part me available h kya
                    high = mid - 1;//move left
                } else {//target left side me nhi h 
                    low = mid + 1;//move right
                }
            } else {//left part sorted nhi tha toh right part hoga
                if (nums[mid] <= target && target <= nums[high]) {//right part me target h kya
                    low = mid + 1;//move right
                } else {//target right side me nhi h
                    high = mid - 1;//move left
                }
            }
        }

        return -1;
    }
}

```
