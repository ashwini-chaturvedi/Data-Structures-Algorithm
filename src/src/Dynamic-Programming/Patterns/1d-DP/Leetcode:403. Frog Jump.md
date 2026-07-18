A frog is crossing a river. The river is divided into some number of units, and at each unit, there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.

Given a list of stones positions (in units) in sorted ascending order, determine if the frog can cross the river by landing on the last stone. Initially, the frog is on the first stone and assumes the first jump must be 1 unit.

If the frog's last jump was k units, its next jump must be either k - 1, k, or k + 1 units. The frog can only jump in the forward direction.

 

Example 1:

Input: stones = [0,1,3,5,6,8,12,17]

Output: true

Explanation: The frog can jump to the last stone by jumping 1 unit to the 2nd stone, then 2 units to the 3rd stone, then 2 units to the 4th stone, then 3 units to the 6th stone, 4 units to the 7th stone, and 5 units to the 8th stone.

# Recursion+ Memoization/ Top-Down
```java
class Solution {
    public boolean solve(int[] stones,Map<Integer,Integer>map,int idx,int lastJump,Boolean[][] dp){
        //if index goes out of bound or lastJump was less than equal to zero means no jump at all.
        if(idx>=stones.length || lastJump<=0) return false;

        //Reached the final stone
        if(idx==stones.length-1) return true;

        if(dp[idx][lastJump]!=null) return dp[idx][lastJump];

        //Determining the next Index where we will find the value means that if there is lastJump so then either can go to lastJump-1 ,lastJump,lastJump+1 so we can only find values equal to stones[idx] and then any of the options would be tested to get the answer.
        int leftJumpIdx=stones[idx]+(lastJump-1);
        int sameJumpIdx=stones[idx]+lastJump;
        int rightJumpIdx=stones[idx]+(lastJump+1);

        boolean left=false;
        boolean same=false;
        boolean right=false;

        //Checking the existence of newJump and getting its index.
        if(map.containsKey(leftJumpIdx)){
            int newIdx=map.get(leftJumpIdx);
            left=solve(stones,map,newIdx,lastJump-1,dp);
        }

        if(map.containsKey(sameJumpIdx)){
            int newIdx=map.get(sameJumpIdx);
            same=solve(stones,map,newIdx,lastJump,dp);
        }

        if(map.containsKey(rightJumpIdx)){
            int newIdx=map.get(rightJumpIdx);
            right=solve(stones,map,newIdx,lastJump+1,dp);
        }

        //returning either true.
        return dp[idx][lastJump]=(left || same || right);

    }
    public boolean canCross(int[] stones) {
        //using map so to get the index of the newStone.
        Map<Integer,Integer>map=new HashMap<>();
        map.put(0,0);
        for(int i=0;i<stones.length;i++){
            map.put(stones[i],i);
        }

        if(stones[0]==0 && stones[1]!=1) return false;

        Boolean[][] dp=new Boolean[stones.length+1][stones.length+1];
        return solve(stones,map,1,1,dp);
    }
}
```
