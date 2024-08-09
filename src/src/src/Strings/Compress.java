package Strings;

import java.util.Scanner;

public class Compress {
    public static int compress(char[]chars){
        int ans=0;
        for(int i=0;i<chars.length;){
            final char letter =chars[i];
            int count=0;
            while(i<chars.length&&chars[i]==letter){
                ++count;
                ++i;
            }
            chars[ans++]=letter;
            if(count>1){
                for(final char c:String.valueOf(count).toCharArray()){
                    chars[ans++]=c;
                }
            }
        }
        return ans;
    }
    public static void main(String[]args){
        Scanner Input=new Scanner(System.in);
        System.out.print("Enter the String:");
        char []chars={'a','a','b','b','c','c','c'};
        compress(chars);
        System.out.println(chars);

    }
}
