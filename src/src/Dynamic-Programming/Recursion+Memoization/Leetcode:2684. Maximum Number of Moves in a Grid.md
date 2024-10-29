```java

class Solution {

    public boolean inBound(int i, int j, int[][] grid) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }

    public int solve(int i, int j, int[][] grid, int[][] memoiz) {
        if (!inBound(i, j, grid)) { //Making it a Method Because we will need it Later
            return 0;
        }

        if (memoiz[i][j] != -1) return memoiz[i][j]; //Memoization

        int currMoves = 0;

        // From a cell (row, col), you can move to any of the cells: (row - 1, col + 1), (row, col + 1) and (row + 1, col + 1) such that the value of the cell you move to, should be strictly bigger than the value of the current cell.

        if (inBound(i - 1, j + 1, grid) && grid[i][j] < grid[i - 1][j + 1]) { //(i,j)=>(i-1,j+1)
            //Current Move Plus all the Recursive Moves that can be Performed
            currMoves = Math.max(currMoves, 1 + solve(i - 1, j + 1, grid, memoiz));
        }
        if (inBound(i, j + 1, grid) && grid[i][j] < grid[i][j + 1]) { //(i,j)=>(i,j+1)
            //Current Move Plus all the Recursive Moves that can be Performed
            currMoves = Math.max(currMoves, 1 + solve(i, j + 1, grid, memoiz));
        }
        if (inBound(i + 1, j + 1, grid) && grid[i][j] < grid[i + 1][j + 1]) { //(i,j)=>(i+1,j+1)
            //Current Move Plus all the Recursive Moves that can be Performed
            currMoves = Math.max(currMoves, 1 + solve(i + 1, j + 1, grid, memoiz));
        }
        return memoiz[i][j] = currMoves;//Memoization Step
    }

    public int maxMoves(int[][] grid) {
        int maxMoves = 0;

        int[][] memoiz = new int[grid.length][grid[0].length]; //2-D Array For Memoization
        for (int[] memo : memoiz) {
            Arrays.fill(memo, -1);
        }

        for (int i = 0; i < grid.length; i++) {
            int currMoves = solve(i, 0, grid, memoiz); //Always start from column zero from any Row that is why j is passed as 0
            maxMoves = Math.max(maxMoves, currMoves);
        }
        return maxMoves;
    }
}


```
