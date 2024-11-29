```java
class Solution {
    // Memoization array to store intermediate results
    // memo[ringIdx][kIdx] stores the minimum steps required to spell the substring key[kIdx:] when the ring is at ringIdx
    public int[][] memo = new int[101][101];

    // Helper function to calculate the minimum steps needed to move from ringIdx to i (clockwise or counter-clockwise)
    public int countSteps(int ringIdx, int i, int length) {
        int antiClockWise = Math.abs(i - ringIdx); // Steps to move anti-clockwise
        int clockWise = length - antiClockWise;   // Steps to move clockwise
        return Math.min(antiClockWise, clockWise); // Return the minimum of the two we will adapt that step which is less because we want to take minimum number of steps in spelling the keyword.
    }

    // Recursive function to calculate the minimum steps required to spell key[kIdx:] when the ring is at ringIdx
    public int solve(int ringIdx, int kIdx, String ring, String key) {
        // Base case: All characters in the key have been spelled
        if (kIdx == key.length()) {
            return 0;
        }

        // If the result is already calculated, return the memoized value
        if (memo[ringIdx][kIdx] != -1) {
            return memo[ringIdx][kIdx];
        }

        // Initialize the result as a large value (we're looking for the minimum)
        int res = Integer.MAX_VALUE;

        // Loop through all characters in the ring
        for (int i = 0; i < ring.length(); i++) {
            // If the current character in the ring matches the target character in the key
            if (ring.charAt(i) == key.charAt(kIdx)) {
                // Calculate the steps needed to move from ringIdx to i and press the button
                int steps = 1 + countSteps(ringIdx, i, ring.length()); // 1 step to press the center button
                
                // Recursively calculate the total steps for the remaining key (move to the next character in key)
                int totalSteps = steps + solve(i, kIdx + 1, ring, key);

                // Update the minimum result
                res = Math.min(res, totalSteps);
            }
        }

        // Memoize and return the result for the current state
        return memo[ringIdx][kIdx] = res;
    }

    // Main function to calculate the minimum steps to spell the key
    public int findRotateSteps(String ring, String key) {
        // Initialize the memoization array with -1
        for (int[] num : memo) {
            Arrays.fill(num, -1);
        }

        // Start solving from the initial position (ringIdx = 0) and the first character of the key (kIdx = 0)
        return solve(0, 0, ring, key);
    }
}



```
