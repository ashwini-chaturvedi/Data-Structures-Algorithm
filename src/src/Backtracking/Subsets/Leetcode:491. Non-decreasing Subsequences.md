Given an integer array nums, return all the different possible non-decreasing subsequences of the given array with at least two elements. You may return the answer in any order.

 

Example 1:

Input: nums = [4,6,7,7]

Output: [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]

```java
class Solution {

    public void solve(int[] nums, List<List<Integer>> list, List<Integer> ans, int idx) {
        if (ans.size() >= 2) {
            list.add(new ArrayList<>(ans));
        }

        Set<Integer> set = new HashSet<>();//to exclude the duplicacy from the current recurrence.

        for (int i = idx; i < nums.length; i++) {
            if ((ans.isEmpty() || ans.get(ans.size() - 1) <= nums[i]) && !set.contains(nums[i])) {
                ans.add(nums[i]);

                solve(nums, list, ans, i + 1);

                ans.remove(ans.size() - 1);
                set.add(nums[i]);
            }
        }
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        solve(nums, list, ans, 0);

        return list;
    }
}

```
