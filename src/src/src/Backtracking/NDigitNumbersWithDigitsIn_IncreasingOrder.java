package Backtracking;

import java.util.ArrayList;

public class NDigitNumbersWithDigitsIn_IncreasingOrder {
    public static void solve(int n,ArrayList<Integer>ans,ArrayList<Integer>list){
        if(n==0){
            int res=0;
            for(int i=0;i<ans.size();i++){
                res=res*10+ans.get(i);
            }
            list.add(res);
            return;
        }
        for(int i=1;i<=9;i++){
            if(ans.isEmpty() ||i>ans.get(ans.size()-1)){
                ans.add(i);
                solve(n-1,ans,list);
                ans.remove(ans.size()-1);
            }
        }

    }
    public static ArrayList<Integer> increasingNumbers(int n) {
        // code here
        ArrayList<Integer>list=new ArrayList<>();
        if(n==1){
            for(int i=0;i<=9;i++){
                list.add(i);
            }
            return list;
        }
        ArrayList<Integer>ans=new ArrayList<>();
        solve(n,ans,list);
        return list;
    }
    public static void main(String[]args){

        System.out.println(increasingNumbers(2));
    }
}
