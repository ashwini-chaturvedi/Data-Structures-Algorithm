Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

 

Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]

Output: 11

Explanation: The triangle looks like:

   2
  3 4
 6 5 7
4 1 8 3

The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).

# Bottom-Up
```java
class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];

        // Initialize the dp array with the last row of the triangle
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }

        // Iterate from the second-last row to the top
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                // Update dp[j] with the minimum path sum at each position
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }

        // The top element of dp contains the minimum path sum
        return dp[0];
    }
}

```
# Recursion+Memoization
```java
class Solution {

    public int solve(List<List<Integer>> triangle, int i, int j,int[][] memoiz) {
        if (i >= triangle.size()) return 0;//if last line of a Triangle then return 0.
        if (j >= triangle.get(i).size()) return Integer.MAX_VALUE;//If the values of Columns End then return Maximum Value.

        if(memoiz[i][j]!=-1){
            return memoiz[i][j];
        }

        //you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

        int same = triangle.get(i).get(j) + solve(triangle, i + 1, j,memoiz);//next Row ,Same Column.
        int plusOne = triangle.get(i).get(j) + solve(triangle, i + 1, j + 1,memoiz);//next Row, next Column.

        return memoiz[i][j]=Math.min(same, plusOne);//Return the minimum of two Options
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1) return triangle.get(0).get(0);

        int[][] memoiz=new int[201][201];

        for(int[] memo:memoiz){
            Arrays.fill(memo,-1);
        }
        return solve(triangle, 0, 0,memoiz);
    }
}

```
