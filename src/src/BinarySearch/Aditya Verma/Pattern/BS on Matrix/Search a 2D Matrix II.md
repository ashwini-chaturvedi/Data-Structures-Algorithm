Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.

Integers in each column are sorted in ascending from top to bottom.

 

Example 1:

![image](https://assets.leetcode.com/uploads/2020/11/24/searchgrid2.jpg)

Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5

Output: true

# Staircase Search Pattern

```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Get the number of rows and columns in the matrix
        int m = matrix.length;       // Number of rows
        int n = matrix[0].length;    // Number of columns

        // Start from the top-right corner of the matrix
        int i = 0;      // Row index
        int j = n - 1;  // Column index

        // Traverse the matrix until we go out of bounds
        while (i >= 0 && i < m && j >= 0 && j < n) {

            // Case 1: If the current element matches the target, return true
            if (matrix[i][j] == target) {
                return true;
            } 
            // Case 2: If the current element is greater than the target, move left
            // (decrease the column index)
            else if (matrix[i][j] > target) {
                j--;
            } 
            // Case 3: If the current element is less than the target, move down
            // (increase the row index)
            else if (matrix[i][j] < target) {
                i++;
            }
        }

        // If we exit the loop without finding the target, return false
        return false;
    }
}

```
