```java
class Solution {

    public int solve(int i, int j, int m, int n, int[][] directions, int[][] memoiz) {
        if (i == m - 1 && j == n - 1) return 1;//base Case when you reach [m-1][n-1] return 1.

        if (memoiz[i][j] != -1) return memoiz[i][j];//Memoization

        int paths = 0;

        for (int[] dir : directions) {
            int newI = i + dir[0];
            int newJ = j + dir[1];

            if (newI >= 0 && newI < m && newJ >= 0 && newJ < n) {
                paths += solve(newI, newJ, m, n, directions, memoiz);
            }
        }

        return memoiz[i][j] = paths;//Memoization
    }

    public int uniquePaths(int m, int n) {
        int[][] directions = {
            { 0, 1 }, //Right
            { 1, 0 } //Down
        };

        int[][] memoiz = new int[m][n];

        for (int[] memo : memoiz) {
            Arrays.fill(memo, -1);
        }

        return solve(0, 0, m, n, directions, memoiz);
    }
}

```
