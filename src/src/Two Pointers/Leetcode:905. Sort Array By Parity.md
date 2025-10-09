```java
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        if(nums.length<=1) return nums;

        int i=0;
        int j=nums.length-1;

        while(i<j){
            if(nums[i]%2==0 && nums[j]%2==0){
                i++;
            }else if(nums[i]%2!=0 && nums[j]%2==0){
                nums[i]=nums[j]+nums[i]-(nums[j]=nums[i]);
                i++;
                j--;
            }else{
                j--;
            }
        }

        return nums;
    }
}
```
