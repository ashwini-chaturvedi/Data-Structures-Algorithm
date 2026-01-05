```java
//staircase problem
class Solution {
    public int countNegatives(int[][] grid) {
        int i=0;
        int j=grid[0].length-1;

        int count=0;
        //since the matrix is sorted in both row-wise and columnWise we will start from top right corner and if the element is negative the entire column will be negative from that row so add the count of the remaining rows to count and move left else move down the matrix.
        while(i<grid.length && j>=0){
            if(grid[i][j]<0){
                count+=(grid.length-i);
                j--;
            }else{
                i++;
            }
        }

        return count;
    }
}
```
