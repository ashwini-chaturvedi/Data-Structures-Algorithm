```java
class Solution {
    public int binarySearch(int[] nums,int target,boolean isFirst){
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
            }else if(nums[mid]>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int first=binarySearch(nums,target,true);
        int last=binarySearch(nums,target,false);

        return new int[]{first,last};
    }
}
```
