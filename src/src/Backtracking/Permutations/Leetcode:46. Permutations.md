```java
class Solution {
    public int[]swap(int[]nums,int idx,int i){
        int temp1=nums[idx];
            nums[idx]=nums[i];
            nums[i]=temp1;
            return nums;
    }
    public void solve(int[]nums,int idx,List<List<Integer>>list){
        if(idx==nums.length){
            List<Integer>ans=new ArrayList<>();
            //converting the int[] to List<Integer>
            for(int num:nums){
                ans.add(num);
            }
            list.add(ans);
            return;
        }
        for(int i=idx;i<nums.length;i++){
            nums=swap(nums,idx,i);//swapping the values in nums array at idx and i index
            solve(nums,idx+1,list);//recursive function call
            nums=swap(nums,idx,i);//Backtracking the values...
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>list=new ArrayList<>();
        solve(nums,0,list);
        return list;
    }
}
```
