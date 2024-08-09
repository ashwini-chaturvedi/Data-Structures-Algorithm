package Array;

import java.util.Scanner;

public class Spiral_Matrix {
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
    public static void Print_SpiralMatrix(int[][]Matrix){
        int row=Matrix.length;
        int columns=Matrix[0].length;
        int topRow=0;
        int bottomRow=row-1;
        int leftColumn=0;
        int rightColumn=columns-1;
        int totalElements=0;
        while(totalElements<row*columns){
            //Print Elements in top row from left Coloumn to right Column.
            for(int j=leftColumn;j<=rightColumn && totalElements<row*columns;j++){
                System.out.print(Matrix[topRow][j]+" ");
                totalElements++;
            }
            topRow++;

            //Print Elements in right column from top row to bottom row.
            for(int i=topRow;i<=bottomRow && totalElements<row*columns;i++){
                System.out.print(Matrix[i][rightColumn]+" ");
                totalElements++;
            }
            rightColumn--;

            //Print Elements in bottom row from rightcoloumn to left column.
            for(int j=rightColumn;j>=leftColumn && totalElements<row*columns;j--){
                System.out.print(Matrix[bottomRow][j]+" ");
                totalElements++;
            }
            bottomRow--;

            //Print Elements in right column from bottom row to top row.
            for(int i=bottomRow;i>=topRow && totalElements<row*columns;i--){
                System.out.print(Matrix[i][leftColumn]+" ");
                totalElements++;
            }
            leftColumn++;
        }
    }
    public static void main(String[]args){
        Scanner Input=new Scanner(System.in);
        System.out.println("Enter number of Rows:");
        int rows=Input.nextInt();
        System.out.println("Enter number of columns:");
        int columns=Input.nextInt();

        int [][]Matrix=new int[rows][columns];
        takeInput(Matrix);
        printMatrix(Matrix);
        System.out.println("Spiral Form of Matrix:");
        Print_SpiralMatrix(Matrix);


    }
}
