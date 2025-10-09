```java

class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int i = 0; // even index
        int j = 1; // odd index
        int n = nums.length;

        while (i < n && j < n) {
            if (nums[i] % 2 == 0) {
                i += 2; // already correct
            } else if (nums[j] % 2 == 1) {
                j += 2; // already correct
            } else {
                // swap using your expression if you want
                nums[i] = nums[j] + nums[i] - (nums[j] = nums[i]);
                i += 2;
                j += 2;
            }
        }

        return nums;
    }
}

```
