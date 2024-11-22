```java
class Solution {

    public boolean isValid(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }

    public void walk(int[][] grid, int i, int j, int[][] directions) {
        if (!isValid(grid, i, j) || grid[i][j] == 0) return;

        grid[i][j] = 0;

        for (int[] dir : directions) {
            int newI = i + dir[0];
            int newJ = j + dir[1];

            if (isValid(grid, newI, newJ) && grid[newI][newJ] == 1) {
                walk(grid, newI, newJ, directions);
            }
        }
    }

    public int numEnclaves(int[][] grid) {
        int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

        int remainingOnes = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0 || i == grid.length - 1 || j == 0 || j == grid[0].length - 1) {
                        //Only Walk on those land(1) that are attached to Boundary and not Enclosed by 0's
                        walk(grid, i, j, directions);
                    } 
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    remainingOnes++;
                }
            }
        }

        return remainingOnes;
    }
}

```
