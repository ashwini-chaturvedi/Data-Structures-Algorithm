There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.

 

Example 1:

![image](https://assets.leetcode.com/uploads/2018/10/22/robot_maze.png)

Input: m = 3, n = 7
Output: 28
# Recursion + Memoization
```java
class Solution {
    public int solve(int sourceStart, int sourceEnd, int m, int n, int[][] memoiz) {
        if (sourceStart >= m || sourceEnd >= n) return 0; //Reached the out of bound Index

        if (sourceStart == m - 1 && sourceEnd == n - 1) return 1; //Reached the last Index

        if (memoiz[sourceStart][sourceEnd] != -1) {
            return memoiz[sourceStart][sourceEnd];
        }

        int down=solve(sourceStart+1,sourceEnd,m,n,memoiz);//Move Down
        int right=solve(sourceStart,sourceEnd+1,m,n,memoiz);//Move Right
        
        return memoiz[sourceStart][sourceEnd] = down+right;//Some of Both Paths.
    }

    public int uniquePaths(int m, int n) {

        int[][] memoiz = new int[m + 1][n + 1];

        for (int[] memo : memoiz) {
            Arrays.fill(memo, -1);
        }

        return solve(0, 0, m, n, memoiz);
    }
}

```

# Bottom-Up
```java
class Solution {
    public int uniquePaths(int m, int n) {
        if(m==1 && n==1) return 1;
        int[][] dp=new int[m+1][n+1];

        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                
                if(i==0 ||j==0) dp[i][j]=1;//ways to reach cells on same row and column is only 1.
            }
        }

        dp[0][0]=0;//Ways to reach source from source is zero

        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];//Number of ways to reach current cell is by adding the number of ways in up and left adjacent cell because those are only cells from which we can arrive to this cell
            }
        }
        return dp[m-1][n-1];
    }
}
```
