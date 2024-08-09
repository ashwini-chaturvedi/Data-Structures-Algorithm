package Recursion;

public class PrintingN_numbers {
    public static void print1ToN(int n){
        if(n==0){//Base Condition
            return;
        }
        //Hypothesis before Induction
        //Hypothesis
        print1ToN(n-1);//we hypothetically assume that this function will give us the result of all the numbers from n-1 to 1
        //Induction: we attach the result given by Hypothesis step with the result of current operation to provide the final result...
        System.out.print(n+",");//atlast we only print out the result of the current number that is n...
    }
    public static void printNto1(int n){
        if(n==0){//base condition
            return;
        }
        //this time we have to print first (Induction before hypothesis) because we trust that recursive call will give us answers from
        //n-1 to 1
        System.out.print(n+",");
        //Hypothesis
        printNto1(n-1);
    }
    public static void main(String[]args){
        int n=7;
        print1ToN(n);
        System.out.println();
        printNto1(n);
    }
}
