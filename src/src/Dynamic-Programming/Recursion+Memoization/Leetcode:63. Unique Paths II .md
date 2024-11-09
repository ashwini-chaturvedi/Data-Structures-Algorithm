# Here 1 Represents Obstacle and if Grid[i][j]==1 that means we cannot move to that Cell.
```java
class Solution {
    public int solve(int[][] Grid, int i, int j, int[][] directions, int[][] memoiz) {
        if (i == Grid.length - 1 && j == Grid[0].length - 1) return 1;

        if (memoiz[i][j] != -1) return memoiz[i][j];

        int paths = 0;

        for (int[] dir : directions) {
            int newI = i + dir[0];
            int newJ = j + dir[1];

            if (newI >= 0 && newI < Grid.length && newJ >= 0 && newJ < Grid[0].length && Grid[newI][newJ] != 1) {
                paths += solve(Grid, newI, newJ, directions, memoiz);
            }
        }

        return memoiz[i][j] = paths;
    }

    public int uniquePathsWithObstacles(int[][] Grid) {
        if(Grid[0][0]==1) return 0; //if the Starting is at an obstacle then return 0
        
        int[][] directions = { { 0, 1 }, { 1, 0 } };

        int[][] memoiz = new int[Grid.length][Grid[0].length];

        for (int[] memo : memoiz) {
            Arrays.fill(memo, -1);
        }
        
        return solve(Grid, 0, 0, directions, memoiz);
    }
}

```
