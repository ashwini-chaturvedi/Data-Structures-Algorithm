package Strings;

import java.util.Scanner;

public class q {

        public static int compress(char[] chars) {
            String str=""+chars[0];
            int count=1;
            for(int i=1;i<chars.length;i++){
                char curr=chars[i];
                char prev=chars[i-1];
                if(curr==prev){
                    count++;
                }else{
                    str+=count;
                    count=1;
                    str+=curr;
                }
            }
            if(count>1){
                str+=count;
            }
            int L=chars.length;
            char []A=str.toCharArray();
            chars=A;
            for(int i=0;i<chars.length;i++){
                chars[i]=A[i];
            }
            System.out.println(A);

            System.out.println(chars);
            return L;
        }

    public static void main(String[]args){
        Scanner Input=new Scanner(System.in);
        System.out.print("Enter the String:");
        char []chars={'a','a','b','b','c','c','c'};
        compress(chars);

    }
}
