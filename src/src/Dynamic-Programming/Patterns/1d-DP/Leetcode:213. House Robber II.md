You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [2,3,2]

Output: 3

Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.

# Recursion + Memoization/Top-Down
```java
class Solution {
    public int solve(int[]nums,int idx,int n,int[] dp){
        if(idx>=n){
            return 0;
        }

        if(dp[idx]!=-1) return dp[idx];

        int take=nums[idx]+solve(nums,idx+2,n,dp);
        int leave=solve(nums,idx+1,n,dp);


        return dp[idx]=Math.max(take,leave);
    }
    public int rob(int[] nums) {
        
        int[] dp=new int[nums.length+1];
        Arrays.fill(dp,-1);
        int takeFirst=nums[0]+solve(nums,2,nums.length-1,dp);

        dp=new int[nums.length+1];
        Arrays.fill(dp,-1);
        int leaveFirst=solve(nums,1,nums.length,dp);
        
        return Math.max(takeFirst,leaveFirst);
    }
}
```
