package Recursion.Recursion;

public class Strings {
    public static void printString(String str,int idx,StringBuilder sb){
        if(idx>=str.length()){
            System.out.print("String:"+sb.toString());//changing the string builder to string and printing it.
            return;
        }
        if(str.charAt(idx)!='a'){
            sb.append(str.charAt(idx));//appending the characters to the StringBuilder
        }

        printString(str,idx+1,sb);
    }
    public static String printString1(String str,int idx){
        if(idx>=str.length()){
            return ""; //Empty String;
        }
        String res=printString1(str,idx+1);

        if(str.charAt(idx)=='a'){
            return res;
        }else{
            return str.charAt(idx)+res;
        }
    }

    //without Using a parameter or iteration passing new substring each time.
    public static String printString2(String str){
        //base case
        if(str.isEmpty()){
            return ""; //Empty String;
        }
        String res=printString2(str.substring(1));//recursion

        //Self Work
        if(str.charAt(0)=='a'){
            return res;
        }else{
            return str.charAt(0)+res;
        }
    }
    public static void reverse(String str,int idx){
        if(idx==0){
            System.out.print(str.charAt(0));
            return;
        }
        System.out.print(str.charAt(idx));
        reverse(str,idx-1);
    }
    public static boolean flag=true;
//    public static boolean isPalindrome(String str,int Lidx,int Ridx){
//        if(Lidx>=Ridx){
//            return flag;
//        }
//        if(str.charAt(Lidx)!=str.charAt(Ridx)){
//            flag=false;
//        }
//        return isPalindrome(str,Lidx+1,Ridx-1);
//    }
    public static boolean isPalindrome(String str,int Lidx,int Ridx){
        if(Lidx>=Ridx){
            return flag;

        }
        if(str.charAt(Lidx)!=str.charAt(Ridx)){
            flag=false;
            return flag;
        }else{
            return isPalindrome(str,Lidx+1,Ridx-1);
        }

    }
    public static void main(String[]args){
        String str="LeVEL";
        StringBuilder sb=new StringBuilder();
        printString(str,0,sb);
        System.out.println("\nString:"+printString1(str,0));

        System.out.println("\nString2:"+printString2(str));

        reverse(str,str.length()-1);

        str=str.toLowerCase();
        System.out.println("\nisPalindrome by Method 1:"+isPalindrome(str,0,str.length()-1));//




    }
}
