package Recursion;

import java.util.ArrayList;
import java.util.List;

public class example {

    public static void solved(String input,List<String>ans,List<List<String>>list,int idx){
        if(idx==input.length()){
            list.add(new ArrayList<>(ans));
            return;
        }

        for(int i=idx;i<input.length();i++){
            ans.add(input.charAt(i)+"");
            if(ans.size()%3==0&&Integer.parseInt(ans.get(i))<=255){
                ans.add('.'+"");
                solved(input,ans,list,i+1);
                ans.remove(ans.size()-1);
            }

        }
    }
    public static List<List<String>>ip(String s){
        List<List<String>>list=new ArrayList<>();
        List<String>ans=new ArrayList<>();
        solved(s,ans,list,0);
       return list;
    }
    public static void main(String[] args) {


    }
}
