```java
class Solution {

    // Helper function to check if the coordinates (i, j) are within the grid boundaries
    public boolean isValid(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }

    // Depth-First Search (DFS) function to explore an island and check if it's closed
    public boolean walk(int[][] grid, int i, int j, int[][] directions) {
        // If the cell is out of bounds or is already visited (i.e., water), return true (indicating the island is closed)
        if (!isValid(grid, i, j) || grid[i][j] == 1) return true;

        // Mark the current land cell as visited (1)
        grid[i][j] = 1;

        // Assume the island is closed unless we find a boundary (this will be modified)
        boolean isClosed = true;

        // Explore all four directions (up, right, down, left)
        for (int[] dir : directions) {
            int newI = i + dir[0]; // Calculate the new row index
            int newJ = j + dir[1]; // Calculate the new column index

            // If the new cell is out of bounds, it means the island touches the boundary, so it's not closed
            if (!isValid(grid, newI, newJ)) {
                isClosed = false;
            } 
            // If the new cell is land (0), recursively explore it
            else if (grid[newI][newJ] == 0) {
                isClosed &= walk(grid, newI, newJ, directions); // Keep the "isClosed" state as true only if all connected cells are closed
            }
        }
        
        // Return whether the current island is closed
        return isClosed;
    }

    // Main function to count the number of closed islands in the grid
    public int closedIsland(int[][] grid) {
        // Directions array to explore neighboring cells: up, right, down, left
        int[][] directions = { 
                                { -1, 0 }, // up
                                { 0, 1 },  // right
                                { 1, 0 },  // down
                                { 0, -1 }  // left
                            };

        int islands = 0; // Variable to count the number of closed islands

        // Iterate over all cells in the grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // If we find a land cell (0), we start exploring
                if (grid[i][j] == 0) {
                    // If the island formed by this land is closed, increment the island count
                    if (walk(grid, i, j, directions)) {
                        islands++;
                    }
                }
            }
        }
        
        // Return the total number of closed islands
        return islands;
    }
}

```
