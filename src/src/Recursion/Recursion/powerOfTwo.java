package Recursion.Recursion;
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n==0){
            return false;
        }
        if(n==1){
            return true;
        }
        if(n%2!=0){
            return false;
        }
        return isPowerOfTwo(n/2);

    }
}
public class powerOfTwo {
    public static void main(String[] args) {
        int n=1;
        Solution s=new Solution();
        System.out.println(s.isPowerOfTwo(n));
    }
}
