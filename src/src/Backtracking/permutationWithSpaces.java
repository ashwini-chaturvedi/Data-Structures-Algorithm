package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class permutationWithSpaces {
//    public static List<String>solve(String input,String output,int idx,List<String>list){
//        if(idx==input.length()){
//            list.add(output);
//            return list;
//        }
//
//        String op1=output+input.charAt(idx);
//        String op2=output+"*"+input.charAt(idx);
//        solve(input,op1,idx+1,list);
//        solve(input,op2,idx+1,list);
//        return list;
//    }
    public static List<String>solve(String input,String output,List<String>list,int idx){
        if(idx==input.length()){
            list.add(output);
            return list;
        }
        char ch=input.charAt(idx);
        if((ch-'0')>=0&&(ch-'0')<=9){
            String op0=output+ch;

            solve(input,op0,list,idx+1);
        }else if((ch-'a')>=0&&(ch-'a')<=25){
            int ascii=(int)ch;
            char chars=(char)(ascii-32);
            String op1=output+ch;
            String op2=output+chars;
            solve(input,op1,list,idx+1);
            solve(input,op2,list,idx+1);
        }else if((ch-'A')>=0&&(ch-'A')<=25){
            int ascii=(int)ch;
            char chars=(char)(ascii+32);
            String op1=output+ch;
            String op2=output+chars;
            solve(input,op1,list,idx+1);
            solve(input,op2,list,idx+1);
        }


        return list;

    }
    public static List<String> letterCasePermutation(String s) {
        List<String>list=new ArrayList<>();
        String output="";
        return solve(s,output,list,0);
    }
    public static void main(String[]args){
//        String input="ABC";
//        List<String>list=new ArrayList<>();
//        String output=input.charAt(0)+"";
//
//        System.out.println(solve(input,output,1,list));
//        String input="a1b2";
        String input="C";
        System.out.println(letterCasePermutation(input));
    }
}
