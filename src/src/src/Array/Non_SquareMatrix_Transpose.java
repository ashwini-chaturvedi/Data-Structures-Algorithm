package Array;

import java.util.*;
public class Non_SquareMatrix_Transpose {
    static public void takeInput(int[][]Matrix){
        Scanner Input=new Scanner(System.in);
        for(int i=0;i<Matrix.length;i++ ){
            for(int j=0;j<Matrix[0].length;j++){
                Matrix[i][j]=Input.nextInt();
            }
        }
    }
    static public void printMatrix(int [][]Matrix){
        for(int i=0;i<Matrix.length;i++){
            for(int j=0;j<Matrix[0].length;j++){

                System.out.print(" "+Matrix[i][j]);
            }
            System.out.println("");

        }
    }
    public static void main(String[]args){
        int [][]Matrix=new int[3][2];
        takeInput(Matrix);
        printMatrix(Matrix);
        System.out.println("");
        //Transpose
        int [][]Transpose=new int[Matrix[0].length][Matrix.length];
        for(int i=0;i<Matrix[0].length;i++){
            for(int j=0;j<Matrix.length;j++){
                Transpose[i][j]=Matrix[j][i];
            }
        }
        printMatrix(Transpose);
        //Reverse the First & Last Element
        for(int i=0;i<Transpose.length;i++){
            int low=0;
            int high=Transpose[0].length-1;
            while(low<high){
                int temp=Transpose[i][low];
                Transpose[i][low]=Transpose[i][high];
                Transpose[i][high]=temp;
                low++;
                high--;

            }
        }
        System.out.println("Rotated to 90 Degree");
        printMatrix(Transpose);

    }
}
