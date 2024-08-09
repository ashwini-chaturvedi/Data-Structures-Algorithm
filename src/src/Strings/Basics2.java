package Strings;

public class Basics2 {
    public static void main(String[]args){
        String str=new String("My Name is Ashwini Chaturvedi");
        str=str+"+91-6306450562";//concatinating String to another string.
        String str1="hii";
        str=str+str1;//Concatinating string str with string str1.
        System.out.println(str+10+"hello"+20+30);//operation will be run from left to right so the numbers 10 20 30 will be changed to String and then they will be attached to the existing string.
        System.out.println(str);

        System.out.println(str.substring(3));
        System.out.println(str.substring(2,15));

        //Difference b/w equals() and '=='.
        String s1="Hello";
        String s2="Hello";
        String s3=new String("Hello");

        System.out.println(s1==s2);//References are Compared.
        System.out.println(s2==s3);//References are Compared.
        System.out.println(s1.equals(s2));//Actual Content of the string is Compared.
        System.out.println(s1.equals(s3));//Actual Content of the string is Compared.






    }
}
