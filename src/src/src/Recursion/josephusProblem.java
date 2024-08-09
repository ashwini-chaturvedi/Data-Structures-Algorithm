package Recursion;

import java.util.ArrayList;
import java.util.List;

public class josephusProblem {
    public static int josephus(List<Integer>list,int k,int idx){
        if(list.size()==1){
            return list.get(0);//return the only left number...
        }
        idx=(idx+k)%list.size();
        list.remove(idx);//making the input smaller IBH method

        return josephus(list,k,idx);

    }
    public static void main(String[]args){
        int n=5;
        List<Integer>list=new ArrayList<>(n);
        for(int i=0;i<n;i++){
            list.add(i+1);
        }
        int idx=0;
        int k=2;//killing interval
        System.out.println(josephus(list,k-1,idx));
    }
}
