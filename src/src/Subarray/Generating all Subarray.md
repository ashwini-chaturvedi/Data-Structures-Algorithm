# Generating all subarrays for an array nums


```java
import java.util.*;

class Solution {

    public List<List<Integer>> generateAllSubarrays(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            List<Integer> current = new ArrayList<>();

            for (int j = i; j < nums.length; j++) {
                current.add(nums[j]);              // Extend current subarray
                result.add(new ArrayList<>(current)); // Store a copy
            }
        }

        return result;
    }
}
```
