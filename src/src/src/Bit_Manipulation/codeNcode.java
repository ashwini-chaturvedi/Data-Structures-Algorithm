package Bit_Manipulation;

public class codeNcode {
    public static void swapWithoutTemp(int a,int b){
        System.out.println("Unswapped:"+a+","+b);
        a=a^b;
        b=a^b;
        a=a^b;
        System.out.println("Swapped:"+a+","+b);
    }

    public static void main(String[]args){
        //Checking bit is set or not
        long num=4294967293l;
        int referenceNum=1;
        referenceNum=referenceNum<<1;

        if((num&referenceNum)==0){
            System.out.println("Bit was not set");
        }else{
            System.out.println("bit was set");
        }
        //counting number of set bits in a binary representation of a number.

        int count=0;
        while(num!=0){

            if((num&1)!=0){
                count++;
            }
            num=num>>1;
        }
        System.out.println(count);

        //Swapping value of element without using temp variable.
        int a=5;
        int b=7;
        swapWithoutTemp(a,b);

    }
}
