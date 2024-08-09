package Backtracking;

import java.util.*;

class bruteForce {
    public void solve(int[]nums,int target,List<List<Integer>>list,List<Integer>ans,Set<List<Integer>>set,int idx){
        if(target==0){
            if(!set.contains(ans)){
                set.add(new ArrayList<>(ans));
                list.add(new ArrayList<>(ans));
            }
            return;
        }
        if(idx==nums.length){
            return;
        }
        if(nums[idx]<=target){
            ans.add(nums[idx]);
            solve(nums,target-nums[idx],list,ans,set,idx+1);
            ans.remove(ans.size()-1);
        }
        solve(nums,target,list,ans,set,idx+1);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>>list=new ArrayList<>();
        List<Integer>ans=new ArrayList<>();
        Set<List<Integer>> set=new HashSet<>();
        solve(candidates,target,list,ans,set,0);
        return list;
    }
}
public class CombinationSum_2 {
    public static void main(String[] args) {
        int[] nums={10,1,2,7,6,1,5};
        int target=8;
        bruteForce bf=new bruteForce();
        System.out.println(bf.combinationSum2(nums,target));
    }
}
