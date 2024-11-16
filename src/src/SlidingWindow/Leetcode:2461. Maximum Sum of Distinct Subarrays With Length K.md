```java
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();//to check for Duplicate elements.

        long ans = 0;
        long currSum = 0;
        //Sliding Window
        int i = 0;
        int j = 0;

        while (j < n) {

            //if there is a Duplicate in the window move i untill the duplicate element is not removed from the Window
            while (set.contains(nums[j])) {
                set.remove(nums[i]);
                currSum -= nums[i];//Remove the value from the sum.
                i++;
            } 

            //Calculate the sum of the Elements in the window
            currSum += nums[j];
            set.add(nums[j]);

            if ((j - i + 1) == k) {//when window size is equal to k
                //Calculate the maxAnswer
                ans = Math.max(ans, currSum);

                //Shrink the window
                set.remove(nums[i]);                
                currSum -= nums[i];
                i++;
            }
            j++;
        }
        return ans;
    }
}
```
