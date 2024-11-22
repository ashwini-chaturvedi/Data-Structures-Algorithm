```java
class Solution {

    //Use a Queue to Store the Co-ordinate and distance of all the 0 cells
    //Then Traverse the Queue and Increase the Distance as you move in a direction
    //Use a 2D Array to Store that wheather a cell is visited or Not.

    public boolean isValid(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }

    public int[][] updateMatrix(int[][] grid) {
        Queue<int[]> que = new LinkedList<>(); //Using the Queue to Store.
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    que.add(new int[] { i, j, 0 }); //Storing the Co-ordinates of zero cells
                    visited[i][j] = true; //mark it true
                }
            }
        }

        //traverse the Queue

        int[][] directions = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

        int[][] res = new int[grid.length][grid[0].length];

        while (!que.isEmpty()) {
            int[] curr = que.poll();
            int x = curr[0];
            int y = curr[1];
            int dist = curr[2];

            res[x][y] = dist; //Put the Distance or Update the Matrix

            for (int[] dir : directions) { //Move in all the Adjacent cells.
                int newI = x + dir[0];
                int newJ = y + dir[1];

                if (isValid(grid, newI, newJ) && !visited[newI][newJ]) { //if it is in Bound and it is not visited.
                    que.add(new int[] { newI, newJ, dist + 1 }); //Increase the Distance... and Store its Distance in the Queue for Future Use...
                    visited[newI][newJ] = true;
                }
            }
        }
        return res;
    }
}

```
