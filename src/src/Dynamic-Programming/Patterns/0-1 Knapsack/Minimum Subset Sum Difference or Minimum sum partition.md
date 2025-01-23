```java
class Solution {

    public int minDifference(int nums[]) {
        // Calculate the total sum of the array elements (range of possible subset sums).
        int range = 0;
        for (int num : nums) {
            range += num;
        }

        // Create a DP table to store whether a particular subset sum is possible.
        boolean[][] topDown = new boolean[nums.length + 1][range + 1];

        // Initialize the DP table:
        // If there are no numbers (i == 0), we cannot form any subset sum except 0.
        // If the required sum is 0 (j == 0), we can always achieve it using an empty subset.
        for (int i = 0; i < nums.length + 1; i++) {
            for (int j = 0; j < range + 1; j++) {
                if (i == 0) topDown[i][j] = false; // No numbers, can't form a non-zero subset sum.
                if (j == 0) topDown[i][j] = true;  // Subset sum of 0 is always possible (empty subset).
            }
        }

        // Fill the DP table using the subset sum logic.
        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 1; j < range + 1; j++) {
                if (nums[i - 1] <= j) { // If the current number can be included in the subset.
                    boolean include = topDown[i - 1][j - nums[i - 1]]; // Include the current number.
                    boolean exclude = topDown[i - 1][j];               // Exclude the current number.
                    topDown[i][j] = include || exclude;                // Subset sum is possible if either case is true.
                } else {
                    topDown[i][j] = topDown[i - 1][j]; // Current number cannot be included, inherit the previous state.
                }
            }
        }

        // Find the subset sums closest to range / 2 to minimize the difference.
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= range / 2; i++) {
            if (topDown[nums.length][i]) list.add(i); // Add possible subset sums to the list.
        }

        // Calculate the minimum difference between the two subset sums.
        return range - 2 * list.get(list.size() - 1); // Subtract twice the maximum subset sum from the total sum.
    }
}

```
