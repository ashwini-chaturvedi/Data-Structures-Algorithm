# Combination Sum:1 + Sorting so that Duplicate Elements are Together
```java
class Solution {

    public void solve(int[] candidate, int target, List<Integer> ans, List<List<Integer>> list, int idx) {
        if (target == 0) {
            list.add(new ArrayList<>(ans));
        }
        for (int i = idx; i < candidate.length; i++) {

            if (i > idx && candidate[i] == candidate[i - 1]) continue;//This is to avoid the Duplicate Element i>idx means we are at next Index and candidate[i] == candidate[i - 1] means there is a Duplicate Element...

            if (candidate[i] <= target) {
                ans.add(candidate[i]);
                solve(candidate, target - candidate[i], ans, list, i + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidate, int target) {
        Arrays.sort(candidate);//Sorting the Array so that all the Duplicate Elements gets accumlated one after other.Duplicate Elements gets together
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        solve(candidate, target, ans, list, 0);
        return list;
    }
}

```
