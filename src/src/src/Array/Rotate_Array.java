package Array;//Rotate the Array by K-Position.
import java.util.*;
public class Rotate_Array {
    public static void takeInput(int[]array){
        System.out.println("Enter the Elements of the array:");
        Scanner Input=new Scanner(System.in);
        for(int i=0;i<array.length;i++){
            array[i]=Input.nextInt();
        }
    }
    public static void printArray(int []array){
        for(int i=0;i<array.length;i++){
            System.out.print(" "+array[i]);
        }
    }
    public static int[]rotateByK(int[]array,int k){
        int []temp=new int[array.length];
        for(int i=0;i<array.length;i++){
            temp[(i+k)%array.length]=array[i];
        }
        return temp;
    }
    public static void rotateByKth(int[]array,int k){
        int []temp=new int[array.length];
        for(int i=0;i<array.length;i++){
            temp[(i+k)%array.length]=array[i];
        }
        array=temp;
        System.out.println("\nRotated Original_Array:");
        printArray(array);
    }
    public static void main(String[]args){
        Scanner Input=new Scanner(System.in);
        System.out.println("Enter the number of places from which you want to rotate the array:");
        int k=Input.nextInt();
        System.out.println("Enter the size of the array:");
        int sizeof_array=Input.nextInt();
        int []array=new int[sizeof_array];
        takeInput(array);
        printArray(array);
        System.out.println("\nRotated New_Array:");
        int []new_array=rotateByK(array,k);
        printArray(new_array);
        rotateByKth(array,k);



    }
}
