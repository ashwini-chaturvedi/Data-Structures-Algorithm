package Recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class printSubsets {
    public static void subsets(String input, String output, int idx, Set<String>set){
        if(idx==input.length()){
            set.add(output);
            return;
        }
        String op1=output;
        String op2=output+input.charAt(idx);//if Chooses to be a part we will append it to the current string


        subsets(input,op1,idx+1,set);
        subsets(input,op2,idx+1,set);
    }
    public static List<String> solve(String input, String output, int idx,List<String>list){
        if(idx==input.length()){

            list.add(output);
            return list;
        }
        String op1=output;//if we are not choosing
        String op2=output+input.charAt(idx);//if we are choosing that character to be a part of the output string


       solve(input,op1,idx+1,list);
       solve(input,op2,idx+1,list);
       return list;
    }
    public static void main(String[]args){
        String input="112";
        String output="[]";

        List<String> list=new ArrayList<>();
        solve(input,output,0,list);
        System.out.println(list);
        Set<String>set=new HashSet <>();
        subsets(input,output,0,set);
        System.out.println(set);
    }
}
