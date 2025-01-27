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
 

Example 1:
![image](https://assets.leetcode.com/uploads/2020/04/23/sample_2_1802.png)
Input: grid = [[1,0,0,0,0,0,1],[2,0,0,0,0,3,0],[2,0,9,0,0,0,0],[0,3,0,5,4,0,0],[1,0,2,3,0,0,6]]
Output: 28
Explanation: Path of robot #1 and #2 are described in color green and blue respectively.
Cherries taken by Robot #1, (1 + 9 + 5 + 2) = 17.
Cherries taken by Robot #2, (1 + 3 + 4 + 3) = 11.
Total of cherries: 17 + 11 = 28.
```java
class Solution {

    public int solve(int[][] grid, int row, int col1, int col2, int[][][] memoiz) {
        if (row >= grid.length) return 0; //Base Case if Out of Bound

        if (memoiz[row][col1][col2] != -1) return memoiz[row][col1][col2];//Return Memoized Result

        int cherry = grid[row][col1];//Take the Cherry

        if (col1 != col2) {//If Both the Cells (row,col1) & (row,col2) are not same Co-ordinates then include the cherry of (row,col2) because the robot two will pick Cherry from that Cell
            cherry += grid[row][col2];
        }

        int res = 0;

        //For Every Movement of Robot1 the Robot2 has Possibly 3 Movement i.e. j-1,j,j+1 Hence, Total of 9 Moves.
        // -1,0,1 this is like j-1,j,j+1 Moving Directions
        for (int val1 = -1; val1 <= 1; val1++) {//For Robot:1
            for (int val2 = -1; val2 <= 1; val2++) {//For Robot:2
                int newRow = row + 1;//Row will always Increase by 1 because we go Down the Grid

                //Make the Co-ordinates so that the Robots can Move.
                int newCol1 = col1 + val1;
                int newCol2 = col2 + val2;

                if (newCol1 >= 0 && newCol1 < grid[0].length && newCol2 >= 0 && newCol2 < grid[0].length) {
                    res = Math.max(res, solve(grid, newRow, newCol1, newCol2, memoiz));//Maximum Path Sum
                }
            }
        }

        return memoiz[row][col1][col2] = cherry + res;//Return the Result with Cherry of Current Movement
    }

    public int cherryPickup(int[][] grid) {
        int[][][] memoiz = new int[grid.length][grid[0].length][grid[0].length];

        for (int[][] nums : memoiz) {
            for (int[] memo : nums) {
                Arrays.fill(memo, -1);
            }
        }

        //Since Both Robots Moves Simultaneously Down so we have to Only Use two Columns Pointers because columns may vary but the Row will always be same they go down by one Row in Grid.

        return solve(grid, 0, 0, grid[0].length - 1, memoiz);
    }
}

```
