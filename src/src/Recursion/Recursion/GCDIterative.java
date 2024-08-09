package Recursion.Recursion;

public class GCDIterative {
    //Iterative Approach
    public static int iGCD(int num1,int num2){
        while(num1%num2!=0){
            int rem=num1%num2;
            num1=num2;
            num2=rem;
        }
        return num2;
    }
    public static int rGCD(int num1,int num2){
        if(num2==0){
            return num1;
        }
       return rGCD(num2,num1%num2);
    }
    public static void main(String[]args){
        int n1=15;
        int n2=24;
        int res=iGCD(n1,n2);
        System.out.println(res);
        int res2=rGCD( n1, n2);
        System.out.println(res2);

    }
}
