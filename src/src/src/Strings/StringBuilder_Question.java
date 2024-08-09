/**/
package Strings;

import java.util.Scanner;

public class StringBuilder_Question {
    public static void main(String[]args){
        Scanner Input=new Scanner(System.in);
        System.out.print("Enter the String:");
        StringBuilder strb=new StringBuilder(Input.nextLine());//Taking Input.
        System.out.println(strb);
        //toggling the Input String
        //PhYsiCS->pHySIcs
        for(int i=0;i<strb.length();i++){
            //Check if the character is small letter or capital letter.
            boolean flag=true;//capital letter
            char ch=strb.charAt(i);
            if(ch==' '){
                continue;
            }
            int asciiVal=(int)ch;//typecasting
            if(asciiVal<97){
                flag=true;
            }else{
                flag=false;//small letter character.
            }
            if(flag==true){
                asciiVal+=32; //difference b/w any alphabets small letter and capital letter ASCII value is 32.
                //example: A=65 , a=97 ==> 97-65=32;
                char dh=(char)asciiVal;
                strb.setCharAt(i,dh);
            }else {
                asciiVal-=32;
                char sh=(char)asciiVal;
                strb.setCharAt(i,sh);
            }
        }
        System.out.println("Toggled:"+strb);



    }
}
