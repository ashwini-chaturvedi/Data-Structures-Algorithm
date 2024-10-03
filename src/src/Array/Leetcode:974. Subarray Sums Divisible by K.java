class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int result = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Initialize the map with 0 remainder having one occurrence

        for (int num : nums) {
            sum += num;
            int remainder = sum % k;

            // Handle negative remainders to always have positive values
            if (remainder < 0) remainder += k;

            if (map.containsKey(remainder)) {
                result += map.get(remainder);
            }

            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }

        return result;
    }
}
