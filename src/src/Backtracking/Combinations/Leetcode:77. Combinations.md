Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

You may return the answer in any order.

 

Example 1:

Input: n = 4, k = 2

Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]

Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.

```java
class Solution {
    public void solve(int n,int k,int idx,List<List<Integer>>list,List<Integer>ans){
        if(idx>n || k==0){
            if(k==0){
                list.add(new ArrayList<>(ans));
            }           
            return;
        }

        for(int i=idx;i<=n;i++){
            ans.add(i);
            solve(n,k-1,i+1,list,ans);//Combination=> i+1
            ans.remove(ans.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>>list=new ArrayList<>();
        List<Integer>ans=new ArrayList<>();
        solve(n,k,1,list,ans);

        return list;
    }
}
```
