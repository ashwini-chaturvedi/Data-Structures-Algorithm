You are given a 2D integer array grid of size m * n.

You start at the top-left cell (0, 0) and want to reach the bottom-right cell (m - 1, n - 1).

At each step, you may move either right or down.

The cost of a path is defined as the bitwise XOR of all the values in the cells along that path, including the start and end cells.

Return the minimum possible XOR value among all valid paths from (0, 0) to (m - 1, n - 1).

 

Example 1:

Input: grid = [[1,2],[3,4]]

Output: 6

Explanation:

There are two valid paths:

(0, 0) → (0, 1) → (1, 1) with XOR: 1 XOR 2 XOR 4 = 7
(0, 0) → (1, 0) → (1, 1) with XOR: 1 XOR 3 XOR 4 = 6
The minimum XOR value among all valid paths is 6.  

```java
class Solution {

    public int findMinCost(int[][] grid, int i, int j,int xor,int[][][] dp) {
        if(i>=grid.length || j>=grid[0].length) return Integer.MAX_VALUE;

        xor^=grid[i][j];
        if(i==grid.length-1 && j==grid[0].length-1){
            return xor;
        }
        if(dp[i][j][xor]!=-1) return dp[i][j][xor];
        int right=findMinCost(grid,i,j+1,xor,dp);
        int down=findMinCost(grid,i+1,j,xor,dp);

        return dp[i][j][xor]=Math.min(right,down);/*You're asking:
Which child has the smaller XOR cost? I'll choose that child and XOR it with the current cell.

But the child with the smaller XOR value doesn't necessarily produce the smallest final XOR.*/
    }

    public int minCost(int[][] grid) {
        int[][][] dp=new int[grid.length+1][grid[0].length+1][1024];

        for(int[][] d:dp){
            for(int[] nums:d){
                Arrays.fill(nums,-1);
            }
        }
        return findMinCost(grid, 0, 0,0,dp);
    }
}

```
