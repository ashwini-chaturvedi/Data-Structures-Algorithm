Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example 1:

![img](https://assets.leetcode.com/uploads/2020/11/26/max1grid.jpg)

Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]

Output: 4

# Top Down

```java
class Solution {
    
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];//DP is use to store Not number of squares. Not the global maximum. It stores the side length ending at that specific cell.

        //Initialization
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] =0;
                }
            }
        }

        //3 Choices ->decisions
        int maxVal = 0;
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                if (matrix[i - 1][j - 1] == '1') {//if the current number is 1 then we have 3 options
                    int up = dp[i - 1][j];
                    int left = dp[i][j - 1];
                    int diag = dp[i - 1][j - 1];

                    dp[i][j] = 1 + Math.min(up, Math.min(left, diag));
                    maxVal = Math.max(maxVal, dp[i][j]);
                } else {//if number is 0 instantly return 0.
                    dp[i][j] = 0;
                }
            }
        }

        return maxVal * maxVal;
    }
}

```
