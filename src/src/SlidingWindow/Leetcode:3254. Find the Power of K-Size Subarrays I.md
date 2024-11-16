```java
class Solution {
    public boolean isConsecutivelySorted(int[] nums, int i, int k, int[] maxVal) {
        for (int j = i + 1; j < i + k; j++) {
            if (nums[j - 1] + 1 == nums[j] && nums[j] > nums[j - 1]) {// check if the elements are consecutive and are in sorted order.
                maxVal[0] = Math.max(maxVal[0], nums[j]);
            } else
                return false;
        }
        return true;
    }

    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;

        if (n == 1 || k == 1)// Edge Case
            return nums;

        int[] result = new int[n - k + 1];
        int idx = 0;

        for (int i = 0; i < n - k + 1; i++) {// pointer can goes to maximum n-k+1 index
            int[] maxVal = { 0 };

            if (isConsecutivelySorted(nums, i, k, maxVal)) {// check if the Elements in the Window are consecutive and sorted.
                result[idx++] = maxVal[0];
            } else
                result[idx++] = -1;// Else put -1...
        }
        return result;
    }
}
```
