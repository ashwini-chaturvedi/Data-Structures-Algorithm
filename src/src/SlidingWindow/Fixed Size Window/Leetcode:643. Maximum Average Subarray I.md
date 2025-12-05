You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.

 

Example 1:

Input: nums = [1,12,-5,-6,50,3], k = 4

Output: 12.75000

Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75

```java
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int i=0;
        int j=0;
        double sum=0;
        double avg=Integer.MIN_VALUE;

        while(j<nums.length){
            sum+=nums[j];

            if(j-i+1==k){
                avg=Math.max(avg,sum/k);
                sum-=nums[i];
                i++;
            }
            j++;
        }
        return avg;
    }
}
```
