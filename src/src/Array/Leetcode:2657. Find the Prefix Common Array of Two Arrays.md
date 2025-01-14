```java
class Solution {

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length; // Length of the input arrays
        int[] res = new int[n]; // Result array to store the prefix common counts
        Set<Integer> set = new HashSet<>(); // Set to keep track of unique elements seen so far

        // Initialize the first index of the result array
        // If the first elements of A and B are equal, set res[0] to 1; otherwise, 0
        res[0] = A[0] == B[0] ? 1 : 0;

        // Add the first elements of A and B to the set
        set.add(A[0]);
        set.add(B[0]);

        // Iterate through the rest of the arrays
        for (int i = 1; i < n; i++) {
            if (A[i] == B[i]) {
                // If the current elements of A and B are the same,
                // Increment the previous count in the result array by 1
                res[i] = res[i - 1] + 1;
                // Add the common element to the set
                set.add(A[i]);
            } else {
                // If A[i] and B[i] are different,
                // Add 1 to the previous count for each element already in the set
                res[i] = res[i - 1] + (set.contains(A[i]) ? 1 : 0) + (set.contains(B[i]) ? 1 : 0);
                // Add the current elements of A and B to the set
                set.add(A[i]);
                set.add(B[i]);
            }
        }
        return res; // Return the result array
    }
}

```
