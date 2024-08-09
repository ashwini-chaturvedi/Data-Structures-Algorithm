package Strings;

public class Palindrome1 {
    public static void main(String[]args){
        String str="abcdacba";
        StringBuilder gtr=new StringBuilder(str);
        gtr.reverse();
        String s=new String(gtr);
        if (str.equals(s)) {

            System.out.println("Palindrome");
        }else{
            System.out.println("Not a Palindrome");

        }

    }
}
