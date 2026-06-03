There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).

Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].

Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.

You must decrease the overall operation steps as much as possible.

 

Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true

```java
class Solution {

    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

           if (nums[mid] == target) {
                return true;
            }else if(nums[low]==nums[mid] && nums[mid]==nums[high]){ /*!IMPORTANT: to remove the duplicacy in the window of low to high we just move both the pointers */
                low++;
                high--;
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

        return false;
    }
}

```
