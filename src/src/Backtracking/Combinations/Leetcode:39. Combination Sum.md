# Combination + Two Sum 
```java
class Solution {

    public static void solve(int[] nums, int target, List<List<Integer>> list, List<Integer> ans, int idx) {

        if (target == 0) {
            list.add(new ArrayList<>(ans));
        }
        for (int i = idx; i < nums.length; i++) {
            if (nums[i] <= target) {//When Element is less than equal to the target than only it can be a Part of the Answer and can form a sum which is equal to targer 
                ans.add(nums[i]);
                solve(nums, target - nums[i], list, ans, i);//Decreasing the Target as we do in "Two Sum"
// we can pick that element again and again idx will not increase... that is why we only pass i and not i+1
                ans.remove(ans.size() - 1);
            }
        }

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        solve(candidates, target, list, ans, 0);
        return list;
    }
}

```
