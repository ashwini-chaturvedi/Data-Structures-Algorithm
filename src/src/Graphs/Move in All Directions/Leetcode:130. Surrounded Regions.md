```java
class Solution {
    //Mark all the Boundary 'O' cells as 'T' For Temporary.
    //Flip all the Insider 'O' to 'X'
    //Then Flip back all the 'T' back to 'O'.

    public boolean isValid(char[][] board, int i, int j) {
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
    }

    public void Surround(char[][] board, int i, int j, int[][] directions) {
        if (!isValid(board, i, j) || board[i][j] != 'O') return;

        board[i][j] = 'T'; //Mark it T as Temporary

        for (int[] dir : directions) {
            int newI = i + dir[0];
            int newJ = j + dir[1];

            if (isValid(board, newI, newJ) && board[newI][newJ]=='O') {
                Surround(board, newI, newJ, directions);
            }
        }
    }

    public void solve(char[][] board) {
        int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //When the 'O' cells are connected to the Boundary mark them Temprarily because we cannot change the boundary 'O' so first we mark them temporarily
                if (i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1) { //checks the cell is boundary from row or column
                    if (board[i][j] == 'O') { //it is boundary cell and if it has 'O' mark it and all its connected Boundary cell...
                        Surround(board, i, j, directions);
                    }
                }
            }
        }

        //After Marking all the Boundary 'O' cells 'T' Now flip all the Inner 'O' to 'X' and flip all the 'T' back to 'O'
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X'; else if (board[i][j] == 'T') board[i][j] = 'O';
            }
        }
    }
}

```
