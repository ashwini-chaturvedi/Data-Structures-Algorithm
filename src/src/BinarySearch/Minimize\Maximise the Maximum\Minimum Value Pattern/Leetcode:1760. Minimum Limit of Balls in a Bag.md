```java 

class Solution {
    //Minimize the Maximum Type Problem...

    //Here we have minimum possible balls that can be in a Bag which is 1 and maximum Possible ball which is maximum Ball in any bag 
    //so we will apply Binary Search on the Answer to check if the balls in the Bag can be divisible in mid number of balls with in the constraint of number of Operations allowed.

    public boolean isDivisble(int[] nums, int mid, int maxOpr) {
        int totalOps = 0;

        for (int num : nums) {
            //if num=17,mid=4 then operations=17/4=4 so it takes 4 steps to make number equal to the mid value... 
            totalOps += num / mid;//this much operation it will take to make number equal to the mid value 
//if num=16,mid=4 then, Operations=16/4=4 ,but it takes 3 operation so decrease it by 1...
            if (num % mid == 0) totalOps -= 1;//if the number is whollaly divisible minus 1 from it...
        }

        return totalOps <= maxOpr;
    }

    public int minimumSize(int[] nums, int maxOperations) {
        int maxVal = -1;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        int low = 1; //Best case secenario when all the Bags have only 1 Ball But can this be achieved in maxOperations that is our concern
        int high = maxVal; //Worst case scenario when there is no operation done and penalty can be maxValue

        int res = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isDivisble(nums, mid, maxOperations)) { //we try to divide the elements or balls in mid number of times to make it fit in the question.
                res = mid;
                high = mid - 1; //Minimize the Maximum Value
            } else {
                low = mid + 1;
            }
        }
        return res;
    }
}
```
