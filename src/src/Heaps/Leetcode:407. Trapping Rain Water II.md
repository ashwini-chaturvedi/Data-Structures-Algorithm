# Question

Given an m x n integer matrix heightMap representing the height of each unit cell in a 2D elevation map, return the volume of water it can trap after raining.

![Water Trapping Illustration](https://assets.leetcode.com/uploads/2021/04/08/trap1-3d.jpg "Water Trapping Example")

Input: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
Output: 4
Explanation: After the rain, water is trapped between the blocks.
We have two small ponds 1 and 3 units trapped.
The total volume of water trapped is 4.

```java
class Solution {

    public boolean isValid(int m, int n, int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }

    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;

        int[][] Directions = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]); //Sort according to the Value of Cell i.e. height of the building.
        boolean[][] visited = new boolean[m][n];

        //Add the Boundary Cells into the minHeap which is sorted on the basis of value of Cell.
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (row == 0 || row == m - 1 || col == 0 || col == n - 1) {
                    minHeap.add(new int[] { row, col, heightMap[row][col] });
                    visited[row][col] = true;
                }
            }
        }

        int trappedWater = 0;

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();

            int currI = current[0];
            int currJ = current[1];
            int currHeight = current[2];

            for (int[] dir : Directions) { //Move to all Adjacent Cells.
                int newI = currI + dir[0];
                int newJ = currJ + dir[1];

                if (isValid(m, n, newI, newJ) && !visited[newI][newJ]) { //if the new co-ordinate is valid and the cell is not visited
                    trappedWater += Math.max(currHeight - heightMap[newI][newJ], 0); //if the difference between the height of current Building & height of new Building is Negative then no water can be trapped so plus 0 else the water equals to height difference can be Trapped.

                    minHeap.add(new int[] { newI, newJ, Math.max(currHeight, heightMap[newI][newJ]) }); //Add the new Co-ordinated with the new Height.
                    //the newHeight will be the maximum between the two heights because the height of the smaller building will be filled by water upto the height of the maximum height building.

                    visited[newI][newJ] = true; //Mark it Visited.
                }
            }
        }

        return trappedWater;
    }
}

```
