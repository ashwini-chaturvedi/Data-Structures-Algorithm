package Strings;
import java.util.*;
public class Reverse_EachWord {
    public static void main(String[]args){
         Scanner Input=new Scanner(System.in);
         System.out.println("Enter the string:");
         String str=new String(Input.nextLine());
         String ans="";//Empty String
        StringBuilder sb=new StringBuilder("");
         for(int i=0;i<str.length();i++){
             char ch=str.charAt(i);


                 if(ch!=' '||ch!=' '){
                     sb.append(ch);

                 }else{
                     sb.reverse();
                     ans+=sb;//concatenating strings
                     ans+=" ";//adding spaces between Words.
                 sb=new StringBuilder("");



             }
         }
         sb.reverse();
         ans+=sb;
         System.out.println(ans);
    }
}
