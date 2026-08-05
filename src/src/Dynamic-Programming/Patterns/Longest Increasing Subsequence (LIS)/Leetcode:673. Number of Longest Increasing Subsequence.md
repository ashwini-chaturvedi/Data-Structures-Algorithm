Given an integer array nums, return the number of longest increasing subsequences.

Notice that the sequence has to be strictly increasing.

 

Example 1:

Input: nums = [1,3,5,4,7]

Output: 2

Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].

Example 2:

Input: nums = [2,2,2,2,2]

Output: 5

Explanation: The length of the longest increasing subsequence is 1, and there are 5 increasing subsequences of length 1, so output 5.
 

Constraints:

- 1 <= nums.length <= 2000
- -10^-6 <= nums[i] <= 10^6
- The answer is guaranteed to fit inside a 32-bit integer.


When you've reached the end, how many ways are there to form an LIS of length 0?

- There is one way: choose nothing.

- So the base case should conceptually be:

- (length = 0, count = 1)

# Recursion + memoization
```java
class Solution {

    public int[] solve(int[] nums, int idx, int lastIdx,int[][][] dp) {
        if (idx >= nums.length) return new int[] { 0, 1 };
        if(dp[idx][lastIdx+1][0]!=-1 && dp[idx][lastIdx+1][1]!=-1) return new int[]{dp[idx][lastIdx+1][0],dp[idx][lastIdx+1][1]};

        int[] skip = solve(nums, idx + 1, lastIdx,dp);
        int[] take = new int[2];

        if (lastIdx == -1 || nums[lastIdx] < nums[idx]) {
            take = solve(nums, idx + 1, idx,dp);
            take[0] += 1;
        }


        int[] res = new int[2];

        if (take[0] == skip[0]) {
            res[0] = take[0];
            res[1] = take[1] + skip[1];
        } else if (take[0] > skip[0]) {
            res[0] = take[0];
            res[1] = take[1];
        } else {
            res[0] = skip[0];
            res[1] = skip[1];
        }


        dp[idx][lastIdx+1][0]=res[0];
        dp[idx][lastIdx+1][1]=res[1];
        return new int[]{dp[idx][lastIdx+1][0],dp[idx][lastIdx+1][1]};
    }

    public int findNumberOfLIS(int[] nums) {
        int[][][] dp=new int[nums.length+1][nums.length+1][2];

        for(int[][] d:dp){
            for(int[] memo:d){
                Arrays.fill(memo,-1);
            }
        }

        int[] maxSize = solve(nums, 0, -1,dp);
        return maxSize[1];
    }
}

```
