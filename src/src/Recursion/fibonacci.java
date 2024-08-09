package Recursion;

public class fibonacci {
    public static int fibo(int n){
        if(n<=2){
            return 1;
        }
        ///here Induction is addition of results of both the hypothesis calls
        return fibo(n-1)+fibo(n-2);
    }
    public static void main(String[]args){
        int n =5;
        System.out.println(fibo(n));
    }
}
