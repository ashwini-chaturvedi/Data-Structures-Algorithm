Given an integer array height[] where height[i] represents the height of the i-th stair, a frog starts from the first stair and wants to reach the last stair. From any stair i, the frog has two options: it can either jump to the (i+1)th stair or the (i+2)th stair. The cost of a jump is the absolute difference in height between the two stairs. Determine the minimum total cost required for the frog to reach the last stair.

Example:

Input: heights[] = [20, 30, 40, 20]

Output: 20

Explanation:  Minimum cost is incurred when the frog jumps from stair 0 to 1 then 1 to 3:

jump from stair 0 to 1: cost = |30 - 20| = 10

jump from stair 1 to 3: cost = |20 - 30| = 10

Total Cost = 10 + 10 = 20

```java
class Solution {
    int solve(int[] height,int idx,int[] dp){
        
        if(idx>=height.length-1) return 0;
        
        if(dp[idx]!=-1) return dp[idx];
        
        
        int one=Math.abs(height[idx]-height[idx+1])+solve(height,idx+1,dp);
        
        int two=Integer.MAX_VALUE;
        if(idx<height.length-2){
           
            two=Math.abs(height[idx]-height[idx+2])+solve(height,idx+2,dp);
            
        }
        
        return dp[idx]=Math.min(one,two);
        
    }
    int minCost(int[] height) {
        
        int[] dp=new int[height.length+1];
        
        Arrays.fill(dp,-1);
     
        
        return solve(height,0,dp);
        
        
    }
}
```
