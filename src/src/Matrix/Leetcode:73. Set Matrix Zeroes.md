# Identify the Rows and Columns that needs to be set zero first and then mark them zero...
# Using Arrays of rows and cols
```java
class Solution {

    public void setZeroes(int[][] matrix) {
        //Use 2 Arrays to Store the index of rows and columns that need to be set 0
        boolean[] rows = new boolean[matrix.length];
        boolean[] cols = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {//if the cell is zero mark its rows and columns as true that means this row and column needs to be set 0...
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }
        //Set Elements at the previously identified cells to be zero... 
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (rows[i] || cols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

```
# Using List
```java
class Solution {
    public void setZeroes(int[][] matrix) {
        // Direction vectors for up, down, left, right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        List<int[]>toBeSetZero=new ArrayList<>();
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    
                    for(int[] dir:directions){
                        int newI=i+dir[0];
                        int newJ=j+dir[1];

                        while(newI>=0 && newI<matrix.length && newJ>=0 && newJ<matrix[0].length){
                           toBeSetZero.add(new int[]{newI,newJ});

                            newI+=dir[0];
                            newJ+=dir[1];

                        }
                    }
                }
            }
        }

        for(int[] setZero:toBeSetZero){
            matrix[setZero[0]][setZero[1]]=0;
        }
    }
}
```
