You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,

1 representing a fresh orange, or

2 representing a rotten orange.

Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

Example 1:

![image](https://assets.leetcode.com/uploads/2019/02/16/oranges.png)

Input: grid = [[2,1,1],[1,1,0],[0,1,1]]

Output: 4

# Why Multi-Source BFS not DFS in all Directions?
  ```java
Nature of the Problem: Parallel Spread
In the Rotting Oranges problem, multiple rotten oranges can spread the rot simultaneously to their neighbors during the same minute. This is inherently a parallel process.
DFS is inherently sequential, processing one path fully before moving to another. It doesn't handle simultaneous propagation naturally.
For example, consider this grid:

[2, 1, 1]
[1, 1, 0]
[0, 1, 1]
At time t = 0, orange (0, 0) starts spreading.
Using DFS, you explore one path completely (e.g., (0, 0) → (0, 1) → (0, 2)), which takes 3 minutes sequentially, even though multiple neighboring oranges could rot simultaneously in 1 minute.
With BFS, you process all neighbors of (0, 0) in the same minute, ensuring that time is tracked correctly.


 Steps to Solve:
    Identify initial rotten oranges:

    Add all initially rotten oranges (2) to a queue, along with their time (starting at 0 minutes).
    Process the queue:

    For each orange in the queue, try to rot its neighboring fresh oranges (1).
    Add these newly rotted oranges to the queue with an incremented time.
  ```

```java
class Solution {

    public int orangesRotting(int[][] grid) {
        Queue<int[]> que = new LinkedList<>();//To Store the time and co-ordinates of all the Rotten Oranges...
        int freshOranges = 0;//Count all the Fresh Oranges 

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {//When Found a Rotten Orange keep it in a queue with a time variable
                    que.add(new int[] { i, j, 0 });
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        //Process the Queue
        int[][] directions ={ 
                                { -1, 0 }, 
                                { 0, 1 }, 
                                { 1, 0 }, 
                                { 0, -1 } 
                            };

        int minutes = 0;

        while (!que.isEmpty()) {
            int[] curr = que.poll();
            int x = curr[0];
            int y = curr[1];
            int time = curr[2];
            minutes = Math.max(minutes, time);//Maximum Time Taken

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == 1) {
                    que.add(new int[] { newX, newY, time + 1 }); //Add to the Queue
                    grid[newX][newY] = 2; //Rot the Fresh Orange at (newX,newY)
                    freshOranges--; //Decrease the number of freshOranges...
                }
            }
        }
        return freshOranges == 0 ? minutes : -1;
    }
}

```
