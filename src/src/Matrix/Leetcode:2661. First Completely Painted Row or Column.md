You are given a 0-indexed integer array arr, and an m x n integer matrix mat. arr and mat both contain all the integers in the range [1, m * n].

Go through each index i in arr starting from index 0 and paint the cell in mat containing the integer arr[i].

Return the smallest index i at which either a row or a column will be completely painted in mat.

Example 2:

![Image](https://assets.leetcode.com/uploads/2023/01/18/grid2.jpg)
Input: arr = [2,8,7,4,1,3,5,6,9], mat = [[3,2,5],[1,4,6],[8,7,9]]
Output: 3
Explanation: The second column becomes fully painted at arr[3].

```java
class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer,int[]>map=new HashMap<>();

        //Store the Coordinates
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                map.put(mat[i][j],new int[]{i,j});
            }
        }

        //Arrays to Store the count of cells painted in that Row or Column
        int[] countRow=new int[mat.length];
        int[] countCol=new int[mat[0].length];
        
        for(int i=0;i<arr.length;i++){
            int num=arr[i];

            int x=map.get(num)[0];
            int y=map.get(num)[1];

            //Increase the Count of the Row and Column which will show how many cells has be Painted in this Row or Column.
            countRow[x]+=1;
            countCol[y]+=1;

            // if the Row x has all painted cells equals to total number of Column.
            //                   or
            // if the Column y has all painted cells equals to total number of Row.
            //Then at that point either a row or column is Fully painted so return 'i'.
            if(countRow[x]==mat[0].length || countCol[y]==mat.length) return i;
        }

        return -1;
    }
}
```
 ```java
class Solution {

    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, Integer> map = new HashMap<>();

        //Store the Element with its Index in a Map
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        //Store the Minimum Index it would need so that a row or column will get painted fully
        int[] minIdxToBeColored = new int[mat.length + mat[0].length];
        int k = 0;

//Traverse the matrix and for each row and column find out the Maximum Index of the Elements in that row or Column which will be the Minumum Index it would take to Paint that Particular Row or Column. 
        for (int i = 0; i < mat.length; i++) {
            int max = -1;
            for (int j = 0; j < mat[0].length; j++) {
                max = Math.max(max, map.get(mat[i][j]));
            }
            minIdxToBeColored[k] = max;
            k++;
        }
        for (int j = 0; j < mat[0].length; j++) {
            int max = -1;
            for (int i = 0; i < mat.length; i++) {
                max = Math.max(max, map.get(mat[i][j]));
            }
            minIdxToBeColored[k] = max;
            k++;
        }

        //Find the Minimum it would take to paint the Row or Column.
        int min = Integer.MAX_VALUE;

        for (int num : minIdxToBeColored) {
            min = Math.min(min, num);
        }

        return min;
    }
}

```
