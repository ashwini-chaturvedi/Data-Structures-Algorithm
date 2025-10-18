```java
class Solution {

    public int[] productExceptSelf(int[] nums) {
        int zeroIdx = -1;
        int count=0;
        int product = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroIdx=i;
                count++;

                if(count>=2) return new int[nums.length];
                continue;
            }

            product *= nums[i];
        }

        int[] ans = new int[nums.length];
        
        if (zeroIdx != -1) {
            ans[zeroIdx] = product;
            return ans;
        }

        for (int i = 0; i < nums.length; i++) {
           nums[i]=product/nums[i];
        }
        return nums;
    }
}

```
