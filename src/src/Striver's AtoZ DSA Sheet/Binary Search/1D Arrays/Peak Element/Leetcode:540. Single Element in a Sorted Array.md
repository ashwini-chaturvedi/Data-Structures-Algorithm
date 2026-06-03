You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.

 

Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2

```java
class Solution {

    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int n = nums.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if ((mid == 0 || nums[mid - 1] != nums[mid]) && (mid == n - 1 || nums[mid] != nums[mid + 1])) {
                return nums[mid];
            } else if (mid == 0 || nums[mid - 1] == nums[mid]) {
                if (mid % 2 == 0) { //agar mid+1 odd h toh mid even hoga so left move kro
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (mid == n - 1 || nums[mid] == nums[mid + 1]) {
                if (mid % 2 == 0) { //agar mid+1 odd h toh mid even hoga so left move kro
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}

```
