You are given an array of n pairs pairs where pairs[i] = [lefti, righti] and lefti < righti.

A pair p2 = [c, d] follows a pair p1 = [a, b] if b < c. A chain of pairs can be formed in this fashion.

Return the length longest chain which can be formed.

You do not need to use up all the given intervals. You can select pairs in any order.

 

Example 1:

Input: pairs = [[1,2],[2,3],[3,4]]

Output: 2

Explanation: The longest chain is [1,2] -> [3,4].

Example 2:

Input: pairs = [[1,2],[7,8],[4,5]]

Output: 3

Explanation: The longest chain is [1,2] -> [4,5] -> [7,8].
 

Constraints:

- n == pairs.length
- 1 <= n <= 1000
- -1000 <= lefti < righti <= 1000

```java
class Solution {
    public int solve(int[][] pairs,int idx,int lastIdx,int[][] dp){
        if(idx>=pairs.length) return 0;

        if(dp[idx][lastIdx+1]!=-1) return dp[idx][lastIdx+1];

        int skip=solve(pairs,idx+1,lastIdx,dp);
        int take=0;

        if(lastIdx==-1 || pairs[lastIdx][1]<pairs[idx][0]){
            take=1+solve(pairs,idx+1,idx,dp);
        }

        return dp[idx][lastIdx+1]=Math.max(skip,take);
    }
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->a[0]-b[0]);
        int[][] dp=new int[pairs.length+1][pairs.length+2];

        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        return solve(pairs,0,-1,dp);
    }
}
```
