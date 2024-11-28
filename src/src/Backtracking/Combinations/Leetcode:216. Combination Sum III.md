```java
class Solution {
    public void solve(int[]nums,int target,int k,List<List<Integer>>list,List<Integer>ans,int idx){
        if(target==0&&ans.size()==k){//Size of the Possible Combination should be k and the sum should be equal to n.
            list.add(new ArrayList<>(ans));
        }
        for(int i=idx;i<nums.length;i++){
           if(nums[i]<=target){
            ans.add(nums[i]);
            solve(nums,target-nums[i],k,list,ans,i+1);
            ans.remove(ans.size()-1);
           }

        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = new int[9];//Only 0 to 9 are Used
        //Make the List of Elements
        for (int i = 1; i <= 9; i++) {
            nums[i - 1] = i;
        }

        int target = n;
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        solve(nums, target, k, list, ans, 0);
        return list;
    }
}
```
