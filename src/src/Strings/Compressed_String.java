package Strings;

import java.util.Scanner;

public class Compressed_String {
    public static void main(String[]args){
        Scanner Input=new Scanner(System.in);
        System.out.print("Enter the String:");
        String str=new String(Input.nextLine());
       String ans=""+str.charAt(0);
        int count=1;
        for(int i=1;i<str.length();i++){
            char curr=str.charAt(i);
            char prev=str.charAt(i-1);
            if(curr==prev){
                count++;

            }else {
                ans+=count;
                count =1;
                ans+=curr;
            }

        }
        if(count>1)ans+=count;
        System.out.print(ans);
    }
}
