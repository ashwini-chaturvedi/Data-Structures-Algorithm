/*Important:
    if(a+b)%k==0;
    so,
        int remA=(a%k);
        int remB=(b%k);
        hence,remA+remB==k
*/

class Solution {
    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> remainderMap = new HashMap<>();
        
        // Step 1: Calculate remainders and populate the map
        for (int num : arr) {
            int rem = (num % k + k) % k;  // Handle negative numbers to get a positive remainder
            remainderMap.put(rem, remainderMap.getOrDefault(rem, 0) + 1);
        }
        //There can be Maximum k-1 maximum elements because remainder of numbers will range between 0 to k-1 only.

        // Step 2: Check pairs for remainder 0
        if (remainderMap.getOrDefault(0, 0) % 2 != 0) {
            return false;  // Remainders of 0 must form pairs within themselves
        }

        // Step 3: Check each remainder `i` with its complement `k - i`
        for (int i = 1; i < k; i++) {
            // Only process if the remainder `i` is present in the map
            int freqI = remainderMap.getOrDefault(i, 0);
            int complementFreq = remainderMap.getOrDefault(k - i, 0);
            
            // The frequency of `i` should match the frequency of `k - i`
            if (freqI != complementFreq) {
                return false;
            }
        }

        return true;
    }
}
