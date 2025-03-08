You are given a 0-indexed 2D integer matrix grid of size n * n with values in the range [1, n2]. Each integer appears exactly once except a which appears twice and b which is missing. The task is to find the repeating and missing numbers a and b.

Return a 0-indexed integer array ans of size 2 where ans[0] equals to a and ans[1] equals to b.

 

Example 1:

Input: grid = [[1,3],[2,2]]
Output: [2,4]
Explanation: Number 2 is repeated and number 4 is missing so the answer is [2,4].
Example 2:

Input: grid = [[9,1,7],[8,9,2],[3,4,6]]
Output: [9,5]
Explanation: Number 9 is repeated and number 5 is missing so the answer is [9,5].

```java
class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grids) {
        int[] res = new int[2];
        int n = grids.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= (n * n); i++) {
            set.add(i);
        }

        for (int[] grid : grids) {
            for (int ele : grid) {
                if (!set.contains(ele)) {
                    res[0] = ele;
                }

                set.remove(ele);
            }
        }
        for (int num : set) {
            res[1] = num;
        }

        return res;
    }
}
```
