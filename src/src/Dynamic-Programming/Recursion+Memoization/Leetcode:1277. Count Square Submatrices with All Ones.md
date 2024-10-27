## Time Complexity:O(N*M)
```java
class Solution {

    public int solve(int i, int j, int[][] matrix, int[][] memoiz) {
        if (i >= matrix.length || j >= matrix[0].length || matrix[i][j] == 0) return 0;

        if (memoiz[i][j] != -1) {
            return memoiz[i][j];
        }

        //We will Only Check in right,bottom and diagonal direction so that we can have a Perfect Square.
        int right = solve(i, j + 1, matrix, memoiz);
        int diagonal = solve(i + 1, j + 1, matrix, memoiz);
        int down = solve(i + 1, j, matrix, memoiz);


        int min1 = Math.min(right, diagonal);
        int min2 = Math.min(diagonal, down);
         
//no of Square=Math.min(right,diagonal,bottom)+1

        return memoiz[i][j] = Math.min(min1, min2) + 1; //this plus one to count the 1 size square we found first and from there we start finding the result
    }

    public int countSquares(int[][] matrix) {
        int[][] memoiz = new int[301][301];
        for (int[] memo : memoiz) {
            Arrays.fill(memo, -1);
        }
        int countSq = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {//When you find one start counting the Squares.
                    countSq += solve(i, j, matrix, memoiz);
                }
            }
        }
        return countSq;
    }
}
```![WhatsApp Image 2024-10-27 at 15 50 43_76697488](https://github.com/user-attachments/assets/e879aa28-cfca-4020-81d0-63de2f441b3c)
![WhatsApp Image 2024-10-27 at 15 50 42_2e4044a2](https://github.com/user-attachments/assets/2f11b2ba-e5c1-46f5-b836-20ab8399e41e)
![WhatsApp Image 2024-10-27 at 15 50 43_76697488](https://github.com/user-attachments/assets/1f8897c7-df58-4c52-936d-b4f7cbe17583)
![WhatsApp Image 2024-10-27 at 15 50 42_2e4044a2](https://github.com/user-attachments/assets/03977ddf-ce39-42dd-bb99-b232a534184b)
