```java
class Solution {

    public boolean isValid(char[][] board, int currRow, int currCol, int currNum) {
        for (int i = currRow + 1; i < board.length; i++) { // we will traverse the row
            if (board[i][currCol] == currNum) return false; //No Duplicate Allowed...
        }
        for (int j = currCol + 1; j < board[0].length; j++) { // we will traverse the column
            if (board[currRow][j] == currNum) return false; //No Duplicate Allowed...
        }

        //Now we Go for the smaller 3X3 Boxes 
        int smallRow = currRow - currRow % 3;
        int smallCol = currCol - currCol % 3;

        for (int i = smallRow; i < smallRow + 3; i++) {
            for (int j = smallCol; j < smallCol + 3; j++) {

                //if duplicate element is there and the row and col is not same to the currNum's index...
                if (board[i][j] == currNum && i != currRow && j != currCol) return false;
            }
        }

        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.' && !isValid(board, i, j, board[i][j])) {
                    return false;
                }
            }
        }

        return true;
    }
}

```
