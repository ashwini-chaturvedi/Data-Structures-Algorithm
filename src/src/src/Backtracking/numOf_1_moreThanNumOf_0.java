package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class numOf_1_moreThanNumOf_0 {
    public static List<String>num(int n,int one,int zero,String output,List<String>list){
        if(n==0){
            list.add(output);
            return list;
        }
        if(one==zero){
            String op1=output+"1";//when count of one and zero become equal we will now choose 1 because we want numOf1>numOf0...
            num(n-1,one+1,zero,op1,list);
        }else{
            String op2=output+"1";
            String op3=output+"0";
            num(n-1,one+1,zero,op2,list);
            num(n-1,one,zero+1,op3,list);

        }
        return list;
    }
    public static void main(String[]args){
        int n=10;
        List<String> list=new ArrayList<>();
        String output="";


        System.out.println(num(n,0,0,output,list));
    }
}
