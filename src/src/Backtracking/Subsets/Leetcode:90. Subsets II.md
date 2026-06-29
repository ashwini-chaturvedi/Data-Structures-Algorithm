Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,2]

Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

```java
class Solution {

    public void solve(int[] nums, List<List<Integer>> list, List<Integer> ans, int idx) {
        list.add(new ArrayList<>(ans));

        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i - 1] == nums[i]) continue;
            ans.add(nums[i]);

            solve(nums, list, ans, i + 1);

            ans.remove(ans.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        solve(nums, list, ans, 0);

        return list;
    }
}

```
