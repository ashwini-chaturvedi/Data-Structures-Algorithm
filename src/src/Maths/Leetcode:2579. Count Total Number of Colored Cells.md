There exists an infinitely large two-dimensional grid of uncolored unit cells. You are given a positive integer n, indicating that you must do the following routine for n minutes:

At the first minute, color any arbitrary unit cell blue.
Every minute thereafter, color blue every uncolored cell that touches a blue cell.
Below is a pictorial representation of the state of the grid after minutes 1, 2, and 3.

![img](https://assets.leetcode.com/uploads/2023/01/10/example-copy-2.png)
Return the number of colored cells at the end of n minutes.

Example 1:

Input: n = 1
Output: 1
Explanation: After 1 minute, there is only 1 blue cell, so we return 1.
Example 2:

Input: n = 2
Output: 5
Explanation: After 2 minutes, there are 4 colored cells on the boundary and 1 in the center, so we return 5. 

```java
class Solution {
    public long coloredCells(int n) {
        return 1L + 2L * (n - 1) * n;
    }
}

/*
class Solution {

    public long coloredCells(int n) {
        long count = 0;
        for(int i=1;i<=n;i++){
            count = (i * i) + (long) (Math.pow(i - 1, 2));
        }     

        return count;
    }
}
 */

```
