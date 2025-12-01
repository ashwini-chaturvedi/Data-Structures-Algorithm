You are given an integer array nums. The absolute sum of a subarray [numsl, numsl+1, ..., numsr-1, numsr] is abs(numsl + numsl+1 + ... + numsr-1 + numsr).


Return the maximum absolute sum of any (possibly empty) subarray of nums.


Note that abs(x) is defined as follows:

If x is a negative integer, then abs(x) = -x.

If x is a non-negative integer, then abs(x) = x.
 

Example 1:

Input: nums = [1,-3,2,3,-4]

Output: 5

Explanation: The subarray [2,3] has absolute sum = abs(2+3) = abs(5) = 5.

```java
class Solution {

    public int subArraySum(int[] nums, boolean isFindMax) {
        int subSum = nums[0];
        int currSubSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currSubSum = isFindMax ? Math.max(nums[i], currSubSum + nums[i]) : Math.min(nums[i], currSubSum + nums[i]);
            subSum = isFindMax ? Math.max(subSum, currSubSum) : Math.min(subSum, currSubSum);
        }

        return subSum;
    }

    public int maxAbsoluteSum(int[] nums) {
        //maximum of absolute value of maxSubArraySum and minSubArraySum
        int maxSubSum = subArraySum(nums, true);
        int minSubSum = subArraySum(nums, false);

        return Math.max(Math.abs(maxSubSum), Math.abs(minSubSum));
    }
}

```
