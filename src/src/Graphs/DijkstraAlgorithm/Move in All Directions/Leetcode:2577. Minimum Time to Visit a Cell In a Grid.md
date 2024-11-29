```java
class Trio {
    int row;
    int col;
    int Time;

    Trio(int r, int c, int t) {
        row = r;
        col = c;
        Time = t;
    }
}

class Solution {

    public boolean isValid(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }

    public int Dijkstra_MoveInAllDirection(int[][] grid, int[][] directions) {
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];

        PriorityQueue<Trio> minHeap = new PriorityQueue<>((a, b) -> a.Time - b.Time);
        minHeap.add(new Trio(0, 0, 0));

        while (!minHeap.isEmpty()) {
            Trio curr = minHeap.poll();
            int row = curr.row;
            int col = curr.col;
            int Time = curr.Time;

            if (row == grid.length - 1 && col == grid[0].length - 1) return Time;

            if (isVisited[row][col]) continue;
            isVisited[row][col] = true;

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (isValid(grid, newRow, newCol) && !isVisited[newRow][newCol]) {
                    if (grid[newRow][newCol] <= Time + 1) {//When new Cell value is just 1 greater than current Time move to it because when you move you will increase the time by one and the value will now be equal to time.
                        minHeap.add(new Trio(newRow, newCol, Time + 1));
                    } else if ((grid[newRow][newCol] - Time) % 2 == 0) {
/*When the wait time(difference b/w currTime and Time to Move to the next Cell) is Even then while we were wasting time in to&fro movement we will reach the node at newRow and newCol just 1 second after its value e.g if we are at grid[row][col]==1 and grid[newRow][newCol]==11 ,so the difference will be 10 and when we do to and fro movement between grid[row][col] and grid[prevRow][prevCol] we will again reach the grid[row][col] at 11 and move to grid[newRow][newCol] at time =12 which is just 1 greater than grid[newRow][newCol]
    if(diff==Even) Time=grid[newRow][newCol]+1 Reached one more then Required Time to Reach  this Cell
*/
                        minHeap.add(new Trio(newRow, newCol, grid[newRow][newCol] + 1));
                    } else {
/*When the wait time(difference b/w currTime and Time to Move to the next Cell) is Odd then while we were wasting time in to&fro movement we will reach the node at newRow and newCol just at its value e.g if we are at grid[row][col]==1 and grid[newRow][newCol]==10 ,so the difference will be 9 and when we do to and fro movement between grid[row][col] and grid[prevRow][prevCol] we will again reach the grid[row][col] at 9 and move to grid[newRow][newCol] at time =10 which is just equal to grid[newRow][newCol]
    if(diff==Odd) Time=grid[newRow][newCol] Reached Just on Required Time to Reach this cell.
*/                       
                        minHeap.add(new Trio(newRow, newCol, grid[newRow][newCol]));
                    }
                }
            }
        }
        return -1;
    }

    public int minimumTime(int[][] grid) {
        int[][] directions = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

        if (grid[0][0] != 0) return -1;

        // If the immediate neighbors of the start point are both inaccessible, return -1
        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }

        return Dijkstra_MoveInAllDirection(grid, directions);
    }
}

```

```java
class Trio {
    int row;
    int col;
    int Time;

    Trio(int r, int c, int t) {
        row = r;
        col = c;
        Time = t;
    }
}

class Solution {

    public boolean isValid(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }

    public int Dijkstra_MoveInAllDirection(int[][] grid, int[][] directions) {
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        isVisited[0][0] = true;

        PriorityQueue<Trio> minHeap = new PriorityQueue<>((a, b) -> a.Time - b.Time);
        minHeap.add(new Trio(0, 0, 0));

        while (!minHeap.isEmpty()) {
            Trio curr = minHeap.poll();
            int row = curr.row;
            int col = curr.col;
            int Time = curr.Time;

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (isValid(grid, newRow, newCol) && !isVisited[newRow][newCol]) {
                    int newTime = Time + 1;
                    if (grid[newRow][newCol] > newTime) {
                        int diff = grid[newRow][newCol] - newTime + 1;
                        int waitTime = (diff / 2) * 2;
                        newTime += waitTime;
                    }

                    if (newRow == grid.length - 1 && newCol == grid[0].length - 1) {
                        return newTime;
                    }

                    isVisited[newRow][newCol] = true;
                    minHeap.add(new Trio(newRow, newCol, newTime));
                }
            }
        }
        return -1;
    }

    public int minimumTime(int[][] grid) {
        int[][] directions = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

        if (grid[0][0] != 0) return -1;

        // If the immediate neighbors of the start point are both inaccessible, return -1
        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }

        return Dijkstra_MoveInAllDirection(grid, directions);
    }
}

```
