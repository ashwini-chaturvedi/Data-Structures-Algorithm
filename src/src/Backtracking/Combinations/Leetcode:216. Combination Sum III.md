Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

 

Example 1:

Input: k = 3, n = 7

Output: [[1,2,4]]

Explanation:

1 + 2 + 4 = 7

There are no other valid combinations.

```java
class Solution {
    public void solve(int n,int target,int[] nums,List<List<Integer>>list,List<Integer>ans,int idx){
        if(n==ans.size()){
            if(target==0){
                list.add(new ArrayList<>(ans));
                
            }
            return;
        }

        for(int i=idx;i<nums.length;i++){
            if(target-nums[i]>=0){
                ans.add(nums[i]);

                solve(n,target-nums[i],nums,list,ans,i+1);//Combination=>i+1

                ans.remove(ans.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums=new int[9];
        for(int i=0;i<9;i++){
            nums[i]=i+1;
        }

        List<List<Integer>>list=new ArrayList<>();
        List<Integer>ans=new ArrayList<>();
        solve(k,n,nums,list,ans,0);

        return list;
    }
}
```
