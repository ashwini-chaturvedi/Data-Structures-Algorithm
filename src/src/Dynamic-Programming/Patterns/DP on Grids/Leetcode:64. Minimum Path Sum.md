# Recursion + Memoization
```java
class Solution {

    public int dpOnGrid(int[][] grid, int i, int j, int[][] directions,int[][] memoiz) {
        if (i >= grid.length || j >= grid[0].length) return Integer.MAX_VALUE;//if out of bound return maximum number so that when we calculate answer we cannot consider it

        if (i == grid.length - 1 && j == grid[0].length - 1) return grid[i][j];

        if(memoiz[i][j]!=-1){
            return memoiz[i][j];
        }

        int rightPathSum = dpOnGrid(grid, i, j + 1, directions,memoiz);
        int leftPathSum = dpOnGrid(grid, i + 1, j, directions,memoiz);

        return memoiz[i][j]=grid[i][j] + Math.min(rightPathSum, leftPathSum);
    }

    public int minPathSum(int[][] grid) {
        int[][] directions = { { 0, 1 }, { 1, 0 } };

        int[][] memoiz=new int[grid.length+1][grid[0].length+1];

        for(int[] memo:memoiz){
            Arrays.fill(memo,-1);
        }

        return dpOnGrid(grid, 0, 0, directions,memoiz);
    }
}

```
# Bottom-Up
```java
class Solution {
    public int minPathSum(int[][] grid) {      
         
        int[][] dp=new int[grid.length+1][grid[0].length+1];

        dp[0][0]=grid[0][0];//Starting sum is the value at cell

        //Now we do the Initialization with Prefix Sum because as we move right or down on the starting indexes it will give the values of Prefix sum DO DRY RUN WITH EXAMPLE
        
        for(int i=1;i<grid.length;i++){
            dp[i][0]=grid[i][0]+dp[i-1][0];
        }
        for(int j=1;j<grid[0].length;j++){
            dp[0][j]=grid[0][j]+dp[0][j-1];
        }

        //Now Calculate the Answer using the Inisilization cells...
        for(int i=1;i<grid.length;i++){
            for(int j=1;j<grid[0].length;j++){

                int up=grid[i][j]+dp[i-1][j];//Down Movement will take value from up cell
                int left=grid[i][j]+dp[i][j-1];//right movement will take value from left cell

                dp[i][j]=Math.min(up,left);//Minimum between both
            }
        }
        return dp[grid.length-1][grid[0].length-1];//return ans...
    }
}

```
