```java
class Solution {
    public int peakIndexInMountainArray(int[] nums) {
        int low=0;
        int high=nums.length-1;

        while(low<=high){
            int mid=low+(high-low)/2;

            if((mid==0 || nums[mid-1]<nums[mid]) && (mid==nums.length-1 || nums[mid]>nums[mid+1])){
                return mid;
            }else if(nums[mid]<nums[mid+1]){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }
}
```
