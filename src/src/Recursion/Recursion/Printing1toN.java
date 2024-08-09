package Recursion.Recursion;

public class Printing1toN {
    public static void print(int n){
        //Base Case
        if(n==1){
            System.out.print(1);
            return;
        }
        print(n-1);//Assumption or recursive calls
        System.out.print(n);//self work
    }
    public static void main(String[] args){
        int n=5;
        print(n);
    }
}
