package Recursion.Recursion;

public class AlternatePlusMiinus {
    public static int alternate(int n){

        if(n==1){
            return 1;
        }
        if(n%2==0){
           return alternate(n-1)-n;
        }else{
            return alternate(n-1)+n;
        }



    }
    public static void main(String[]args){
        int n=6;
        int res=0;
        res=alternate(n);

        System.out.println(res);
    }
}
