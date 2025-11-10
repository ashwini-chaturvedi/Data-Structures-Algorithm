```java
class Solution {
    //Rotating a Matrix 
    // 1. Transpose the Matrix.
    // 2. Swap the columns in pair 1st-last,2nd-2ndLast ...

    public void rotate(int[][] matrix) {
        //Transpose the Matrix and then Interchange the elements starting from first and last then 2nd and 2nd last etc...

        for (int i = 0; i < matrix.length; i++) {
            //j=i+1 because when we do j=0 Each pair is swapped twice:

            // First when (i, j) is visited.

            // Again when (j, i) is visited.
            for (int j = i + 1; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //Swapping the Values from start column and end column...
        for(int row=0;row<matrix.length;row++){
            int low=0;
            int high=matrix[0].length-1;

            while(low<high){
                int temp=matrix[row][low];
                matrix[row][low]=matrix[row][high];
                matrix[row][high]=temp;

                low++;
                high--;
            }
        }

    }
}

```
