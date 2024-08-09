package Bit_Manipulation;

public class singleNumber_III {
    //we will first find the Xor of all the elements of the array this will alse contains the XOR of the numbers that occured 1 time .
    //now will group both the numbers in a way that both of the single occuring numbers would be in different groups and then we will xor the whole elements of each group which will give us the non duplicate numbers.
    //to group them we will use a common way of grouping them on the basis of there set or not set bit.
    public static int[] singleNumber(int[] nums) {
        int xorRes=0;
        for(int num:nums){
            xorRes^=num;
        }
        int notSetBit=xorRes & -xorRes;
        int []resArray=new int[2];
        for(int num:nums){
            if((notSetBit & num)==0){
                resArray[0]^=num;
            }else{
                resArray[1]^=num;
            }
        }
        return resArray;
    }

    public static void main(String[] args) {

    }
}
