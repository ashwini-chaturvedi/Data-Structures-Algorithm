You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.

The first integer of each row is greater than the last integer of the previous row.

Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.

Example 1:
![image](https://assets.leetcode.com/uploads/2020/10/05/mat.jpg)

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3

Output: true

Intuition:

When flattening the 2d matrix it is map in this way 

we are flattening it by column and after every elements equal to col the next row elements start so we will divide it with n or number of cols...

Division / n → “how many full rows are done already”

Modulus % n → “how far inside the current row we are”

int row = mid / n; //row index (quotient)

int col = mid % n; //column index (remainder)

```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length;
        int col=matrix[0].length;

        int low=0;
        int high=row*col-1;

        while(low<=high){
            int mid=low+(high-low)/2;

            int currRow=mid/col;
            int currCol=mid%col;

            if(matrix[currRow][currCol]==target){
                return true;
            }else if(matrix[currRow][currCol]>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return false;   
    }
}

```
