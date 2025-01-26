Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.

A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

All the visited cells of the path are 0.
All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
The length of a clear path is the number of visited cells of this path.

Example 2:


![image](https://assets.leetcode.com/uploads/2021/02/18/example2_1.png)

Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
Output: 4

# BFS
```java
class Solution {

    // Method to check if a cell is within the grid boundaries
    public boolean isValid(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }

    // Method to find the shortest path in a binary matrix
    public int shortestPathBinaryMatrix(int[][] grid) {
        // If the starting cell is blocked, return -1 as no path is possible
        if (grid[0][0] == 1) return -1;

        // Directions for 8 possible moves (up, down, left, right, and diagonals)
        int[][] directions = { 
            { 0, 1 },  // Move right
            { 1, 0 },  // Move down
            { -1, 0 }, // Move up
            { 0, -1 }, // Move left
            { -1, -1 },// Move diagonally up-left
            { 1, 1 },  // Move diagonally down-right
            { 1, -1 }, // Move diagonally down-left
            { -1, 1 }  // Move diagonally up-right
        };

        // Queue to perform Breadth-First Search (BFS)
        // Each element in the queue represents {row, column, current distance}
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] { 0, 0, 0 }); // Start from the top-left cell
        grid[0][0] = 1; // Mark the starting cell as visited

        int level = 1; // Represents the path length from the start

        // BFS loop to explore all paths
        while (!que.isEmpty()) {
            int size = que.size(); // Number of elements at the current BFS level

            // Process all cells in the current level
            for (int k = 0; k < size; k++) {
                int[] curr = que.poll(); // Get the current cell
                int i = curr[0];
                int j = curr[1];
                int dist = curr[2];

                // If we have reached the bottom-right corner, return the current level
                if (i == grid.length - 1 && j == grid[0].length - 1) return level;

                // Explore all 8 possible directions
                for (int[] dir : directions) {
                    int newI = i + dir[0];
                    int newJ = j + dir[1];

                    // Check if the new cell is valid and not visited
                    if (isValid(grid, newI, newJ) && grid[newI][newJ] == 0) {
                        que.add(new int[] { newI, newJ, dist + 1 }); // Add new cell to the queue
                        grid[newI][newJ] = 1; // Mark as visited
                    }
                }
            }

            // Increment the level after processing all cells at the current level
            level++;
        }

        // If no path is found, return -1
        return -1;
    }
}

```

# Dijkstra 
```java
class Solution {

    // Method to check if a cell is within the grid boundaries
    public boolean isValid(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }

    // Method to find the shortest path in a binary matrix using Dijkstra's Algorithm
    public int shortestPathBinaryMatrix(int[][] grid) {
        // If the starting cell is blocked, return -1 as no path is possible
        if (grid[0][0] == 1) return -1;

        // Define all 8 possible directions (up, down, left, right, and diagonals)
        int[][] directions = {
            { 0, 1 }, // Move right
            { 1, 0 }, // Move down
            { -1, 0 }, // Move up
            { 0, -1 }, // Move left
            { -1, -1 }, // Move diagonally up-left
            { 1, 1 }, // Move diagonally down-right
            { 1, -1 }, // Move diagonally down-left
            { -1, 1 } // Move diagonally up-right
        };

        // Min-heap (priority queue) for Dijkstra's Algorithm
        // Stores {row, column, distance from the start}
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        // `res` array to store the minimum distance to each cell from the start
        int[][] res = new int[grid.length][grid[0].length];
        for (int[] nums : res) {
            Arrays.fill(nums, Integer.MAX_VALUE); // Initialize with maximum value
        }

        // Add the starting cell to the heap with a distance of 0
        minHeap.add(new int[] { 0, 0, 0 });
        res[0][0] = 0; // Distance to the starting cell is 0
        grid[0][0] = 1; // Mark the starting cell as visited

        // Process the heap until it's empty
        while (!minHeap.isEmpty()) {
            // Get the cell with the smallest distance
            int[] curr = minHeap.poll();
            int i = curr[0]; // Current row
            int j = curr[1]; // Current column
            int dist = curr[2]; // Distance from the start

            // Explore all 8 possible directions
            for (int[] dir : directions) {
                int newI = i + dir[0]; // New row
                int newJ = j + dir[1]; // New column

                // Check if the new cell is valid and not visited
                if (isValid(grid, newI, newJ) && grid[newI][newJ] == 0) {
                    // Add the new cell to the heap with an updated distance
                    minHeap.add(new int[] { newI, newJ, dist + 1 });
                    res[newI][newJ] = dist + 1; // Update the distance to this cell
                    grid[newI][newJ] = 1; // Mark the cell as visited
                }
            }
        }

        // If the bottom-right corner is unreachable, return -1
        // Otherwise, return the shortest distance to the bottom-right corner + 1 (for starting point)
        return res[grid.length - 1][grid[0].length - 1] == Integer.MAX_VALUE ? -1 : res[grid.length - 1][grid[0].length - 1] + 1;
    }
}

```
