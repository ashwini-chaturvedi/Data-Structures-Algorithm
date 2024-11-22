
```java
/*
If Rows are Exactly Same to Each other we only have to flip the odd column between them else and they will become same
    e.g: 101
         101
 we will flip the odd bits i.e. 1st column and we will get all 1 in both the rows
if Rows are Exactly Inverted to Each other we only have to flip the odd bit and one of them will become all 1 and other will become all 0.
    e.g: 101
         010
 we will flip the odd bits i.e. 1st column and we will get all 1 in above row and 0 in below row
*/

/*
Steps:
    1. Pick Each Row
    2. a.Check if any same row is Present
       b.Check if Inverted row is Present
        Take a Count of Both Types
    3. Maximum of the Counts will give us the Answer
 */
class Solution {
    //Time Complexity:o(M*M*N)
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        
        int maxSimilarRows=0;

        for(int[] currRow:matrix){//O(M)

            int[] invertedRow=new int[matrix[0].length];//O(N)

            for(int i=0;i<currRow.length;i++){//O(N)
                invertedRow[i]=currRow[i]==0?1:0;//Making an Inverted row of Current Row...
            }

            int count=0;
            for(int[] row:matrix){//O(N)
                if( Arrays.equals(row,currRow)|| Arrays.equals(invertedRow,row) ){//Taking O(N) time because whole array is getting compared...
                    count++;
                }
            }
            maxSimilarRows=Math.max(maxSimilarRows,count);
        }
        return maxSimilarRows;
    }
}
```
