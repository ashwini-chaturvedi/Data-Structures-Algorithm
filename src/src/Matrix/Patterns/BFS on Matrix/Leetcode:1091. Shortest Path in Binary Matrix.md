Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.

A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

All the visited cells of the path are 0.
All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
The length of a clear path is the number of visited cells of this path.

 

Example 1:
![](https://assets.leetcode.com/uploads/2021/02/18/example2_1.png)

Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
Output: 4

```java
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1) return -1;

        int[][] directions={{1,0},{0,1},{0,-1},{-1,0},{1,1},{-1,-1},{-1,1},{1,-1}};

        Queue<int[]>que=new LinkedList<>();
        que.add(new int[]{0,0,0});
        grid[0][0]=1;
        int len=1;

        while(!que.isEmpty()){
            int size=que.size();

            while(size-->0){
                int[] rem=que.poll();
                int x=rem[0];
                int y=rem[1];
                int dis=rem[2];

                if(x==grid.length-1 && y==grid.length-1) return len;

                for(int[] dir:directions){
                    int newX=x+dir[0];
                    int newY=y+dir[1];

                    if(newX>=0 && newX<grid.length && newY>=0 && newY<grid[0].length && grid[newX][newY]!=1){
                        grid[newX][newY]=1;
                        que.add(new int[]{newX,newY,dis+1});
                    }
                }
                
            }
            len++;

        }

        return -1;        
    }
}
```
