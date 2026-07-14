We have an array of integers, nums, and an array of requests where requests[i] = [starti, endi]. The ith request asks for the sum of nums[starti] + nums[starti + 1] + ... + nums[endi - 1] + nums[endi]. Both starti and endi are 0-indexed.

Return the maximum total sum of all requests among all permutations of nums.

Since the answer may be too large, return it modulo 109 + 7.

 

Example 1:

Input: nums = [1,2,3,4,5], requests = [[1,3],[0,1]]

Output: 19

Explanation: One permutation of nums is [2,1,3,4,5] with the following result: 

requests[0] -> nums[1] + nums[2] + nums[3] = 1 + 3 + 4 = 8

requests[1] -> nums[0] + nums[1] = 2 + 1 = 3

Total sum: 8 + 3 = 11.

A permutation with a higher total sum is [3,5,4,2,1] with the following result:

requests[0] -> nums[1] + nums[2] + nums[3] = 5 + 4 + 2 = 11

requests[1] -> nums[0] + nums[1] = 3 + 5  = 8

Total sum: 11 + 8 = 19, which is the best that you can do.


```java
class Solution {
    static int MOD = 1000000007;

    public void reverse(int[] nums){
        int low=0;
        int high=nums.length-1;
        
        while(low<high){
            int temp=nums[low];
            nums[low]=nums[high];
            nums[high]=temp;
            
            low++;
            high--;
        }
    } 
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        //Difference Array Technique.
        int[] prefixSum = new int[nums.length ];

        for (int[] request : requests) {
            int start = request[0];
            int end = request[1];

            prefixSum[start] += 1;

            if(end+1<nums.length){
                prefixSum[end + 1] += (-1);
            }
            
        }

        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + prefixSum[i];
        }

        //sort them in Reverse Order
        Arrays.sort(nums);
        Arrays.sort(prefixSum);
        reverse(nums);
        reverse(prefixSum);

        long sum = 0;

        for (int i = 0; i<nums.length; i++) {
            sum = (sum +  ((long)nums[i] * prefixSum[i]) % MOD);
        }

        return (int) (sum % MOD);
    }
}

```
