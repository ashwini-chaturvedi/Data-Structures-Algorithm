```java

class Solution {

    public int longestSquareStreak(int[] nums) {
        //Use Set to Store the Numbers
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            int currLen = 0;
            long currNum = nums[i];

            while (set.contains((int) currNum)) { //if set contains the Square of the currNumber then keep going on
                currLen++;
                if ((currNum * currNum) > 1e5) break; //if the square goes out of constraint
                currNum *= currNum;
            }
            maxLen = Math.max(maxLen, currLen);
        }

        return maxLen < 2 ? -1 : maxLen; //The length of the subsequence is at least 2
    }
}


```
