package Bit_Manipulation;

public class Basics {
    public static void main(String[]args){
        int n=5;
        int pos=2;
        int bitMask=1<<pos;

        //getbit method
        if((bitMask & n)==0){
            System.out.println("GetBit:The Bit was '0'");
        }else{
            System.out.println("GetBit:The Bit was '1'");
        }

        //setbit Method
       int newNum=bitMask|n;
        System.out.println("SetBit=>"+newNum);

        //clear
        int newNumber=(~bitMask)&n;
        System.out.println("ClearBit=>"+newNumber);

    }
}
