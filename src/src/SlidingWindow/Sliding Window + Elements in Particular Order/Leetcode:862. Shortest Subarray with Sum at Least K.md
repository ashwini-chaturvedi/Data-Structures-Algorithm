# Sliding Window + Elements in Increasing Order so that sum can Equal to k

```java
/*
                Sliding Window + Element in a Particular Order(Increasing or Decreasing Order)
1.To maintain the Order we can use Monotonic(Stack,queue,Dequeue).
2.Find the Cummulative Sum
3.Whenever there is a dip in the Cummulative Sum which means there is a Negative Integer in the Array so we will discard the Elements prior to it and remove the Index from the dequeue.
    e.g. nums=[84,-37,37,40,95]
         cummulativeSum=[84,47,84,124,219]
         in above example 47 i.e. index 1 is the dipping point so we will discard all the Elements Prior to it which is 84.
*/
class Solution {

    public int shortestSubarray(int[] nums, int k) {
        Deque<Integer> MonotonicDequeue = new LinkedList<>(); //Dequeue to Store the Index in Monotonically increasing Order

        long[] cummulativeSum = new long[nums.length]; //Array to Store the cummulative sum

        //Sliding Window
        int i = 0;
        int j = 0;
        int minLen = Integer.MAX_VALUE;
        while (j < nums.length) {
            //Calculating the cummulative sum
            if (j == 0) {
                cummulativeSum[j] = nums[j];
            } else {
                cummulativeSum[j] = cummulativeSum[j - 1] + nums[j];
            }

            //Checking for the COndition
            if (cummulativeSum[j] >= k) {
                minLen = Math.min(minLen, j - i + 1);
            }

            //Applying the Logic of Sliding Window + Elements in a Particulart Order(Increasing/Decreasing).

            //Now Checking if we need to Shrink the Window

            while (!MonotonicDequeue.isEmpty() && (cummulativeSum[j] - cummulativeSum[MonotonicDequeue.peekFirst()]) >= k) { //if the difference between Cummulative sum of currIndex and the Index at the first in the deque is greater than 'k' it means that the Elements between currIndex and the Index at first of deque  has sum which is greater then k
                minLen = Math.min(minLen, j - MonotonicDequeue.pollFirst()); //find the minLength and remove the element from the dequeue this way we will shrink the window
            }

            //For Negative Elements
            while (!MonotonicDequeue.isEmpty() && cummulativeSum[j] <= cummulativeSum[MonotonicDequeue.peekLast()]) { //if there is a dip in the cummulative sum so there is a Negative Element Present because cummulative sum always Increase for Positive Integer.
                //We know that when ever we will Encounter a Negative Element we will Remove the Elements prior to it from Consideration because it is giving a Dip and we can find a good answer later in the question...
                MonotonicDequeue.pollLast(); //Remove all the Index of the Elements prior to the Negative Element.
            }
            MonotonicDequeue.addLast(j); //Add the Index in the monotonic Dequeue... Storing Index in Dequeue to find the length of the subarray
            j++;
        }
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}

```
