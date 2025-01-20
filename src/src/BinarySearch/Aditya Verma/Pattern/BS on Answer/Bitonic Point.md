Input: arr[] = [1, 2, 4, 5, 7, 8, 3]

Output: 8

Explanation: Elements before 8 are strictly increasing [1, 2, 4, 5, 7] and elements after 8 are strictly decreasing [3].

```java
class Solution {
    public int findMaximum(int[] nums) {
        int low=0;
        int high=nums.length-1;

        while(low<=high){
            int mid=low+(high-low)/2;

            if((mid==0 || nums[mid-1]<nums[mid]) && (mid==nums.length-1 || nums[mid]>nums[mid+1])){
                return nums[mid];//Return the Biotonic Element
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
