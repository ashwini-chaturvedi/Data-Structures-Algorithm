You are given a 0-indexed m x n integer matrix grid and an integer k. You are currently at position (0, 0) and you want to reach position (m - 1, n - 1) moving only down or right.

Return the number of paths where the sum of the elements on the path is divisible by k. Since the answer may be very large, return it modulo 109 + 7.

Example 1:
[img](https://assets.leetcode.com/uploads/2022/08/13/image-20220813183124-1.png)

Input: grid = [[5,2,4],[3,0,5],[0,7,2]], k = 3

Output: 2

Explanation: There are two paths where the sum of the elements on the path is divisible by k.

The first path highlighted in red has a sum of 5 + 2 + 4 + 5 + 2 = 18 which is divisible by 3.

The second path highlighted in blue has a sum of 5 + 3 + 0 + 5 + 2 = 15 which is divisible by 3.

```java
class Solution {
    //There are 3 Moving Parts or Things so we have to use a 3d Memoization for i,j,rem.
    public int dpOnGrids(int[][] grid,int i,int j,int k,int rem,int[][][] memoiz){
        
        if(i>=grid.length || j>=grid[0].length) return 0;

        if(i==grid.length-1 && j==grid[0].length-1){
            return (rem+grid[i][j])%k==0?1:0;
        }

        if(memoiz[i][j][rem]!=-1) return memoiz[i][j][rem];

        int newRem=(rem+grid[i][j])%k;

        int right=dpOnGrids(grid,i,j+1,k,newRem,memoiz);
        int down=dpOnGrids(grid,i+1,j,k,newRem,memoiz);

        return memoiz[i][j][rem]=(right+down)%1000000007;
    }
    public int numberOfPaths(int[][] grid, int k) {
        int[][][] memoiz=new int[grid.length+1][grid[0].length+1][k+1];

        for(int[][] memoz:memoiz){
            for(int[] memo:memoz){
                Arrays.fill(memo,-1);
            }
        }
        return dpOnGrids(grid,0,0,k,0,memoiz);
    }
}
```
