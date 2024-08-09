package Recursion;

import java.util.ArrayList;
import java.util.List;

public class generateBalancedParanthesis {
    public static List<String> recur(int open,int close,String output,List<String>list){
        if(open==0||close==0){
            if(close!=0){
                String out=output+")";
               recur(open,close-1,out,list);
               return list;
            }
            list.add(output);
            return list;
        }
        if(open==close){
            String op1=output+"(";//always opening bracket if open==close

            recur(open-1,close,op1,list);
        }else{
            String op1=output+"(";
            String op2=output+")";
            recur(open-1,close,op1,list);
            recur(open,close-1,op2,list);
        }
        return list;
    }
    public static void main(String[]args){
        int n=3;
        List<String>list=new ArrayList<>();
        System.out.println( recur(n,n,"",list));

    }
}
