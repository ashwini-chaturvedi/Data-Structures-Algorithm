package Backtracking;

import java.util.*;

public class non_DecreasingSubsequence {
    public static void solve(int[] nums, List<Integer> ans, List<List<Integer>> list, int idx, Set<List<Integer>> set) {
        if (idx == nums.length && ans.size() >= 2) {

            if (!set.contains(ans)) {
                for(int i=ans.size()-1;i>0;i--){
                    if(ans.get(i)<ans.get(i-1)){
                        return;
                    }
                }
                set.add(ans);
                list.add(new ArrayList<>(ans));
            }

            return;
        }
        for (int i = idx; i < nums.length; i++) {

            if (ans.size() < 2||ans.get(ans.size() - 1) <= nums[i]) {
                ans.add(nums[idx]);
                solve(nums, ans, list, i + 1, set);
                ans.remove(ans.size() - 1);
            }

            solve(nums, ans, list, idx + 1, set);
        }
    }

    public static List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        solve(nums, ans, list, 0, set);
        return list;
    }//Time Limit Exceeded Method

    //optimised
    public static  void solve(int[] nums, List<Integer> ans, List<List<Integer>> list, int idx) {
        if (ans.size() >= 2) {
            list.add(new ArrayList<>(ans));
        }
        Set<Integer> set = new HashSet<>();
        for (int i = idx; i < nums.length; i++) {
            if ((ans.isEmpty() || nums[i] >= ans.get(ans.size() - 1)) && !set.contains(nums[i])) {
                ans.add(nums[i]);

                solve(nums, ans, list, i + 1);
                ans.remove(ans.size() - 1);
                set.add(nums[i]);
            }
        }
    }

    public static List<List<Integer>> findSubsequence(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        solve(nums, ans, list, 0);
        return list;
    }


    public static void main(String[] args) {
        int[]a={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        System.out.println(findSubsequence(a));

    }
}
