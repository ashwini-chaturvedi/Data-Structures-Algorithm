Given an array of integers arr and two integers k and threshold, return the number of sub-arrays of size k and average greater than or equal to threshold.

 

Example 1:

Input: arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4

Output: 3

Explanation: Sub-arrays [2,5,5],[5,5,5] and [5,5,8] have averages 4, 5 and 6 respectively. All other sub-arrays of size 3 have averages less than 4 (the threshold).

```java
class Solution {
    public int numOfSubarrays(int[] nums, int k, int threshold) {
        int i=0;
        int j=0;
        double sum=0;
        double avg=Integer.MIN_VALUE;
        int count=0;

        while(j<nums.length){
            sum+=nums[j];

            if(j-i+1==k){
                avg=sum/k;
                if(avg>=threshold) count++;
                sum-=nums[i];
                i++;
            }
            j++;
        }
        return count;
    }
}
```
