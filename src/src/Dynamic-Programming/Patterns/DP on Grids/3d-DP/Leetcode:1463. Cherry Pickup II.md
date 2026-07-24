You are given a rows x cols matrix grid representing a field of cherries where grid[i][j] represents the number of cherries that you can collect from the (i, j) cell.

You have two robots that can collect cherries for you:

Robot #1 is located at the top-left corner (0, 0), and
Robot #2 is located at the top-right corner (0, cols - 1).
Return the maximum number of cherries collection using both robots by following the rules below:

From a cell (i, j), robots can move to cell (i + 1, j - 1), (i + 1, j), or (i + 1, j + 1).
When any robot passes through a cell, It picks up all cherries, and the cell becomes an empty cell.
When both robots stay in the same cell, only one takes the cherries.
Both robots cannot move outside of the grid at any moment.
Both robots should reach the bottom row in grid.
 


Example 2:

![](https://assets.leetcode.com/uploads/2020/04/23/sample_2_1802.png)

Input: grid = [[1,0,0,0,0,0,1],[2,0,0,0,0,3,0],[2,0,9,0,0,0,0],[0,3,0,5,4,0,0],[1,0,2,3,0,0,6]]

Output: 28

Explanation: Path of robot #1 and #2 are described in color green and blue respectively.

Cherries taken by Robot #1, (1 + 9 + 5 + 2) = 17.

Cherries taken by Robot #2, (1 + 3 + 4 + 3) = 11.

Total of cherries: 17 + 11 = 28.

```java
class Solution {

    public int solve(int[][] grid, int row, int c1, int c2, int[][][] dp) {
        // Row or Column out of bound.
        if (row < 0 || row >= grid.length || c1 < 0 || c1 >= grid[0].length || c2 < 0 || c2 >= grid[0].length) return 0;


        if (dp[row][c1][c2] != -1) return dp[row][c1][c2];

        int cherries = 0;

        if (c1 == c2) {//if both the cells are same then sum any one.
            cherries = grid[row][c1];
        } else {//else some of cherries in boith the cells

            cherries = (grid[row][c1] + grid[row][c2]);
        }

        int res = 0; 
        //looping for covering every possible adjacent columns
        for (int idx = -1; idx <= 1; idx++) {
            for (int jdx = -1; jdx <= 1; jdx++) {

                //Creating New Columns
                int newCol1 = c1 + idx;
                int newCol2 = c2 + jdx;

                res = Math.max(res, solve(grid, row + 1, newCol1, newCol2,dp));
            }
        }

        return dp[row][c1][c2] = cherries + res;
    }

    public int cherryPickup(int[][] grid) {
        int[][][] dp = new int[grid.length][grid[0].length][grid[0].length];

        for (int[][] d : dp) {
            for (int[] p : d) {
                Arrays.fill(p, -1);
            }
        }
        return solve(grid, 0, 0, grid[0].length - 1, dp);
    }
}

```
