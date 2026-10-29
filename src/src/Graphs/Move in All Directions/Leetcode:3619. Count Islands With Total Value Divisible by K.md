You are given an m x n matrix grid and a positive integer k. An island is a group of positive integers (representing land) that are 4-directionally connected (horizontally or vertically).

The total value of an island is the sum of the values of all cells in the island.

Return the number of islands with a total value divisible by k.

 

Example 1:

![img](https://assets.leetcode.com/uploads/2025/03/06/example1griddrawio-1.png)

Input: grid = [[0,2,1,0,0],[0,5,0,0,5],[0,0,1,0,0],[0,1,4,7,0],[0,2,0,0,8]], k = 5

Output: 2

Explanation:

The grid contains four islands. The islands highlighted in blue have a total value that is divisible by 5, while the islands highlighted in red do not.

```java
class Solution {
    public long findSum(int[][] grid,int i,int j,int[][] directions){
        if(grid[i][j]==0) return 0;

        long sum=grid[i][j];
        grid[i][j]=0;

        for(int[] dir:directions){
            int newI=i+dir[0];
            int newJ=j+dir[1];

            if(newI>=0 && newI<grid.length && newJ>=0 && newJ<grid[0].length){
                sum+=findSum(grid,newI,newJ,directions);
            }
        }

        return sum;
    }
    public int countIslands(int[][] grid, int k) {
        int[][] directions={
            {1,0},
            {0,1},
            {0,-1},
            {-1,0}
        };

        int count=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]!=0){
                    long res=findSum(grid,i,j,directions);
                    if(res%k==0) count++;
                    
                }
            }
        }

        return count;

    }
}
```
