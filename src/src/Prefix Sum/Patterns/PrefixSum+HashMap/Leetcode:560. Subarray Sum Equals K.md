# Problem: Subarray Sum Equals K

You are given an integer array `nums` and an integer `k`. Return the **total number of subarrays whose sum equals `k`**.

A subarray is a contiguous, non-empty sequence of elements within an array.

## Examples

**Example 1:**

**Input:**
```text
nums = [1,1,1], k = 2
```

**Output:**
```text
2
```

**Example 2:**

**Input:**
```text
nums = [1,2,3], k = 3
```

**Output:**
```text
2
```

## Constraints

- `1 <= nums.length <= 2 * 10^4`
- `-1000 <= nums[i] <= 1000`
- `-10^7 <= k <= 10^7`

```java
class Solution {

    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int count = 0;

        map.put(0, 1);
        int prefixSum = 0;

        for (int num : nums) {
            prefixSum += num;

            if (map.containsKey(prefixSum - k)) {//if this difference was encountered somewhere then sum sum of elements b/w that difference's index and current index is equal to sum so we have a valid subarray
                count+=map.getOrDefault(prefixSum-k,0);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}

```
