```java
class Solution {
    public int searchInsert(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        int ans=0;
        
        while(low<=high){
            int mid=low+(high-low)/2;
            
            //Handle less than and equal to mid case in one 'if'
            if(nums[mid]<=target){//if the number is less than equal to the target
                ans=nums[mid]==target?mid:mid+1;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
}
```
