You are given an integer matrix isWater of size m x n that represents a map of land and water cells.

If isWater[i][j] == 0, cell (i, j) is a land cell.
If isWater[i][j] == 1, cell (i, j) is a water cell.
You must assign each cell a height in a way that follows these rules:

The height of each cell must be non-negative.
If the cell is a water cell, its height must be 0.
Any two adjacent cells must have an absolute height difference of at most 1. A cell is adjacent to another cell if the former is directly north, east, south, or west of the latter (i.e., their sides are touching).
Find an assignment of heights such that the maximum height in the matrix is maximized.

Return an integer matrix height of size m x n where height[i][j] is cell (i, j)'s height. If there are multiple solutions, return any of them.

 

Example 1:
![image](https://assets.leetcode.com/uploads/2021/01/10/screenshot-2021-01-11-at-82050-am.png)

Input: isWater = [[0,0,1],[1,0,0],[0,0,0]]

Output: [[1,1,0],[0,1,1],[1,2,2]]

Explanation: A height of 2 is the maximum possible height of any assignment.
Any height assignment that has a maximum height of 2 while still meeting the rules will also be accepted.

#DFS TLE
```java
class Solution {

    // Function to check if the given cell (i, j) is within the grid boundaries
    public boolean isValid(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }

    // Depth First Search (DFS) function to calculate the minimum distance to water
    public void DFS(int[][] isWater, int i, int j, int[][] res, boolean[][] isVisited, int[][] directions) {
        // Iterate over all possible 4 directions (up, down, left, right)
        for (int[] dir : directions) {
            int newI = i + dir[0]; // Calculate new row index
            int newJ = j + dir[1]; // Calculate new column index

            // Check if the new cell is valid and has not been visited yet
            if (isValid(isWater, newI, newJ) && !isVisited[newI][newJ]) {
                // If the current path offers a shorter distance, update the result
                if (res[newI][newJ] > res[i][j] + 1) {
                    res[newI][newJ] = res[i][j] + 1; // Update the distance
                    isVisited[newI][newJ] = true;    // Mark the cell as visited
                    DFS(isWater, newI, newJ, res, isVisited, directions); // Recurse to explore further
                    isVisited[newI][newJ] = false; // Backtrack by marking the cell as unvisited
                }
            }
        }
    }

    // Main function to compute the height of the highest peak for the grid
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;    // Number of rows in the grid
        int n = isWater[0].length; // Number of columns in the grid
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // Possible movement directions

        // Initialize the result grid with Integer.MAX_VALUE (indicating unvisited)
        int[][] res = new int[m][n];
        for (int[] r : res) {
            Arrays.fill(r, Integer.MAX_VALUE);
        }

        // Boolean array to track visited cells during DFS
        boolean[][] visited = new boolean[m][n];

        // Loop through all cells in the grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If the cell represents water (value 1), initialize its distance
                if (isWater[i][j] == 1) {
                    visited[i][j] = true; // Mark the cell as visited
                    res[i][j] = 0;       // Water cells have height 0
                    DFS(isWater, i, j, res, visited, directions); // Perform DFS from this cell
                }
            }
        }

        return res; // Return the final result grid
    }
}

```

# BFS
```java
class Solution {

    // Method to check if a cell (i, j) is within the grid boundaries
    public boolean isValid(int m, int n, int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }

    public int[][] highestPeak(int[][] isWater) {
        // Dimensions of the grid
        int m = isWater.length;
        int n = isWater[0].length;

        // Directions for moving in the grid (right, down, left, up)
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        // Resultant grid to store the heights
        int[][] result = new int[m][n];
        // Queue to perform BFS
        Queue<int[]> que = new LinkedList<>();
        // Visited array to avoid revisiting cells
        boolean[][] visited = new boolean[m][n];

        // Initialize the queue with all water cells and mark them as visited
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) { // If the cell is water
                    que.add(new int[] { i, j, 0 }); // Add the cell with initial distance 0
                    visited[i][j] = true; // Mark as visited
                }
            }
        }

        // Perform BFS to calculate heights
        while (!que.isEmpty()) {
            int[] curr = que.poll(); // Dequeue the current cell
            int x = curr[0]; // Row index
            int y = curr[1]; // Column index
            int dist = curr[2]; // Current distance

            // Update the height of the current cell
            result[x][y] = dist;

            // Explore all 4 possible directions
            for (int[] dir : directions) {
                int newX = x + dir[0]; // New row index
                int newY = y + dir[1]; // New column index

                // Check if the new cell is valid and not visited
                if (isValid(m, n, newX, newY) && !visited[newX][newY]) {
                    // Add the new cell to the queue with incremented distance
                    que.add(new int[] { newX, newY, dist + 1 });
                    // Mark the new cell as visited
                    visited[newX][newY] = true;
                }
            }
        }
        // Return the resultant grid with heights
        return result;
    }
}

```
