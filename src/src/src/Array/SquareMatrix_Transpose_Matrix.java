package Array;

import java.util.*;
public class SquareMatrix_Transpose_Matrix {
    static public void takeInput(int[][]Matrix){
        Scanner Input=new Scanner(System.in);
        for(int i=0;i<Matrix.length;i++ ){
            for(int j=0;j<Matrix.length;j++){
                Matrix[i][j]=Input.nextInt();
            }
        }
    }
    static public void printMatrix(int [][]Matrix){
        for(int i=0;i<Matrix.length;i++){
            for(int j=0;j<Matrix.length;j++){

                System.out.print(" "+Matrix[i][j]);
            }
            System.out.println("");

        }
    }
    public static void main(String[]args){
        int [][]Matrix=new int[3][4];
        takeInput(Matrix);
        printMatrix(Matrix);
        System.out.println("");
        //Transpose
        for(int i=0;i<Matrix.length;i++){
            for(int j=i+1;j<Matrix.length;j++){
                int temp=Matrix[i][j];
                Matrix[i][j]=Matrix[j][i];
                Matrix[j][i]=temp;
            }
        }
        printMatrix(Matrix);

    }
}
