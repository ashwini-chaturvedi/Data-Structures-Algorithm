```java
class Tuple {
    int row;
    int col;
    int len;

    Tuple(int row, int col, int l) {
        this.row = row;
        this.col = col;
        this.len = l;
    }
}

class Solution {
    public boolean isValid(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid.length== 0 || grid[0][0] == 1)// if the Starting point is 1 then we cannot move to any other cell because we can only move on cells that have 0.
            return -1;

        int[][] directions = {//Move in All 8 Directions
                { 1, 0 },
                { 0, 1 },
                { -1, 0 },
                { 0, -1 },
                { -1, -1 },
                { -1, 1 },
                { 1, -1 },
                { 1, 1 }
        };

        int[][] lengths = new int[grid.length][grid.length];//to store the shortest length

        for (int[] len : lengths) {
            Arrays.fill(len, Integer.MAX_VALUE);
        }
        lengths[0][0] = 0;

        PriorityQueue<Tuple> minHeap = new PriorityQueue<>((a, b) -> a.len - b.len);
        minHeap.add(new Tuple(0, 0, 0));

        while (!minHeap.isEmpty()) {
            Tuple curr = minHeap.poll();
            int currRow = curr.row;
            int currCol = curr.col;
            int currLen = curr.len;

            if (currRow == grid.length - 1 && currCol == grid.length - 1) {//Reached the Destination.
                return currLen + 1;//Increase the Length by 1
            }

            if (currLen > lengths[currRow][currCol])// if the Current Length is greater then the already available shortest path so ignore it because we want to calculate shortest Path
                continue;

            for (int[] dir : directions) {
                int newCurrRow = currRow + dir[0];
                int newCurrCol = currCol + dir[1];

                if (isValid(grid, newCurrRow, newCurrCol) && grid[newCurrRow][newCurrCol] == 0) {//Can Only move to cells which have 0
                    minHeap.add(new Tuple(newCurrRow, newCurrCol, currLen + 1));
                    grid[newCurrRow][newCurrCol] = 1;//Mark the Cell as 1 so that we cannot visit it again...
                    lengths[newCurrRow][newCurrCol] = currLen + 1;//Moved to a new cell Increase the length...
                }
            }
        }
        return -1;
    }
}
```
