```java
class Solution {

    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        int j = 0;
        int res = Integer.MAX_VALUE;

        while (j < nums.length) {
            if (j - i + 1 == k) {
                res=Math.min(res,(nums[j]-nums[i]));
                i++;
            }
            j++;
        }

        return res;
    }
}

```
