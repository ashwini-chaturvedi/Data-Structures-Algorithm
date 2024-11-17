```java
class Solution {
    public int minSubArrayLen(int k, int[] nums) {
        int i = 0;
        int j = 0;
        long sum = 0;
        int minLen = Integer.MAX_VALUE;
        while (j < nums.length) {
            sum += nums[j];

            while (sum >= k) {
                minLen = Math.min(minLen, j - i + 1);
                sum -= nums[i];
                i++;
            }
            j++;
        }
        
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    
    }
}
```
