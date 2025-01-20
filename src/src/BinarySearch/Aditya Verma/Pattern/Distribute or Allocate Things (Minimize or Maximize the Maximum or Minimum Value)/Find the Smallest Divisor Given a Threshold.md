Given an array of integers nums and an integer threshold, we will choose a positive integer divisor, divide all the array by it, and sum the division's result. Find the smallest divisor such that the result mentioned above is less than or equal to threshold.

Each result of the division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).

The test cases are generated so that there will be an answer.

 

Example 1:

Input: nums = [1,2,5,9], threshold = 6
Output: 5
Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1. 
If the divisor is 4 we can get a sum of 7 (1+1+2+3) and if the divisor is 5 the sum will be 5 (1+1+1+2). 
```java
class Solution {

    public boolean isValid(int[] nums, int divisor, int threshold) {
        int sum = 0;

        for (int num : nums) {
            sum += (int) Math.ceil((double) num / divisor);
        }

        return sum <= threshold;//Sum After Division Less than threshold
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = 0;

        for (int num : nums) {//Range of the number can be upto the Maximum number present.
            high =Math.max(high,num);
        }

        // Binary Search (Allocation Pattern).
        int res = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isValid(nums, mid, threshold)) {
                res = mid;//Save the Answer and Move towards low to find the minimum value.
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return res;
    }
}

```
