Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

 

Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2

Output: 6

Explanation: [1,1,1,0,0,1,1,1,1,1,1]

Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

```java
class Solution {

    public int longestOnes(int[] nums, int k) {
        int zeroCount = 0;
        int i = 0;
        int j = 0;
        int oneCount = 0;

        while (j < nums.length) {
            if (nums[j] == 0) zeroCount++;

            while (zeroCount > k) {//at most k 0's can be flipped...
                if (nums[i] == 0) zeroCount--;
                i++;
            }
            oneCount = Math.max(oneCount, j - i + 1);

            j++;
        }
        return oneCount;
    }
}

```
