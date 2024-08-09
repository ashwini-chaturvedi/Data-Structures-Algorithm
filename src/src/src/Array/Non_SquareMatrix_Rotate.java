package Array;

import java.util.Scanner;

public class Non_SquareMatrix_Rotate {
    static public void takeInput(int[][] Matrix) {
        Scanner Input = new Scanner(System.in);
        for (int i = 0; i < Matrix.length; i++) {
            for (int j = 0; j < Matrix[0].length; j++) {
                Matrix[i][j] = Input.nextInt();
            }
        }
    }

    static public void printMatrix(int[][] Matrix) {
        for (int i = 0; i < Matrix.length; i++) {
            for (int j = 0; j < Matrix[0].length; j++) {

                System.out.print(" " + Matrix[i][j]);
            }
            System.out.println("");

        }
    }
    public static int[][]Transpose(int[][]Matrix){
        //Transpose
        int[][] Transpose = new int[Matrix[0].length][Matrix.length];
        for (int i = 0; i < Matrix[0].length; i++) {
            for (int j = 0; j < Matrix.length; j++) {
                Transpose[i][j] = Matrix[j][i];
            }
        }
        return Transpose;
    }
    public static void Rotate(int[][]TransposedMatrix){
        //Reverse the First & Last Element
        for (int i = 0; i < TransposedMatrix.length; i++) {
            int low = 0;
            int high = TransposedMatrix[0].length - 1;
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
        int[][] Matrix = new int[3][2];
        takeInput(Matrix);
        printMatrix(Matrix);
        System.out.println("\n");

        //To Rotate a Matrix 90 Degree follow Following Steps

        //Step:1 Transpose the Matrix.
        int [][]Transpose=Transpose(Matrix);//Recieving the new Array.>Transpose
        System.out.println("Transposed Matrix:");
        printMatrix(Transpose);

        //Step:2 Then Swap the values of First and Last Columns.
        Rotate(Transpose);
        System.out.println("Rotated to 90 Degree");
        printMatrix(Transpose);
    }
}
