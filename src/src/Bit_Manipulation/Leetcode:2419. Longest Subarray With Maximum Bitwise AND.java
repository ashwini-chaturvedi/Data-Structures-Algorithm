.Theorem About AND
  1.a&a=a //AND of a number with itself will given the number itself
  2.AND of 2 numbers(i.e. a,b) will always be less than equal to the numbers a and b
    (a & b)<=a
    (a & b)<=b
.Approach:
 1. Find the MaxVal in the arrays nums because no other subarray can have more value of bitwise AND then 
    the subarrays of maxVal.
 2. Find the maxLength of the subarray of the maxVal

 Example 1:

  Input: nums = [1,2,3,3,2,3]
  Output: 2
  Explanation:
  The maximum possible bitwise AND of a subarray is 3.// because maximum value is 3 
  //length of subarray of 3 is
   1. Two Length(max)
   2. One Length
  The longest subarray with that value is [3,3], so we return 2.//length of the maximum subarray of 3 is 2



class Solution {

    public int longestSubarray(int[] nums) {
        int maxVal = Integer.MIN_VALUE;
        for (int num : nums) {
            maxVal = Math.max(num, maxVal);
        }

        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            int len = 0;

            while (i<nums.length && nums[i] == maxVal) {//Length of current subarraym having value equal 
                                                        //to maxVal
                len++;
                i++;
            }
            maxLen=Math.max(maxLen,len);
        }
        return maxLen;
    }
}
