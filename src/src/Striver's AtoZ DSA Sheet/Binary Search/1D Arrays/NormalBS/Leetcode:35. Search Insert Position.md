Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
```java
class Solution {
    public int searchInsert(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;

        int ans=low;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                ans=mid+1;
                low=mid+1;
            }else{
                ans=mid;
                high=mid-1;
            }
        }

        return ans<0?0:ans;
    }
}
```
