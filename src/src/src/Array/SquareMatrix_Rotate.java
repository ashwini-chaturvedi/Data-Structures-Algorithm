package Array;

import java.util.Scanner;

public class SquareMatrix_Rotate {
    static public void takeInput(int[][] Matrix) {
        Scanner Input = new Scanner(System.in);
        for (int i = 0; i < Matrix.length; i++) {
            for (int j = 0; j < Matrix.length; j++) {
                Matrix[i][j] = Input.nextInt();
            }
        }
    }

    static public void printMatrix(int[][] Matrix) {
        for (int i = 0; i < Matrix.length; i++) {
            for (int j = 0; j < Matrix.length; j++) {

                System.out.print(" " + Matrix[i][j]);
            }
            System.out.println("");

        }
    }
    public static void Transpose(int[][]Matrix){
        //Transpose
        for (int i = 0; i < Matrix.length; i++) {
            for (int j = i + 1; j < Matrix.length; j++) {
                int temp = Matrix[i][j];
                Matrix[i][j] = Matrix[j][i];
                Matrix[j][i] = temp;
            }
        }
    }
    public static void Rotate(int[][]TransposedMatrix){
        //Reverse the First & Last Element
        for (int i = 0; i < TransposedMatrix.length; i++) {
            int low = 0;
            int high = TransposedMatrix.length - 1;
            while (low < high) {
                int temp = TransposedMatrix[i][low];
                TransposedMatrix[i][low] = TransposedMatrix[i][high];
                TransposedMatrix[i][high] = temp;
                low++;
                high--;

            }
        }
    }


    public static void main(String[] args) {
        int[][] Matrix = new int[3][4];
        takeInput(Matrix);
        printMatrix(Matrix);
        System.out.println("");


        //To Rotate a Matrix 90 Degree follow Following Steps

        //Step:1 Transpose the Matrix.

        System.out.println("Transposed Matrix:");
        Transpose(Matrix);
        printMatrix(Matrix);

        //Step:2 Then Swap the values of First and Last Columns.
        Rotate(Matrix);
        System.out.println("Rotated to 90 Degree(Clock Wise");
        printMatrix(Matrix);



    }
}
