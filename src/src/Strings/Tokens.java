package Strings;

class Solution {
    public int compareVersion(String version1, String version2) {
        String []v1=version1.split("\\.");//this makes different different strings of the character or string after spliting them from
        //passed position(regex).
        String[]v2=version2.split("\\.");
        for(int i=0;i<Math.max(v1.length,v2.length);i++){
            int num1=i<v1.length?Integer.parseInt(v1[i]):0;//this changes the value of string to int type
            int num2=i<v2.length?Integer.parseInt(v2[i]):0;
            if(num1<num2) return -1;
            if(num1>num2) return 1;
        }
        return 0;
    }
}
public class Tokens {
    public static void main(String[] args) {
        Solution s=new Solution();
        String s1="1.0.1";
        String s2="1";
        System.out.println(s.compareVersion(s1,s2));
    }
}
