You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

![image](https://assets.leetcode.com/uploads/2020/08/28/mat2.jpg)
Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]

Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

```java
class Solution {

    public void rotate(int[][] matrix) {
        // Step 1: Transpose the matrix
        // Transpose means converting rows into columns and columns into rows.
        // In a transposed matrix, element at (i, j) becomes (j, i).
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                // Swap elements at (i, j) and (j, i)
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        // After transposing, reverse the rows to achieve a 90-degree rotation.
        // This is done using two pointers: one at the start (`low`) and one at the end (`high`) of the row.
        for (int row = 0; row < matrix.length; row++) {
            int low = 0;
            int high = matrix.length - 1;

            // Swap elements at the `low` and `high` indices until the pointers meet.
            while (low <= high) {
                int temp = matrix[row][low];
                matrix[row][low] = matrix[row][high];
                matrix[row][high] = temp;

                low++;  // Move the `low` pointer to the right
                high--; // Move the `high` pointer to the left
            }
        }
    }
}

```
