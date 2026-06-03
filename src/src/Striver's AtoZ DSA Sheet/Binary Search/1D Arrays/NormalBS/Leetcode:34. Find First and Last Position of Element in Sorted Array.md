Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
```java
class Solution {
    public int BS(int[] nums,int target,boolean isFirst){
        int low=0;
        int high=nums.length-1;

        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;

            if(nums[mid]==target){
                ans=mid;
                if(isFirst){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }else if(nums[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }

        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] res=new int[2];

        res[0]=BS(nums,target,true);
        res[1]=BS(nums,target,false);

        return res;
    }
}
```
