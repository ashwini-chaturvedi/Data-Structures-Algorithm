Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:

answer[i] % answer[j] == 0, or
answer[j] % answer[i] == 0
If there are multiple solutions, return any of them.

 

Example 1:

Input: nums = [1,2,3]

Output: [1,2]

Explanation: [1,3] is also accepted.

Example 2:

Input: nums = [1,2,4,8]

Output: [1,2,4,8]
 

Constraints:

- 1 <= nums.length <= 1000
- 1 <= nums[i] <= 2 * 109
- All the integers in nums are unique.

# Recursion + Memoization
```java
class Solution {

    public List<Integer> solve(int[] nums, int idx, int lastIdx,List<Integer>[][] dp) {
        if (idx >= nums.length) return new ArrayList<>();

        if( dp[idx][lastIdx+1]!=null) return dp[idx][lastIdx+1];

        List<Integer> skip = solve(nums, idx + 1, lastIdx,dp);
        List<Integer> take = new ArrayList<>();

        if (lastIdx == -1 || nums[idx] % nums[lastIdx] == 0) {
            take = new ArrayList<>(solve(nums, idx + 1, idx,dp));
            take.add(nums[idx]);
        }

        if (take.size() >= skip.size()) {
            dp[idx][lastIdx+1]= new ArrayList<>(take);
        } else {
            dp[idx][lastIdx+1]= new ArrayList<>(skip);
        }

        return dp[idx][lastIdx+1];
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {      
        List<Integer>[][] dp= new ArrayList[nums.length+1][nums.length+1];

        Arrays.sort(nums);
        return solve(nums, 0, -1,dp);
    }
}

```
