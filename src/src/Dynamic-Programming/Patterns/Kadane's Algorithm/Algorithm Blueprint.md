# Introduction
According to this Algorithm "It will help to find maximum Subarray sum in any array"
1) Pehle element ko Maximum subarray sum maanlo
2) fir ekk counter for current subarray sum
3) When you move 'i' pointer we have 2 choices
      i. Either we start new Subarray from this 'i' index.
      ii. Or we continue the previous sum and add the current element to it.
     iii. Now Maximum of these two choices will be our current best subarray sum.
4) Maximum of current subarray sum and the previously found one.
5) return maximumValue we have found till now.

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]

Output: 6

Explanation: The subarray [4,-1,2,1] has the largest sum 6.


# Blueprint Code
```java
class Solution {
    int maxSubarraySum(int[] arr) {
        int maxSubSum=arr[0];
        int currSubSum=arr[0];
        
        for(int i=1;i<arr.length;i++){
            int startNewSubarray=arr[i];
            int remainInPrev=arr[i]+currSubSum;
            
            currSubSum=Math.max(startNewSubarray,remainInPrev);
            maxSubSum=Math.max(maxSubSum,currSubSum);
        }
        
        return maxSubSum;
        
    }
}
```

