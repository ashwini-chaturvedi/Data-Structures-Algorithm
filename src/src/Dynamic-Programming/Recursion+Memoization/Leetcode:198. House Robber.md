```java
class Solution {
    public int solve(int[] nums,int idx,int[] memoiz){
        if(idx>=nums.length) return 0;

        if(memoiz[idx]!=-1) return memoiz[idx];

        int robCurrent=nums[idx]+solve(nums,idx+2,memoiz);//if Robbed the current house cannot rob the Adjacent Houses and hence skip to two plus
        int leaveCurrent=solve(nums,idx+1,memoiz);//if leaved the current house then can go to the adjacent houses.

        return memoiz[idx]=Math.max(robCurrent,leaveCurrent);//Maximum of both the values
    }
    public int rob(int[] nums) {
        int[] memoiz=new int[101];
        Arrays.fill(memoiz,-1);
        return solve(nums,0,memoiz);
    }
}
```
