package Array;

import java.util.Scanner;

public class PascalsTriangle {

    public static void printArray(int [][]array){
        for(int i=0;i<array.length;i++) {
            for (int a = 1; a <= array.length - i; a++) // spaces ke liye ekk loop
            {
                System.out.print(" ");
            }

            for (int j = 0; j <=i; j++) {

                System.out.print(" " + array[i][j]);
            }
            System.out.println("");

        }
    }
    public static int[][] PascalTriangle(int k){
        int [][]ansArray=new int[k][];
        for(int i=0;i< k;i++){
            //ith row has (i+1)th columns.
            ansArray[i]=new int[i+1];//creating a 1D Array whose column size will grow gradually.
            //1st and last Element of every row is 1
            ansArray[i][0]=ansArray[i][i]=1;
            for(int j=1;j<i;j++ ){

                ansArray[i][j]=ansArray[i-1][j]+ansArray[i-1][j-1];
            }
        }
        return ansArray;

    }
    public static void main(String[]args){
        Scanner Input=new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int sizeof_array=Input.nextInt();
        int[][]Pascaltrriangle=PascalTriangle(sizeof_array);
        printArray(Pascaltrriangle);
    }
}
