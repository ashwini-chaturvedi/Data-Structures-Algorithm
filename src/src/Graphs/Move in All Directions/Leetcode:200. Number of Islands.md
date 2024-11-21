```java
class Solution {
    public boolean isValid(char[][] grid,int i,int j){
        return i>=0 && i<grid.length&& j>=0 && j<grid[0].length;
    }

    public void coverIsland(char[][] grid,int i,int j,int[][]directions){
        if(!isValid(grid,i,j) || grid[i][j]=='0') return;

        grid[i][j]='0';

        for(int[] dir:directions){
            int newI=i+dir[0];
            int newJ=j+dir[1];

            if(isValid(grid,newI,newJ) && grid[newI][newJ]=='1'){
                coverIsland(grid,newI,newJ,directions);
            }
        }
    }
    
    public int numIslands(char[][] grid) {
        int[][]directions={
            {-1,0},
            {0,1},
            {1,0},
            {0,-1}
        };
        int count=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    coverIsland(grid,i,j,directions);
                    count++;
                }
            }
        }
        return count;
    }
}
```
