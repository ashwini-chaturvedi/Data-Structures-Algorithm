You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [1,2,3,1]

Output: 4

Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).

Total amount you can rob = 1 + 3 = 4.

# Recursion + Memoization / Top-Down
```java
class Solution {
    public int solve(int[] nums,int idx,int[] dp){
        if(idx>=nums.length) return 0;

        if(dp[idx]!=-1) return dp[idx];

        int takeCurr=nums[idx]+solve(nums,idx+2,dp);
        int takeNext=solve(nums,idx+1,dp);

        return dp[idx]=Math.max(takeCurr,takeNext);
    }
    public int rob(int[] nums) {
        int[] dp=new int[nums.length+1];
        Arrays.fill(dp,-1);
        return solve(nums,0,dp);
    }
}
```

# Bottom-up
```java
class Solution {
//Write Recursion +Memoization from there do DP(Bottom Up).
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1]; //to store the money gained from robbing a house


        //Initialization
        dp[0] = 0;
        dp[1] = nums[0];//Start by storing the value of first hounse because when a robber skips the neighbouring house it may come to house 1.
        for (int i = 2; i < nums.length + 1; i++) {

            int rob = nums[i - 1] + dp[i - 2];
            int notRob = dp[i - 1];

            dp[i] = Math.max(rob, notRob);
        }
        return dp[nums.length];
    }
}
```
