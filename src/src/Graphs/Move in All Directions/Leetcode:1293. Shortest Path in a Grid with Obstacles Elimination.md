You are given an m x n integer matrix grid where each cell is either 0 (empty) or 1 (obstacle). You can move up, down, left, or right from and to an empty cell in one step.

Return the minimum number of steps to walk from the upper left corner (0, 0) to the lower right corner (m - 1, n - 1) given that you can eliminate at most k obstacles. If it is not possible to find such walk return -1.

 

Example 1:
![img](https://assets.leetcode.com/uploads/2021/09/30/short1-grid.jpg)

Input: grid = [[0,0,0],[1,1,0],[0,0,0],[0,1,1],[0,0,0]], k = 1

Output: 6

Explanation: 
The shortest path without eliminating any obstacle is 10.

The shortest path with one obstacle elimination at position (3,2) is 6. Such path is (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).

```java
class Solution {
    //Simple BFS for Shortest Path: Movement on the Matrix in an Arc way.
    public int shortestPath(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] directions={
            {0,1},
            {1,0},
            {0,-1},
            {-1,0}
        };

        boolean[][][] visited=new boolean[m][n][k+1];
        Queue<int[]>que=new LinkedList<>();
        int steps=0;

        visited[0][0][k]=true;
        que.add(new int[]{0,0,k});

        while(!que.isEmpty()){
            int size=que.size();

            while(size-->0){
                int[] res=que.poll();

                int row=res[0];
                int col=res[1];
                int obstaclesRem=res[2];

                if(row==m-1 && col==n-1){
                    return steps;
                }

                for(int[] dir:directions){//Move in all directions.
                    int newRow=row+dir[0];
                    int newCol=col+dir[1];

                    if(newRow<0 || newRow>=m || newCol<0 || newCol>=n) continue;

                    
                    if(grid[newRow][newCol]==0){
                        if(!visited[newRow][newCol][obstaclesRem]){
                            visited[newRow][newCol][obstaclesRem]=true;
                            que.add(new int[]{newRow,newCol,obstaclesRem});
                        }
                    }else{
                        if(obstaclesRem>0 && !visited[newRow][newCol][obstaclesRem-1]){
                            visited[newRow][newCol][obstaclesRem-1]=true;
                            que.add(new int[]{newRow,newCol,obstaclesRem-1});
                        }
                    }
                }

            }

            steps++;
        } 
        return -1;       
    }
}
```
