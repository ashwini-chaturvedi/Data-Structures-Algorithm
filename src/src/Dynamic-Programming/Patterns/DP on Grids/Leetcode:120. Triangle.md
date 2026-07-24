Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

 

Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]

Output: 11

Explanation: The triangle looks like:

![image](https://github.com/user-attachments/assets/a76608d5-68ec-4046-b4d2-372bc3d9c38d)


The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).

# Recursion+Memoization
```java
class Solution {

    public int solve(List<List<Integer>> list, int idx, int jdx, int[][] dp) {

        if (idx == list.size() - 1 ) return list.get(idx).get(jdx);

        if (dp[idx][jdx] != Integer.MAX_VALUE) return dp[idx][jdx];

        int stay = solve(list, idx + 1, jdx, dp);
        int down = solve(list, idx + 1, jdx + 1, dp);

        return dp[idx][jdx]= list.get(idx).get(jdx) + Math.min(stay, down);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] dp = new int[201][201];

        for (int[] d : dp) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }

        return solve(triangle, 0, 0, dp);
    }
}
```


# Bottom-Up
```java
class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];

        // Initialize the dp array with the last row of the triangle
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }

        // Iterate from the second-last row to the top
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                // Update dp[j] with the minimum path sum at each position
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }

        // The top element of dp contains the minimum path sum
        return dp[0];
    }
}

```
