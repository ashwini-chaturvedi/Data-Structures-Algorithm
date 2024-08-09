package Recursion;

public class Factorial {
    public static int fact(int n,int currProduct){
        //Tail Recursion_BackTracking.Recursion
        //we will maintain the value of currProduct while traversing

        if(n<=1){
            return currProduct;//if it hits base case means we have completed the traversal and answer is stored in currProduct
        }
        return fact(n-1,n*currProduct);

    }
    public static int factorial(int num){
        //Non-Tail Recursion_BackTracking.Recursion
        if(num<2){
            return 1;
        }
      //Induction & Hypothesis
        // factorial(num-1) will give us the result from num-1 upto the base case //this is HYPOTHESIS.
        // after we get the result we multiply it with our currently known num because in factorial factorial(n)=n* factorial(n-1)...
        return num*factorial(num-1);
    }
    public static void main(String[]args){
        int n=5;

        System.out.println(factorial(n));
        System.out.println(fact(n,1));
    }
}
