package Backtracking;

public class wordSearch {
    public static boolean solve(char[][]board,String word,int i,int j,int m,int n,int idx){
        if(i<0||i>=m||j<0||j>=n||board[i][j]=='0'){

            return false;
        }
        if(idx==word.length()){
            return true;
        }
        char ch=board[i][j];
                board[i][j]='0';
                boolean flag=solve(board,word,i+1,j,m,n,idx+1)||
                             solve(board,word,i-1,j,m,n,idx+1)||
                             solve(board,word,i,j-1,m,n,idx+1)||
                             solve(board,word,i,j+1,m,n,idx+1);
                board[i][j]=ch;
        return  flag;

    }
    public static boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)&&solve(board,word,i,j,m,n,0)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

      char[][]board={{'C','A','A'},{'A','A','A'},{'B','C','D'}};
      String word="AAB";
        System.out.println(exist(board,word));
    }
}
