package Strings;
import java.util.*;

public class Palindrome2 {
    public static void getsubString(String str){
        for(int i=0;i<str.length();i++){
            for(int j=i+1;j<str.length();j++){
                String ch=str.substring(i,j);
                System.out.println(ch+" "+isPalindrome(ch));//Checking if Palindrome or not
                //single character is palindrome.

            }
        }
    }
    public static boolean isPalindrome(String str){
            int i=0;
            int j=str.length()-1;
            while(i<j){
                if(str.charAt(i)!=str.charAt(j)){
                    return false;
                }
                i++;
                j--;
            }
        return true;

    }
    public static void main(String[]args){
       Scanner Input=new Scanner(System.in);
       System.out.print("Enter the String:");
       String str=Input.nextLine();
       getsubString(str);
    }
}
