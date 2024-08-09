package Backtracking;

import java.util.ArrayList;
import java.util.List;


public class All_Subsets {
    public static void solve(int[]nums, List<Integer>ans, List<List<Integer>>list, int idx){

            list.add(new ArrayList<>(ans));


        for(int i=idx;i<nums.length;i++){
            ans.add(nums[i]);
            solve(nums,ans,list,i+1);
            ans.remove(ans.size()-1);
        }
    }
    public static void solveWithOutLoop(int[]nums, List<Integer>ans, List<List<Integer>>list, int idx){
        if(idx==nums.length){
            list.add(new ArrayList<>(ans));
            return;
        }

        ans.add(nums[idx]);
        solveWithOutLoop(nums,ans,list,idx+1);
        ans.remove(ans.size()-1);
        solveWithOutLoop(nums,ans,list,idx+1);

    }
    public  static List<List<Integer>> subsetXORSum(int[] nums) {
        List<List<Integer>>list=new ArrayList<>();
        List<Integer>ans=new ArrayList<>();
        solveWithOutLoop(nums,ans,list,0);
//        System.out.println("->"+list.get(2).size());
//        System.out.println(list.get(2).get(1));
        return list;
    }
    public static void main(String[] args) {
        int[]nums={1,3};
        System.out.println(subsetXORSum(nums));

    }
}
