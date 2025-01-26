You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.

A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.

Return the minimum effort required to travel from the top-left cell to the bottom-right cell.

![image](https://assets.leetcode.com/uploads/2020/10/04/ex3.png)

Input: heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
Output: 0
Explanation: This route does not require any effort.

```java
class Solution {

    // Method to check if a cell is within the grid boundaries
    public boolean isValid(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }

    // Method to find the minimum effort path using Dijkstra's Algorithm
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length; // Number of rows
        int n = heights[0].length; // Number of columns

        // Possible directions (up, down, left, right)
        int[][] directions = {
            { 0, 1 },   // Move right
            { 1, 0 },   // Move down
            { -1, 0 },  // Move up
            { 0, -1 }   // Move left
        };

        // Min-heap (priority queue) to store {row, column, effort}
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        // `res` array to store the minimum effort required to reach each cell
        int[][] res = new int[m][n];
        for (int[] nums : res) {
            Arrays.fill(nums, Integer.MAX_VALUE); // Initialize with maximum value
        }

        // Start from the top-left corner (0, 0) with an initial effort of 0
        minHeap.add(new int[] { 0, 0, 0 });
        res[0][0] = 0;

        // Process the heap until it's empty
        while (!minHeap.isEmpty()) {
            // Get the cell with the smallest effort
            int[] curr = minHeap.poll();
            int i = curr[0]; // Current row
            int j = curr[1]; // Current column
            int dist = curr[2]; // Current effort to reach this cell

            // If we have reached the bottom-right corner, return the minimum effort
            if (i == m - 1 && j == n - 1) return dist;

            // Explore all 4 possible directions
            for (int[] dir : directions) {
                int newI = i + dir[0]; // New row
                int newJ = j + dir[1]; // New column

                // Check if the new cell is valid
                if (isValid(heights, newI, newJ)) {
                    // Calculate the effort required to move to the new cell
                    int absDiff = Math.abs(heights[newI][newJ] - heights[i][j]);
                    int efforts = Math.max(dist, absDiff); // Maximum effort so far

                    // Update if the new effort is less than the previously recorded effort
                    if (efforts < res[newI][newJ]) {
                        res[newI][newJ] = efforts; // Update the minimum effort
                        minHeap.add(new int[] { newI, newJ, efforts }); // Add the new cell to the heap
                    }
                }
            }
        }
        return 0; // This line will never be reached since a path always exists
    }
}

```
