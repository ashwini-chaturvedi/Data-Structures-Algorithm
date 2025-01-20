You are given an integer array bloomDay, an integer m and an integer k.

You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.

The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.

Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.

 

Example 1:

Input: bloomDay = [1,10,3,10,2], m = 3, k = 1
Output: 3
Explanation: Let us see what happened in the first three days. x means flower bloomed and _ means flower did not bloom in the garden.
We need 3 bouquets each should contain 1 flower.
After day 1: [x, _, _, _, _]   // we can only make one bouquet.
After day 2: [x, _, _, _, x]   // we can only make two bouquets.
After day 3: [x, _, x, _, x]   // we can make 3 bouquets. The answer is 3.
```java
class Solution {
    // Time Complexity: O(N * log(maxEle - minEle)), where N is the length of the bloomDay array.
    
    // Function to calculate the number of bouquets that can be made with `mid` as the maximum bloom day
    public int numOfBouquets(int[] bloomDay, int mid, int adjFlowers) {
        int bouquetCount = 0; // Count of bouquets formed
        int consecutiveFlower = 0; // Count of consecutive flowers blooming within `mid` days

        for (int num : bloomDay) {
            if (num <= mid) { 
                // If the flower blooms within `mid` days, count it
                consecutiveFlower++;
            } else {
                // Otherwise, reset the consecutive flower count
                consecutiveFlower = 0;
            }

            // If we have enough consecutive flowers for a bouquet
            if (consecutiveFlower == adjFlowers) {
                bouquetCount++; // Increase bouquet count
                consecutiveFlower = 0; // Reset consecutive flower count for the next bouquet
            }
        }

        return bouquetCount; // Return the total number of bouquets formed
    }

    // Function to find the minimum number of days required to make `m` bouquets
    public int minDays(int[] bloomDay, int m, int k) {
        // Calculate the range of possible bloom days (min and max)
        int min = Integer.MAX_VALUE; // Minimum bloom day in the array
        int max = Integer.MIN_VALUE; // Maximum bloom day in the array
        
        for (int num : bloomDay) {
            min = Math.min(min, num); // Update minimum bloom day
            max = Math.max(max, num); // Update maximum bloom day
        }

        int low = min; // Minimum possible bloom day
        int high = max; // Maximum possible bloom day
        int minDay = -1; // To store the result (minimum bloom day to form `m` bouquets)

        // Binary search for the minimum bloom day
        while (low <= high) {
            int mid = low + (high - low) / 2; // Calculate the mid-point of the current range
            
            // Check if we can make at least `m` bouquets with `mid` as the maximum bloom day
            if (numOfBouquets(bloomDay, mid, k) >= m) {
                minDay = mid; // Update the result with the current `mid`
                high = mid - 1; // Try to find a smaller bloom day
            } else {
                low = mid + 1; // Increase the lower bound
            }
        }

        return minDay; // Return the minimum bloom day, or -1 if it's not possible
    }
}

```
