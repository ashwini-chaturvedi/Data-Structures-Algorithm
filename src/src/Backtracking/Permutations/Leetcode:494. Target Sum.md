You are given an integer array nums and an integer target.

You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".

Return the number of different expressions that you can build, which evaluates to target.

 

Example 1:

Input: nums = [1,1,1,1,1], target = 3

Output: 5

Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.

-1 + 1 + 1 + 1 + 1 = 3

+1 - 1 + 1 + 1 + 1 = 3

+1 + 1 - 1 + 1 + 1 = 3

+1 + 1 + 1 - 1 + 1 = 3

+1 + 1 + 1 + 1 - 1 = 3

```java
class Solution {
    public int solve(int[] nums,int target,int idx){
        if(idx==nums.length){
           return target==0?1:0;
        }

        for(int i=idx;i<nums.length;i++){
            target+=nums[i];
            int add=solve(nums,target,idx+1);//Permutation Pattern
            target-=nums[i];

            target-=nums[i];
            int sub=solve(nums,target,idx+1);//Permutation Pattern

            return add+sub;
        }
        return 0;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums,target,0);
    }
}
```

```java


```
