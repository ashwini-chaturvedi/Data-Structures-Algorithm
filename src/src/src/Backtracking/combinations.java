package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class combinations {
    public static void solve(int n,int k,List<List<Integer>>list,List<Integer>ans){
        if(k==0){
            list.add(new ArrayList<>(ans));
            return;
        }
        for(int i=1;i<n;i++){
            if(ans.isEmpty()||i>ans.get(ans.size()-1)){
                ans.add(i);
                solve(n+1,k-1,list,ans);
                ans.remove(ans.size()-1);
            }
        }
    }
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>>list=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        if(k==1){
            for(int i=1;i<=n;i++){
                List<Integer> res=new ArrayList<>();
                res.add(i);
                list.add(new ArrayList<>(res));
            }

            return list;
        }
        solve(n,k,list,ans);
        return list;
    }

    public static void main(String[] args) {
        System.out.println(combine(3,3));
    }
}
