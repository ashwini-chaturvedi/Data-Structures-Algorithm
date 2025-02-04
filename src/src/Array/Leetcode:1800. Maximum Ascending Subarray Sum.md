Given an array of positive integers nums, return the maximum possible sum of an ascending subarray in nums.

A subarray is defined as a contiguous sequence of numbers in an array.

A subarray [numsl, numsl+1, ..., numsr-1, numsr] is ascending if for all i where l <= i < r, numsi  < numsi+1. Note that a subarray of size 1 is ascending.

 

Example 1:

Input: nums = [10,20,30,5,10,50]
Output: 65
Explanation: [5,10,50] is the ascending subarray with the maximum sum of 65.
Example 2:

Input: nums = [10,20,30,40,50]
Output: 150
Explanation: [10,20,30,40,50] is the ascending subarray with the maximum sum of 150.
Example 3:

Input: nums = [12,17,15,13,10,11,12]
Output: 33
Explanation: [10,11,12] is the ascending subarray with the maximum sum of 33.

```java
class Solution {

    public int maxAscendingSum(int[] nums) {
        int sum = nums[0];//Initial Sum is the First Element of the Array.
        int maxSum = 0;

        int i = 1;//Start From First Index
        while (i < nums.length) {
            if (nums[i] > nums[i - 1]) {//if Ascending Order is there
                sum += nums[i];
            } else {
                maxSum = Math.max(maxSum, sum);
                sum = nums[i];
            }
            i++;
        }
        return Math.max(maxSum, sum);
    }
}

```
