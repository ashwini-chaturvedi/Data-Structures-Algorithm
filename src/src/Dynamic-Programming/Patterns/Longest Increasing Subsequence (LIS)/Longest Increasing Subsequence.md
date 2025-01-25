Given an integer array nums, return the length of the longest strictly increasing 
subsequence.

 

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]

Output: 4

Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
```java
class Solution {

    public int LIS(int[] nums, int idx, int prevIdx, int[][] dp) {
        if (idx == nums.length) return 0;


        if ( dp[idx+1][prevIdx+1] != -1) return dp[idx+1][prevIdx+1];

        int exclude = LIS(nums, idx + 1, prevIdx, dp);//exclude the element at this index

        int include = 0;
        if (prevIdx == -1 || nums[idx] > nums[prevIdx]) {//if the element is in Increasing Order.
            include = 1 + LIS(nums, idx + 1, idx, dp);//take it and Increase its count.
        }

        return dp[idx+1][prevIdx+1] = Math.max(include, exclude);//maximum count after including or excluding the current Element.
    }

    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length + 1][nums.length + 1];

        for (int[] memo : dp) {
            Arrays.fill(memo, -1);
        }     
        
        return LIS(nums, 0, -1, dp);
    }
}

```
