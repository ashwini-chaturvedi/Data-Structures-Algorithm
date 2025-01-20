Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.

 

Example 1:

Input: piles = [3,6,7,11], h = 8
Output: 4
```java
class Solution {

    // Helper function to determine if Koko can eat all bananas in `h` hours with a given eating speed `mid`
    public boolean canEat(int[] piles, int mid, int h) {
        long curr = 0; // To track the total time required to eat all bananas

        // Iterate through each pile of bananas
        for (int num : piles) {
            // Calculate the time needed to eat the current pile at speed `mid`
            curr += (num + mid - 1) / mid; // This is equivalent to Math.ceil((double)num / mid)

            // If the current time exceeds the maximum allowed hours, return false
            if (curr > Integer.MAX_VALUE) return false;
        }

        // Return true if the total time required is within the given `h` hours
        return (int) curr <= h;
    }

    // Function to find the minimum eating speed `k` such that Koko can eat all bananas in `h` hours
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE; // To find the largest pile of bananas

        // Determine the upper bound for binary search (maximum pile size)
        for (int num : piles) {
            max = Math.max(max, num);
        }

        int low = 1;    // Minimum possible eating speed (at least 1 banana per hour)
        int high = max; // Maximum possible eating speed (eat the largest pile in 1 hour)
        int res = 0;    // To store the result (minimum eating speed)

        // Perform binary search to find the optimal eating speed
        while (low <= high) {
            int mid = low + (high - low) / 2; // Midpoint of the current speed range

            // Check if Koko can eat all bananas with the current speed `mid`
            if (canEat(piles, mid, h)) {
                res = mid; // Update the result with the current speed
                high = mid - 1; // Try to find a smaller eating speed
            } else {
                low = mid + 1; // Increase the speed
            }
        }

        return res; // Return the minimum eating speed
    }
}

```
