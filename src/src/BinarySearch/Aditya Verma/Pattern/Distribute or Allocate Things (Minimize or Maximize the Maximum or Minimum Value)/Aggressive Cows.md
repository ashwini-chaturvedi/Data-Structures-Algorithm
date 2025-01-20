You are given an array with unique elements of stalls[], which denote the position of a stall. You are also given an integer k which denotes the number of aggressive cows. Your task is to assign stalls to k cows such that the minimum distance between any two of them is the maximum possible.

Examples :

Input: stalls[] = [1, 2, 4, 8, 9], k = 3
Output: 3
Explanation: The first cow can be placed at stalls[0], 
the second cow can be placed at stalls[2] and 
the third cow can be placed at stalls[3]. 
The minimum distance between cows, in this case, is 3, which also is the largest among all possible ways.
```java
class Solution {
    public static boolean isValid(int[] Stalls, int minDistance, int Cows) {
        int lastCowPosition = Stalls[0]; // Place the first cow at the first stall
        int count = 1; // First cow is already placed

        for (int i = 1; i < Stalls.length; i++) {
            if (Stalls[i] - lastCowPosition >= minDistance) {
                count++;
                lastCowPosition = Stalls[i]; // Place the next cow here

                if (count == Cows) {
                    return true; // All cows are placed
                }
            }
        }
        return false; // Not all cows could be placed with the given distance
    }

    public static int aggressiveCows(int[] Stalls, int Cows) {
        Arrays.sort(Stalls); // Sort the stalls in ascending order

        int low = 1; // Minimum possible distance
        int high = Stalls[Stalls.length - 1] - Stalls[0]; // Maximum possible distance
        int res = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Middle value of the search range

            if (isValid(Stalls, mid, Cows)) {
                res = mid; // Update result
                low = mid + 1; // Try for a larger distance
            } else {
                high = mid - 1; // Try for a smaller distance
            }
        }
        return res;
    }

}
```
