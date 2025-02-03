You are given an array of integers nums. Return the length of the longest subarray of nums which is either strictly increasing or strictly decreasing. 

Example 1:

Input: nums = [1,4,3,3,2]

Output: 2

Explanation:

The strictly increasing subarrays of nums are [1], [2], [3], [3], [4], and [1,4].

The strictly decreasing subarrays of nums are [1], [2], [3], [3], [4], [3,2], and [4,3].

Hence, we return 2.

Example 2:

Input: nums = [3,3,3,3]

Output: 1

Explanation:

The strictly increasing subarrays of nums are [3], [3], [3], and [3].

The strictly decreasing subarrays of nums are [3], [3], [3], and [3].

Hence, we return 1.

Example 3:

Input: nums = [3,2,1]

Output: 3

Explanation:

The strictly increasing subarrays of nums are [3], [2], and [1].

The strictly decreasing subarrays of nums are [3], [2], [1], [3,2], [2,1], and [3,2,1].

Hence, we return 3.


```java
class Solution {

    public int sDec(int[] nums) {
        int maxDec = 1;
        int dec = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                dec++;
            } else {
                maxDec = Math.max(maxDec, dec);
                dec = 1;
            }
        }

        return Math.max(maxDec, dec);
    }

    public int sInc(int[] nums) {
        int maxInc = 1;
        int inc = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                inc++;
            } else {
                maxInc = Math.max(maxInc, inc);
                inc = 1;
            }
        }
        return Math.max(maxInc, inc);
    }

    public int longestMonotonicSubarray(int[] nums) {
        return Math.max(sInc(nums), Math.max(sDec(nums), 1));
    }
}
```

```java
class Solution {

    public int longestMonotonicSubarray(int[] nums) {
        if (nums.length == 0) return 0; // Handle empty array case
        if (nums.length == 1) return 1; // Single element array

        int maxInc = 1;
        int inc = 1;
        int maxDec = 1;
        int dec = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                inc++;
                maxInc = Math.max(maxInc, inc);
                dec = 1; // Reset decreasing count
            } else if (nums[i] > nums[i + 1]) {
                dec++;
                maxDec = Math.max(maxDec, dec);
                inc = 1; // Reset increasing count
            } else {
                inc = 1; // Reset both when equal
                dec = 1;
            }
        }

        return Math.max(maxInc, maxDec);
    }
}

```
