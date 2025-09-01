```java
class Solution {
    public void gameOfLife(int[][] board) {
        int[][] directions = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1},
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
        };

        int m = board.length, n = board[0].length;

        // First pass: mark transitions
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int live = 0;

                for (int[] dir : directions) {
                    int newI = i + dir[0];
                    int newJ = j + dir[1];

                    if (newI< 0 || newJ < 0 || newI >= m || newJ >= n) continue;//Out Of Bound

                    if (Math.abs(board[newI][newJ]) == 1) live++;//Living Node
                }

                //We will First Mark the cells for alteration so
                //Marking the Cells as 
                // 1.less than Zero for live to dead and 
                // 2.greater then 1 for dead to live

                if (board[i][j] == 1 && (live < 2 || live > 3)) {
                    board[i][j] = -1; // live → dead
                }
                if (board[i][j] == 0 && live == 3) {//Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
                    board[i][j] = 2;  // dead → live
                }
            }
        }

        // Second pass: normalize
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] > 0) board[i][j] = 1;
                else board[i][j] = 0;
            }
        }
    }
}

```
