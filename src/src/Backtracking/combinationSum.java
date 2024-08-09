package Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class combinationSum {
    public static void solve(int[]nums, int target, List<List<Integer>>list, List<Integer>ans, int idx, Set<List<Integer>> set){
       if(target==0){
           if(!set.contains(ans)){
               set.add(ans);
               list.add(new ArrayList<>(ans));
           }
           return;

       }
       if(target<0||idx==nums.length){
           return;
       }
       ans.add(nums[idx]);
       solve(nums,target-nums[idx],list,ans,idx,set);//to be on current element
        ans.remove(ans.size()-1);
        solve(nums,target,list,ans,idx+1,set);//go to next element

    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>list=new ArrayList<>();
        List<Integer>ans=new ArrayList<>();
        Set<List<Integer>>set=new HashSet<>();
        solve(candidates,target,list,ans,0,set);
        return list;
    }
    public static void main(String[] args) {
        int[]candi={2,3,6,7};

        System.out.println(combinationSum(candi,7));
    }
}
