package Recursion;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public void solve(int[]nums, List<List<Integer>>ans, int idx, List<Integer>subset){
        if(idx==nums.length){
            ans.add(new ArrayList<>(subset));//creating a new list with parameter subset which means subset will get added to the ans
            return;
        }
        //chooses not to be a part of the answer
        solve(nums,ans,idx+1,subset);
        subset.add(nums[idx]);
        //chooses to be a part of the answer so we have first add it to the subset and then we will add it to final result
        solve(nums,ans,idx+1,subset);//did not chooses to be a part
        subset.remove(subset.size()-1);//removing from allPathFromStoT

    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();

        List<Integer>subset=new ArrayList<>();

        solve(nums,ans,0,subset);
        return ans;
    }
}
public class subsets {
    public static void main(String[] args) {
        Solution s=new Solution();
        int []nums={1,2,3};
        System.out.println(s.subsets(nums));
    }
}
