A conveyor belt has packages that must be shipped from one port to another within days days.

The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.

Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days.

 

Example 1:

Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
Output: 15
Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
1st day: 1, 2, 3, 4, 5
2nd day: 6, 7
3rd day: 8
4th day: 9
5th day: 10

Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
```java
class Solution {

    // Helper function to determine if it's possible to ship all packages within the given `Days`
    // when the maximum weight capacity of the ship is `maxPackage`.
    public boolean isValid(int[] weights, int maxPackage, int Days) {
        int day = 1; // Start with the first day
        int sum = 0; // Current sum of weights on the ship for the current day

        for (int weight : weights) {
            sum += weight; // Add the current weight to the ship's load

            // If the current ship's load exceeds the allowed `maxPackage` capacity
            if (sum > maxPackage) {
                day++; // Increment the day (start a new shipment)
                sum = weight; // Start the next shipment with the current weight
            }

            // If the required days exceed the given limit, return false
            if (day > Days) return false;
        }

        // If all packages can be shipped within `Days`, return true
        return true;
    }

    // Function to find the minimum capacity of the ship needed to ship all packages within `days`
    public int shipWithinDays(int[] weights, int days) {
        int low = 0; // Minimum possible capacity (at least as much as the heaviest package)
        int high = 0; // Maximum possible capacity (sum of all weights)

        // Calculate the bounds for binary search
        for (int weight : weights) {
            low = Math.max(low, weight); // The ship's capacity must at least be the heaviest package
            high += weight; // Maximum capacity is the sum of all weights (one shipment)
        }

        int res = -1; // To store the result (minimum ship capacity)

        // Perform binary search to find the optimal capacity
        while (low <= high) {
            int mid = low + (high - low) / 2; // Midpoint of the current capacity range

            // Check if it's possible to ship within the given days with `mid` as the capacity
            if (isValid(weights, mid, days)) {
                res = mid; // Update the result with the current capacity
                high = mid - 1; // Try to find a smaller capacity
            } else {
                low = mid + 1; // Increase the capacity
            }
        }

        return res; // Return the minimum ship capacity
    }
}

```
