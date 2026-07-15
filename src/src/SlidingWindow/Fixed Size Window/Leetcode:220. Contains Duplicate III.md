You are given an integer array nums and two integers indexDiff and valueDiff.

Find a pair of indices (i, j) such that:

i != j,
abs(i - j) <= indexDiff.
abs(nums[i] - nums[j]) <= valueDiff, and
Return true if such pair exists or false otherwise.

 

Example 1:

Input: nums = [1,2,3,1], indexDiff = 3, valueDiff = 0

Output: true

Explanation: We can choose (i, j) = (0, 3).

We satisfy the three conditions:
i != j --> 0 != 3

abs(i - j) <= indexDiff --> abs(0 - 3) <= 3

abs(nums[i] - nums[j]) <= valueDiff --> abs(1 - 1) <= 0

```java
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        int i=0;
        int j=1;
        TreeSet<Integer> set=new TreeSet<>();
        set.add(nums[i]);

        while(j<nums.length){
            
            if(Math.abs(j-i)>indexDiff){
                set.remove(nums[i]);
                i++;
            }

            //Getting the floor and ceiling value nearer to the current value so that the difference stays in value Diff.
            int floor=set.floor(nums[j])==null?Integer.MAX_VALUE:set.floor(nums[j]);            
            int ceil=set.ceiling(nums[j])==null?Integer.MIN_VALUE:set.ceiling(nums[j]);

            if( (Math.abs(floor-nums[j])<=valueDiff)){
                return true;
            }else if((Math.abs(ceil-nums[j])<=valueDiff)){
                return true;
            }
            
            set.add(nums[j]);
            j++;
        }

        return false;
    }
}
```
