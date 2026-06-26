```java
class Solution {
    public int solve(int[] nums,int low,int high){

        if(low>high) return 0;
        if(low==high) return nums[low];

        //Take the Differences of my best result and the further results
        int take_low=nums[low]-solve(nums,low+1,high);
        int take_high=nums[high]-solve(nums,low,high-1);

        return Math.max(take_low,take_high);//Return the Maximum Difference 
    }
    public boolean predictTheWinner(int[] nums) {
       int maximumDiff=solve(nums,0,nums.length-1);//Maximum difference b/w the values of choosing low and high values.


        return maximumDiff>=0;
    }
}
```
