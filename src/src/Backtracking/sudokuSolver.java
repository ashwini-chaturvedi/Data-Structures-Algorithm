package Backtracking;

public class sudokuSolver {
    public static boolean isValidToPut(char[][]board,int row,int col,char ch){
        for(int i=0;i<9;i++){
            if(board[row][i]==ch){
                return false;
            }
            if(board[i][col]==ch){
                return false;
            }
            int idx=3*(row/3)+(i/3);
            int jdx=3*(col/3)+(i%3);
            if(board[idx][jdx]==ch){
                return false;
            }
        }
        return true;
    }
    public static boolean solver(char[][]board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    for(char ch='1';ch<='9';ch++){
                        if(isValidToPut(board,i,j,ch)){
                            board[i][j]=ch;
                            if(solver(board)){
                                //Recursive calling
                                return true;//the question doesn't asking us all the way to solve a sudoku so as soon as we get
                                //one possible way we will return true or it will start calculating all possible ways by backtracking
                                //all the steps taken early...
                            }else {
                                board[i][j]='.';//BackTracking
                            }
                        }
                    }
                    //if we are unable to put a number to make the sudoku valid we will return false for that particular cell and
                    //for that number so that we dont put it at that place...
                    return false;

                }
            }
        }
        return true;
    }
    public void solveSudoku(char[][]board){
        solver(board);
    }
    public static void main(String[]args){
        char[][]board=  {
                        {'9', '5', '7', '.', '1', '3', '.', '8', '4'},
                        {'4', '8', '3', '.', '5', '7', '1', '.', '6'},
                        {'.', '1', '2', '.', '4', '9', '5', '3', '7'},
                        {'1', '7', '.', '3', '.', '4', '9', '.', '2'},
                        {'5', '.', '4', '9', '7', '.', '3', '6', '.'},
                        {'3', '.', '9', '5', '.', '8', '7', '.', '1'},
                        {'8', '4', '5', '7', '9', '.', '6', '1', '3'},
                        {'.', '9', '1', '.', '3', '6', '.', '7', '5'},
                        {'7', '.', '6', '1', '8', '5', '4', '.', '9'}
        };
        for(char[]nums:board){
            for(char num:nums){
                System.out.print(num+",");
            }
            System.out.println();
        }
        solver(board);
        System.out.println();
        for(char[]nums:board){
            for(char num:nums){
                System.out.print(num+",");
            }
            System.out.println();
        }

    }
}
