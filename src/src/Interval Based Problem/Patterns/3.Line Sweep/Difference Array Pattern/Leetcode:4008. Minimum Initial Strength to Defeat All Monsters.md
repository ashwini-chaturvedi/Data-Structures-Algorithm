You are given an integer array monsters, where monsters[i] represents the strength of the ith monster.

You are also given a 2D integer array boosts, where boosts[i] = [li, ri, vi] indicates that vi is added to your temporary bonus while fighting any monster whose index lies in [li, ri]. Boost ranges may overlap, and the values of all applicable boosts are added together.

You start with a non-negative initial strength and fight the monsters from left to right.

For each monster at index i:

Let bonus be the sum of the values of all boosts that apply to monster i.
You can defeat the monster only if your current strength plus bonus is at least monsters[i].
After defeating the monster, only your current strength decreases by monsters[i]. If it becomes negative, it is set to 0.
Return the minimum initial strength required to defeat all monsters.

Note: The temporary bonus is used only to determine whether the current monster can be defeated. It does not otherwise change your current strength.

 

Example 1:

Input: monsters = [5,10,15], boosts = [[1,1,10]]

Output: 30

Explanation:

Let's start with an initial strength of 30.

monsters[0] = 5: At index 0, the bonus is 0. Since 30 + 0 >= 5, this monster can be defeated. The strength becomes 30 - 5 = 25.

monsters[1] = 10: At index 1, the bonus is 10. Since 25 + 10 >= 10, this monster can be defeated. The strength becomes 25 - 10 = 15.

monsters[2] = 15: At index 2, the bonus is 0. Since 15 + 0 >= 15, this monster can be defeated. The strength becomes 15 - 15 = 0.

Thus, the minimum initial strength required is 30.

Example 2:

Input: monsters = [5,10,15], boosts = [[1,2,10],[1,2,5]]

Output: 5

Explanation:

Let's start with an initial strength of 5.

monsters[0] = 5: The bonus is 0. Since 5 + 0 >= 5, the monster can be defeated. The strength becomes 5 - 5 = 0.

monsters[1] = 10: The two overlapping boosts provide bonus = 10 + 5 = 15. Since 0 + 15 >= 10, the monster can be defeated. The strength remains 0.

monsters[2] = 15: The two overlapping boosts again provide bonus = 15. Since 0 + 15 >= 15, the monster can be defeated. The strength remains 0.

Thus, the minimum initial strength required is 5.

 

Constraints:

- 1 <= monsters.length <= 5 * 104

- 1 <= monsters[i] <= 10^9

- 0 <= boosts.length <= 5 * 104

- boosts[i] == [li, ri, vi]

- 0 <= li <= ri < monsters.length

- 1 <= vi <= 10^9​​


```java
class Solution {
    public boolean isPossible(int[] monsters, long mid, long[] bonus) {
        long strength = mid;
        for (int i = 0; i < monsters.length; i++) {
            if (strength + bonus[i] < monsters[i]) {
                return false;
            }
            strength -= monsters[i];
            if (strength < 0) strength = 0;
        }
        return true;
    }

    public long minInitialStrength(int[] monsters, int[][] boosts) {
        int n = monsters.length;
        
        long sum = 0;
        for (int num : monsters) 
            sum += num;

        // diff array over monster indices to accumulate overlapping boosts
        long[] diff = new long[n + 1];
        for (int[] b : boosts) {
            int l = b[0], r = b[1];
            long v = b[2];
            if (l >= n) continue;
            r = Math.min(r, n - 1);
            diff[l] += v;
            diff[r + 1] -= v;
        }

        long[] bonus = new long[n];
        long cur = 0;
        for (int i = 0; i < n; i++) {
            cur += diff[i];
            bonus[i] = cur;
        }

        long low = 0, high = sum, strength = sum;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (isPossible(monsters, mid, bonus)) {
                strength = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return strength;
    }
}
```​​​​
