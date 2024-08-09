package Array;
import java.util.Arrays;

public class Remove_Duplicate {
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0; // Return 0 if input is null or empty
        }

        int uniqueIndex = 0; // Index to track the position of unique elements

        // Iterate through the array
        for (int i = 1; i < nums.length; i++) {
            // Check if the current element is different from the previous element
            if (nums[i] != nums[uniqueIndex]) {
                // If different, move the current element to the next available position
                uniqueIndex++;
                nums[uniqueIndex] = nums[i];
            }
        }

        // Return the length of the array containing unique elements
        return uniqueIndex + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 4, 3, 2, 1, 5, 6, 5};
        int newLength = removeDuplicates(nums);

        System.out.println("Original array: " + Arrays.toString(nums));
        System.out.print("Array after removing duplicates: [");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i]);
            if (i < newLength - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
