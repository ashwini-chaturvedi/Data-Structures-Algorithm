Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]

Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
```java
class Solution {

    public void solve(int[] nums, List<Integer> ans, List<List<Integer>> list, int idx) {
        list.add(new ArrayList<>(ans));

        for (int i = idx; i < nums.length; i++) {
            ans.add(nums[i]);

            solve(nums, ans, list, i + 1);//Subset=>i+1

            ans.remove(ans.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();

        solve(nums, ans, list, 0);

        return list;
    }
}

```
