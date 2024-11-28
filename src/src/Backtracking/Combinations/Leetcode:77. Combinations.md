```java
class Solution {

    public void solve(int idx, int n, int k, List<List<Integer>> list, List<Integer> ans) {

        if (ans.size() == k) {
            list.add(new ArrayList<>(ans));//Add new ArrayList because if you just add ans then when we modify ans the ans in the list will also get modify so that is why add new ArrayList
            return;
        }
        for (int i = idx; i <= n; i++) {
            ans.add(i);
            solve(i + 1, n, k, list, ans);
            ans.remove(ans.size() - 1);//Backtracking
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        solve(1, n, k, list, ans);
        return list;
    }
}

```
