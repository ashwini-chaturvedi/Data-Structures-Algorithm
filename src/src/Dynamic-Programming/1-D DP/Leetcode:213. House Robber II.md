# Recursion + Memoization
```java
class Solution {

    public int solve(int[] nums, int start, int end, int[] dp) {
        if (start > end) return 0;

        if (dp[start] != -1) return dp[start];

        int rob = nums[start] + solve(nums, start + 2, end, dp);//Skipping the neighbour
        int noRob = solve(nums, start + 1, end, dp);//Skiping the current house from robbing.

        return dp[start] = Math.max(rob, noRob);
    }

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

    /*
    We will check for 2 seperate ways:
    (i) Robbing the First house then leaving the last
    (ii) Robbing the Last house then leaving the First
    */

        int[] dp = new int[nums.length + 1];
        
        Arrays.fill(dp, -1);
        int robFirst = solve(nums, 0, nums.length - 2, dp); //Skip the Last House;

        Arrays.fill(dp, -1);
        int robLast = solve(nums, 1, nums.length - 1, dp);//Skip the Last House

        return Math.max(robFirst, robLast);
    }
}

```
# Bottom-Up
```java
class Solution {

    public int bottomUp(int[] nums, int start, int end) {
        if (start > end) return 0;
        if (start == end) return nums[start];

        if (start + 1 == end) return Math.max(nums[start], nums[end]);

        int[] dp = new int[end - start + 1];//DP Array only the size allowed

        //DP Initialization
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);

        for (int i = 2; i < dp.length; i++) {
            int rob = nums[start + i] + dp[i - 2];
            int noRob = dp[i - 1];

            dp[i] = Math.max(rob, noRob);
        }

        return dp[dp.length - 1];
    }

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        //We can either rob first house or last house because the array is in circular manner
        int robFirst = bottomUp(nums, 0, nums.length - 2);//Rob 1st house leave last house

        int robLast = bottomUp(nums, 1, nums.length - 1);//Rob last house leave 1st House.

        return Math.max(robFirst, robLast);
    }
}

```

