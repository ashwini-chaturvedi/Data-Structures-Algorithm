package Bit_Manipulation;

public class s {
    public static boolean isSubsequence(String s, String t) {
        int i=0;
        int j=0;
        while(i<s.length()&&j<t.length()){
            if(s.charAt(i)==t.charAt(j)){
                i++;
                j++;
            }else{
                j++;
            }
        }
        System.out.println(i);
        return i == s.length() ;
    }

    public static void main(String[] args) {
        String s="axc";
        String t="ahbgdc";
        System.out.println(isSubsequence(s,t));
    }
}
