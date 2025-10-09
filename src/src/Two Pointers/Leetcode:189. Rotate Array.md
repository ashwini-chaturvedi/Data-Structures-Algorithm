```java
class Solution {
    public void reverse(int [] nums,int start,int end){
        while(start<end){
            nums[start] = nums[end] + nums[start] - (nums[end] = nums[start]);
            start++;
            end--;
        }
    }
    public void rotate(int[] nums, int k) {
        if(nums.length<=1) return;

        k%=nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
}
```
