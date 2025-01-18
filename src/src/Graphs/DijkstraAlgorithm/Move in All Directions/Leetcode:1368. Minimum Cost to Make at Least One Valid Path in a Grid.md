# Without Comments & Using Array in PriorityQueue
```java
class Solution {

    public boolean isValid(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }

    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] Directions = {//Maintain the Sequece of movement same as that given in Question is Right->Left->Down->Up
            { 0, 1 }, //Move Right=1
            { 0, -1 }, //Move Left=2
            { 1, 0 }, //Move Down=3
            { -1, 0 } //Move Up=4
        };

        int[][] costs = new int[m][n];

        for (int[] cost : costs) {
            Arrays.fill(cost, Integer.MAX_VALUE);
        }
        costs[0][0] = 0;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        minHeap.add(new int[] { 0, 0, 0 });

        while (!minHeap.isEmpty()) {
            int[] Current = minHeap.poll();
            int currRow = Current[0];
            int currCol = Current[1];
            int currCost = Current[2];

            if (currRow == m - 1 && currCol == n - 1) return currCost;

            if (costs[currRow][currCol] < currCost) continue;

            for (int currDirection = 1; currDirection <= 4; currDirection++) {
                int newRow = currRow + Directions[currDirection - 1][0];
                int newCol = currCol + Directions[currDirection - 1][1];

                if (isValid(grid, newRow, newCol)) {
                    int newCost = currCost + (grid[currRow][currCol] == currDirection ? 0 : 1);

                    if (newCost < costs[newRow][newCol]) {
                        costs[newRow][newCol] = newCost;
                        minHeap.add(new int[] { newRow, newCol, newCost });
                    }
                }
            }
        }
        return -1;
    }
}

```
# With Comments & Using Class Type in PriorityQueue
```java
class Tuple {
    int row;
    int col;
    int cost;
    Tuple(int row, int col, int cost) {
        this.row = row;
        this.col = col;
        this.cost = cost;
    }
}

class Solution {
    public boolean isValid(int[][] grid,int i,int j){
        return i>=0 && i<grid.length && j>=0 && j<grid[0].length;
    }

    public int minCost(int[][] grid) {
        int[][] directions = { 
                { 0, 1 }, //Move Right=1
                { 0, -1 }, //Move Left=2
                { 1, 0 }, //Move Down=3
                { -1, 0 } //Move Up=4
            };

        int[][] costs = new int[grid.length][grid[0].length];//To Store the Cost to Reach every node from Every Path to every node from 0 in the Grid.

        for (int[] cost : costs) {//This is Like the Result array in Normal Dijkstra
            Arrays.fill(cost, Integer.MAX_VALUE);
        }
        costs[0][0] = 0; //Starting Cost to is Zero for Source


        // Diretly Applying Dijkstra Algorithm on the Grid Without making a Graph.
        PriorityQueue<Tuple> minHeap = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        minHeap.add(new Tuple(0, 0, 0));
        

        while (!minHeap.isEmpty()) {
            Tuple curr = minHeap.poll();
            int currRow = curr.row;
            int currCol = curr.col;
            int currCost = curr.cost;

            if (currRow == grid.length - 1 && currCol == grid[0].length - 1) {//If Reached the Destination means we have Make a Valid Path to Reach the Destination at currCost so return the currCost.
                return currCost;
            }

            // If the current cost to reach a Node is Already Larger then what we still have just ignore that because we want to make the Path in Minimum Cost
            if (currCost > costs[currRow][currCol]) continue;


            for (int currDir = 1; currDir <= 4; currDir++) { //There are Four Directions:
                // 1->Right,2->Left,3->Down,4->Up.

                int newCurrRow = currRow + directions[currDir - 1][0]; //Minus 1 because directions is a 0 based Indexing
                int newCurrCol = currCol + directions[currDir - 1][1];

                if (isValid(grid, newCurrRow, newCurrCol)) {

                    int newCurrCost = currCost + (grid[currRow][currCol] == currDir ? 0 : 1); //this Indicates that new direction is same as the previous direction so no extra cost is required but if it isn't same cost=1 is required to change the direction.

                    if (newCurrCost < costs[newCurrRow][newCurrCol]) {
                        minHeap.add(new Tuple(newCurrRow, newCurrCol, newCurrCost));
                        costs[newCurrRow][newCurrCol] = newCurrCost;//Store the New Smaller Cost
                    }
                }
            }
        }
        return -1;
    }
}

```
