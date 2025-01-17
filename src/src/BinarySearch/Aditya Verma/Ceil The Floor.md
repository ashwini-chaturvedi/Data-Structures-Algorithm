```java
class Solution {
    public int Ceil(int[] nums,int target){
        int low=0;
        int high=nums.length-1;
        int ans=-1;
        
        while(low<=high){
            int mid=low+(high-low)/2;

            if(nums[mid]>=target){//if the number is less than equal to the target
                ans=mid;//then store it as potential Answer
                high=mid-1;//Move to Higher Value because we want to find the largest value which is near to target
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    public int Floor(int[] nums,int target){
        int low=0;
        int high=nums.length-1;
        int ans=-1;
        
        while(low<=high){
            int mid=low+(high-low)/2;

            if(nums[mid]<=target){//if the number is less than equal to the target
                ans=mid;//then store it as potential Answer
                low=mid+1;//Move to Higher Value because we want to find the largest value which is near to target
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
    public int[] getFloorAndCeil(int x, int[] arr) {
        Arrays.sort(arr);
        
        int floor=Floor(arr,x);
        floor=floor!=-1?arr[floor]:-1;
        
        int ceil=Ceil(arr,x);
        ceil=ceil!=-1?arr[ceil]:-1;
        
        return new int[]{floor,ceil};
    }
}
```
