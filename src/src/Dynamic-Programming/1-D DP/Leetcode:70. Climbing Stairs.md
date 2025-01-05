# Bottom-Up

```java
class Solution {
    public int climbStairs(int n) {
        if(n==1) return 1;//to reach 1st stair there is only one way
        int[] dp=new int[n+1];

        dp[1]=1;//to reach 1st stair there is only one way
        dp[2]=2;//to reach 2nd stair there is two ways 1+1 or 2(direct)

        for(int i=3;i<n+1;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }

        return dp[n];
    }
}
```
# Recursion+Memoization
```java
class Solution {

    public int solve(int n, int[] dp) {
        if (n == 0 || n == 1) return 1;

        if (dp[n] != -1) return dp[n];
        return dp[n] = solve(n - 1, dp) + solve(n - 2, dp);
    }

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return solve(n, dp);
    }
}

```
