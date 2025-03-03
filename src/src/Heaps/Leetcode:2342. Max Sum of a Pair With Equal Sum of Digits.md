You are given a 0-indexed array nums consisting of positive integers. You can choose two indices i and j, such that i != j, and the sum of digits of the number nums[i] is equal to that of nums[j].

Return the maximum value of nums[i] + nums[j] that you can obtain over all possible indices i and j that satisfy the conditions. If no such pair of indices exists, return -1.

 

Example 1:

Input: nums = [18,43,36,13,7]
Output: 54
Explanation: The pairs (i, j) that satisfy the conditions are:
- (0, 2), both numbers have a sum of digits equal to 9, and their sum is 18 + 36 = 54.
- (1, 4), both numbers have a sum of digits equal to 7, and their sum is 43 + 7 = 50.
So the maximum sum that we can obtain is 54.

```java
class Solution {
    //We will Use Map to Store group of elements having same DigitSum.
    //We will Store Elements in a PriorityQueue because we only want the 2 Maximum Elements to get the Maximum value.
    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
    public int maximumSum(int[] nums) {
        Map<Integer,PriorityQueue<Integer>>map=new HashMap<>();

        for(int num:nums){
            int sum = getDigitSum(num);//Get the Sum 
            map.putIfAbsent(sum, new PriorityQueue<>((a,b)->b-a));//make the pair
            map.get(sum).add(num);
        }

        //Traverse the Map.
        int maxSum=-1;
        for(var e:map.entrySet()){
            if(e.getValue().size()>1){//if the size of priorityQueue corresponding to sum is greater than 2.
                maxSum=Math.max(maxSum,e.getValue().poll()+e.getValue().poll());
            }            
            
        }
        return maxSum;
    }
}
```
