Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

 

Example 1:

Input: candidates = [2,3,6,7], target = 7

Output: [[2,2,3],[7]]

Explanation:

2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.

```java
class Solution {
    public void solve(int[] candidates,int target,List<List<Integer>>list,List<Integer>ans,int idx){
        if(idx==candidates.length || target==0){

            if(target==0){
                list.add(new ArrayList<>(ans));
            }
            return;            
        }

        for(int i=idx;i<candidates.length;i++){
            if(target-candidates[i]>=0){
                ans.add(candidates[i]);
                solve(candidates,target-candidates[i],list,ans,i);//i not i+1 because each element can be taken multiple times like unbounded knapsack
                ans.remove(ans.size()-1);
            }
        }

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>list=new ArrayList<>();
        List<Integer>ans=new ArrayList<>();

        solve(candidates,target,list,ans,0);

        return list;

    }
}
```
