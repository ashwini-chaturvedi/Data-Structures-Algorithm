package Bit_Manipulation;

public class MissingAndDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 4, 4, 6, 7};

        // Calculate xorRes
        int xorRes = 0;
        for (int i = 0; i < nums.length; i++) {
            xorRes ^= nums[i] ^ (i + 1);
        }

        // Calculate setBit
        int setBit = xorRes & -xorRes; // Using 2's complement to get the rightmost set bit

        // Initialize L and R
        int L = 0;
        int R = 0;

        // Find L and R
        for (int num : nums) {
            if ((num & setBit) != 0) {
                L ^= num;
            } else {
                R ^= num;
            }
        }

        // Checking which is the duplicate number
        boolean flag = true;
        for (int num : nums) {
            if (R == num) {
                flag = false;
                break;
            }
        }

        // Print the result
        String message = (flag ? L + " is the Missing Number & " + R + " is the Duplicate Number" : R + " is the Missing Number & " + L + " is the Duplicate Number");
        System.out.println(message);
    }
}
