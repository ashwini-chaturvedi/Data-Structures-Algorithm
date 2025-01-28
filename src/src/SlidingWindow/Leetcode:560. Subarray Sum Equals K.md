Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2

```java
class Solution {

    /*
     1.Find the number of Subarray with sum less then k.: This less then k is a loose constraint so there we will use Sliding Window
     2.Find the number of Subarray with sum equal to k.:This equal to k is highly strict constraint so we have to use some other Technique.
    */

    public int subarraySum(int[] nums, int k) {
        int[] prefixSum = new int[nums.length]; //To Store the Prefix Sum

        Map<Integer, Integer> map = new HashMap<>(); //To Store the Occurence of the Element with its Frequency
        map.put(0, 1); //we will Put Zero Priorily because there may be some Element,or sum of Elements which will Give Exact equal to k and when we check for sum-k there should be a zero present in the Map.

        prefixSum[0] = nums[0];
        map.put(nums[0], map.getOrDefault(nums[0], 0) + 1); //Store the First Element in the map

        int res = nums[0] == k ? 1 : 0; //if the First Element is Already Equal to 'k' then we will count it and start from plus 1.
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i]; //Prefix Sum

            res += map.getOrDefault(prefixSum[i] - k, 0); //if a prefixsum of a Subarray is equal to k then the prefixSum-k should always occured Previously means agr ek subarray ka sum k ke barabar hoga toh sum-k present hona hi chahiye tbhi pta lgega ki yeh subarray zero se start hua h aur k tk ka sum rkha h.
            //Jitni bar present hoga utni baar subarray sum 'k' ke equal hoga.
            map.put(prefixSum[i], map.getOrDefault(prefixSum[i], 0) + 1); //put the prefixSum into the Map.
        }

        return res;
    }
}

```
