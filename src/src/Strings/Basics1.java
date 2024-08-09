package Strings;
import java.util.*;
public class Basics1 {
    public static void main(String[]args){
        Scanner I=new Scanner(System.in);
        //Declaration & Initialization
        String str=new String("Ashwini");
        System.out.println(str);//Printing string str.

        //Inbuilt methods
        System.out.println(str.length());//Length()
        System.out.println(str.charAt(3));//Displays the Character at given Index.
//        for(int i=0;i<str.length();i++){
//            System.out.print(str.charAt(i));
//        }

        System.out.println(str.contains("i"));//contains();
        System.out.println(str.toLowerCase());
        System.out.println(str.toUpperCase());
        System.out.println(str.substring(2,6));//Element at 2 Included and Element at 6 is excluded.


    }

}
