```java
class Solution {
    public boolean canJump(int[] nums) {
        int target=nums.length-1;
        for(int i=nums.length-2;i>=0;i--){
            if(i+nums[i]>=target){
                target=i;
            }
        }
        if(target==0){//we have Reached the End of the array.
            return true;
        }
        return false;
    }
}
```
