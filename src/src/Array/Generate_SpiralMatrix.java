package Array;

import java.util.Scanner;

public class Generate_SpiralMatrix {
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
    public static void takeSpiralInput(int[][]Matrix){
        Scanner Input=new Scanner(System.in);
        int row=Matrix.length;
        int column=Matrix[0].length;
        int top=0;
        int bottom=row-1;
        int left=0;
        int right=column-1;
        int totalElements=0;
        while(totalElements<row*column){
            for(int j=left;j<=right&&totalElements<row*column;j++){
                Matrix[top][j]=Input.nextInt();
                totalElements++;
            }
            top++;
            for(int i=top;i<=bottom&&totalElements<row*column;i++){
                Matrix[i][right]=Input.nextInt();
                totalElements++;
            }
            right--;
            for(int j=right;j>=left&&totalElements<row*column;j--){
                Matrix[bottom][j]=Input.nextInt();
                totalElements++;
            }
            bottom--;
            for(int i=bottom;i>=top&&totalElements<row*column;i--){
                Matrix[i][left]=Input.nextInt();
                totalElements++;
            }
            left++;
        }
    }
    public static void main(String[]args){
        Scanner Input=new Scanner(System.in);
        System.out.println("Enter number of Rows:");
        int rows=Input.nextInt();
        System.out.println("Enter number of columns:");
        int columns=Input.nextInt();
        int [][]Matrix=new int[rows][columns];
        takeSpiralInput(Matrix);


        System.out.println("Spiral Form of Matrix:");
        printMatrix(Matrix);
    }
}
