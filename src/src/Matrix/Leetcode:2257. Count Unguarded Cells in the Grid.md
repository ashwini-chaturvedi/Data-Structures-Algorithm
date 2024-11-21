```java
class Solution {

    public void mark(int x, int y, int[][] grid, int[][] directions) {

        for (int[] dir : directions) {//move to a direction
            int newX = x + dir[0];
            int newY = y + dir[1];

            while (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] != 1 && grid[newX][newY] != 2) {
                //if that particular direction is giving valid results then simply go to that direction 
                //means if previously we were going in up direction and it is valid then start only to move in up direction this way all the cells in up will get marked.
                grid[newX][newY] = 3;

                //Start Moving in same direction...
                newX += dir[0];
                newY += dir[1];
            }
        }
    }

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        // Direction vectors for up, down, left, right
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        //Mark all the Walls
        for (int[] wall : walls) {
            int x = wall[0];
            int y = wall[1];

            grid[x][y] = 1; //1->wall
        }
        //Mark all the Guards
        for (int[] guard : guards) {
            int x = guard[0];
            int y = guard[1];

            grid[x][y]=2;
        }
        //Then Mark all the viewing points by Guards...
        for (int[] guard : guards) {
            int x = guard[0];
            int y = guard[1];

            mark(x, y, grid,directions);
        }

        //Count the Cells that are Empty...
        int count = 0;
        for (int[] cells : grid) {
            for (int cell : cells) {
                if (cell == 0) count++;
            }
        }
        return count;
    }
}

```
