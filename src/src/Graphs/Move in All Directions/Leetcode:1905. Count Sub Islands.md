```java
 class Solution {

    public boolean isValid(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }

    public void countIsland(int[][] grid1, int grid2[][], int i, int j, int[][] directions, boolean[] isSubIsland) {
        if (!isValid(grid1, i, j) || grid2[i][j] == 0) return;

        // If grid2 has land (1) where grid1 has water (0), it's not a sub-island
        if (grid1[i][j] == 0) {
            isSubIsland[0] = false;
        }

        grid2[i][j] = 0; //Marking the land as visited

        for (int[] dir : directions) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            if (isValid(grid1, newI, newJ) && grid2[newI][newJ] == 1) {
                countIsland(grid1, grid2, newI, newJ, directions, isSubIsland);
            }
        }
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        int m = grid1.length;
        int n = grid1[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) { //if Found land on Grid 2
                    boolean[] isSubIsland = { true }; //a land can be possible subIsland in grid2 if all the land connecting are present in grid1
                    countIsland(grid1, grid2, i, j, directions, isSubIsland);

                    if (isSubIsland[0] == true) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}

```
