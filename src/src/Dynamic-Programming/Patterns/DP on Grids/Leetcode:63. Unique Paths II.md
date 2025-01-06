# Recursion + Memoization
```java
class Solution {
    public int dpOnGrid(int[][] grid, int i, int j, int[][] memoiz) {
        // Out of bounds or hit an obstacle
        if (i >= grid.length || j >= grid[0].length || grid[i][j] == 1) {
            return 0;
        }
        
        // Reached destination
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return 1;
        }
        
        // Check memoization
        if (memoiz[i][j] != -1) {
            return memoiz[i][j];
        }
        
        // Move right and down
        int right = dpOnGrid(grid, i, j + 1, memoiz);
        int down = dpOnGrid(grid, i + 1, j, memoiz);
        
        return memoiz[i][j] = right + down;
    }
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Check if start or end has obstacle
        if (obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] == 1) {
            return 0;
        }
        
        int[][] memoiz = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int[] memo : memoiz) {
            Arrays.fill(memo, -1);
        }
        
        return dpOnGrid(obstacleGrid, 0, 0, memoiz);
    }
}
```

# Bottom-Up
```java
class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) return 0;

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m ][n ];

        //Initialization 
        dp[0][0] = 1;//because if whole grid is of 1X1 then to reach source to source is 1.

        //we will fill the first row first column separately avoiding the obstacles

        //Fill the First Row
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;
            } else {
                dp[i][0] = dp[i - 1][0];
            }
        }
        //Fill the First Column
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                dp[0][j ] = 0;
            } else {
                dp[0][j] = dp[0][j - 1];
            }
        }

        //find the distance
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}

```
