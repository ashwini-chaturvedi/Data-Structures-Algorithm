You are given an n x n grid representing a field of cherries, each cell is one of three possible integers.

0 means the cell is empty, so you can pass through,
1 means the cell contains a cherry that you can pick up and pass through, or
-1 means the cell contains a thorn that blocks your way.
Return the maximum number of cherries you can collect by following the rules below:

Starting at the position (0, 0) and reaching (n - 1, n - 1) by moving right or down through valid path cells (cells with value 0 or 1).
After reaching (n - 1, n - 1), returning to (0, 0) by moving left or up through valid path cells.
When passing through a path cell containing a cherry, you pick it up, and the cell becomes an empty cell 0.
If there is no valid path between (0, 0) and (n - 1, n - 1), then no cherries can be collected.
 

Example 1:

![img](https://assets.leetcode.com/uploads/2020/12/14/grid.jpg)

Input: grid = [[0,1,-1],[1,0,-1],[1,1,1]]

Output: 5

Explanation: The player started at (0, 0) and went down, down, right right to reach (2, 2).
4 cherries were picked up during this single trip, and the matrix becomes [[0,1,-1],[0,0,-1],[0,0,0]].
Then, the player went left, up, up, left to return home, picking up one more cherry.
The total number of cherries picked up is 5, and this is the maximum possible.

# Solution

That is why Cherry Pickup uses the famous "two people moving simultaneously" DP transformation.

### Instead of thinking:

- Person goes down-right
then
- Person comes up-left

### Reverse the second journey conceptually:

- Person 1: (0,0) → (n-1,n-1)
- Person 2: (0,0) → (n-1,n-1)

### Both move simultaneously.

If their positions are:

- Person 1 = (r1, c1)
- Person 2 = (r2, c2)

after the same number of steps:

For any cell (row, col), the number of steps taken from (0,0) is:

- steps=row+col

So for Person 1 at (r1, c1):

- steps=r1+c1

For Person 2 at (r2, c2):

- steps=r2+c2

Because they move simultaneously, they have always taken the same number of steps:
- r1 + c1 = r2 + c2

Therefore:Now rearrange to find c2:

- c2 = r1 + c1 - r2

So you only need 3 changing variables:

```java
class Solution {
    public int solve(int[][] grid,int r1,int c1,int r2,int[][][] dp){

        int c2=r1+c1-r2;//this is important this helps to calculate new row

        if(r1>=grid.length || c1>=grid[0].length || r2>=grid.length || c2>=grid[0].length || c2<0){
            return Integer.MIN_VALUE;
        }

        if((grid[r1][c1]==-1) || (grid[r2][c2]==-1)) return Integer.MIN_VALUE;
        

        if(r1==grid.length-1 && c1==grid[0].length-1) return grid[r1][c1];
        
        if(dp[r1][c1][r2]!=-1) return dp[r1][c1][r2];

        int cherries=0;
        if((r1==r2 && c1==c2)){
            cherries= grid[r1][c1];  
        }else{
            cherries=grid[r1][c1]+grid[r2][c2];
        }

        int bothDown=solve(grid,r1+1,c1,r2+1,dp);
        int firstDownSecRight=solve(grid,r1+1,c1,r2,dp);
        int firstRightSecDown=solve(grid,r1,c1+1,r2+1,dp);
        int bothRight=solve(grid,r1,c1+1,r2,dp);

        return dp[r1][c1][r2]= cherries+(Math.max(Math.max(bothDown,firstDownSecRight),Math.max(firstRightSecDown,bothRight)));
    }
    
    public int cherryPickup(int[][] grid) {
        int[][][] dp=new int[grid.length][grid[0].length][grid.length];

        for(int[][] d:dp){
            for(int[] p:d){
                Arrays.fill(p,-1);
            }
        }

        int res= solve(grid,0,0,0,dp);
        return Math.max(0,res);
    }
}
```
