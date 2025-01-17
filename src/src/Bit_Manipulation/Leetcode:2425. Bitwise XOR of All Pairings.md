```java
class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        // Calculate the XOR of all elements in nums1
        int xor1 = 0;
        for (int num : nums1) {
            xor1 ^= num; // XOR each element in nums1
        }

        // Calculate the XOR of all elements in nums2
        int xor2 = 0;
        for (int num : nums2) {
            xor2 ^= num; // XOR each element in nums2
        }

        /**
         * The final result depends on the parity (even or odd) of the lengths of nums1 and nums2:
         * - If the length of nums1 is odd, every element in nums2 will be XORed once for each element in nums1.
         *   This means the result will include the XOR of all elements in nums2.
         * - If the length of nums2 is odd, every element in nums1 will be XORed once for each element in nums2.
         *   This means the result will include the XOR of all elements in nums1.
         * - If the length of nums1 or nums2 is even, their contribution to the final XOR will be zero.
         */

        return (nums1.length % 2 * xor2) ^ (nums2.length % 2 * xor1);
        // If nums1.length is odd, include xor2; otherwise, include 0.
        // If nums2.length is odd, include xor1; otherwise, include 0.
    }
}
```
```java
class Solution {

    public int xorAllNums(int[] nums1, int[] nums2) {
        // Create a map to store the frequency of each number being XORed
        Map<Integer, Integer> map = new HashMap<>();

        // Iterate through nums1 and calculate how many times each element in nums1 contributes to the XOR
        for (int i = 0; i < nums1.length; i++) {
            // Each element in nums1 is XORed nums2.length times
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + nums2.length);
        }

        // Iterate through nums2 and calculate how many times each element in nums2 contributes to the XOR
        for (int i = 0; i < nums2.length; i++) {
            // Each element in nums2 is XORed nums1.length times
            map.put(nums2[i], map.getOrDefault(nums2[i], 0) + nums1.length);
        }

        // Print the map for debugging (optional, can be removed in production)
        System.out.println(map);

        // Initialize the result to store the final XOR
        int res = 0;

        // Iterate through the map entries
        for (var e : map.entrySet()) {
            // If a number is XORed an odd number of times, it contributes to the result
            // Multiply the number (key) by (value % 2) to account for odd contributions
            res ^= (e.getKey() * (e.getValue() % 2));
        }

        // Return the final XOR result
        return res;
    }
}

```
