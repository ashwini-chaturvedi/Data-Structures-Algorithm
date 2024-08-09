package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N_Queens {



        public static boolean underAttack(ArrayList<String>board,int row,int col){
            //checking attack from up
            for(int i=0;i<board.size();i++){
                if(board.get(i).charAt(col)=='Q'){
                    return false;
                }
            }

            //checking left diagonal
            for(int i=row,j=col;i>=0&&j>=0;i--,j--){
                if(board.get(i).charAt(j)=='Q'){
                    return false;
                }
            }

            //checking right diagonal
            for(int i=row,j=col;i>=0&&j<board.size();i--,j++){
                if(board.get(i).charAt(j)=='Q'){
                    return false;
                }
            }
            return true;
        }
        public static void solve(ArrayList<String>board,ArrayList<ArrayList<String>>list,int row){
            if(row==board.size()){
                list.add(new ArrayList<>(board));
                return;
            }
            for(int col=0;col<board.size();col++){
                if(underAttack(board,row,col)){
                    StringBuilder newRow=new StringBuilder(board.get(row));
                    newRow.setCharAt(col,'Q');
                    board.set(row,newRow.toString());

                    solve(board,list,row+1);

                    newRow.setCharAt(col,'.');
                    board.set(row,newRow.toString());
                }
            }
        }
        static ArrayList<ArrayList<String>> nQueen(int n) {
            // code here
            ArrayList<String>board=new ArrayList<>();
            for(int i=0;i<n;i++){
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<n;j++){
                    sb.append('.');
                }
                board.add(sb.toString());
            }
            ArrayList<ArrayList<String>>list=new ArrayList<>();
            solve(board,list,0);
            List<List<Integer>>j=new ArrayList<>();
            return list;
        }

    public static void main(String[] args) {
        System.out.println(nQueen(4));
    }
}
