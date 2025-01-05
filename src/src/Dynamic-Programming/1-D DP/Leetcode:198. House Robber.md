# Bottom-Up
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
# Recursion+Memoization

```java
class Solution {

    public int solve(int[] nums, int idx, int[] dp) {
        if (idx >= nums.length) {
            return 0;
        }

        if (dp[idx] != -1) {
            return dp[idx];
        }

        int rob = nums[idx] + solve(nums, idx + 2,dp);
        int notRob = solve(nums, idx + 1,dp);

        return dp[idx] = Math.max(rob, notRob);
    }

    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];        

        dp[0]=0;
        dp[1]=nums[0];
        for(int i=2;i<nums.length+1;i++){
            int rob=nums[i-1]+dp[i-2];
            int notRob=dp[i-1];

            dp[i]=Math.max(rob,notRob);
        }
        return dp[nums.length];
    }
}
```
