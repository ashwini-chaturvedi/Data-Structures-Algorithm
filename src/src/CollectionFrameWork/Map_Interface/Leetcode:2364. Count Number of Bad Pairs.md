You are given a 0-indexed integer array nums. A pair of indices (i, j) is a bad pair if i < j and j - i != nums[j] - nums[i].

Return the total number of bad pairs in nums.

 

Example 1:

Input: nums = [4,1,3,3]
Output: 5
Explanation: The pair (0, 1) is a bad pair since 1 - 0 != 1 - 4.
The pair (0, 2) is a bad pair since 2 - 0 != 3 - 4, 2 != -1.
The pair (0, 3) is a bad pair since 3 - 0 != 3 - 4, 3 != -1.
The pair (1, 2) is a bad pair since 2 - 1 != 3 - 1, 1 != 2.
The pair (2, 3) is a bad pair since 3 - 2 != 3 - 3, 1 != 0.
There are a total of 5 bad pairs, so we return 5.

```java
/*
Hint 1
    Would it be easier to count the number of pairs that are not bad pairs?
Hint 2
    Notice that (j - i != nums[j] - nums[i]) is the same as (nums[i] - i != nums[j] - j).
Hint 3
    Keep a counter of nums[i] - i. To be efficient, use a HashMap.
*/
class Solution {

    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long totalPairs = (long) n * (n - 1) / 2;//Formula to find total number of pairs in 'n' length array

        Map<Integer, Integer> map = new HashMap<>();//To store the Occurence of difference 'nums[i]-i'

        //if we can count all the good pairs then we can subtract it from totalPairs to get all the bad pairs.
        long goodPairs = 0;

        for (int i = 0; i < nums.length; i++) {
            int diff = nums[i] - i;

            goodPairs += map.getOrDefault(diff, 0);//if we got the same difference that means the same difference has already occured through difference of some other nums[i]-i hence these both will form a Good pair because 'nums[currI]-currI==nums[prevI]-prevI'.

            map.put(diff, map.getOrDefault(diff, 0) + 1);//Store the Count of the Difference
        }

        return totalPairs - goodPairs;//badPairs=totalPairs-goodPairs.
    }
}

```
