Alice and Bob play a game with piles of stones. There are an even number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].

The objective of the game is to end with the most stones. The total number of stones across all the piles is odd, so there are no ties.

Alice and Bob take turns, with Alice starting first. Each turn, a player takes the entire pile of stones either from the beginning or from the end of the row. This continues until there are no more piles left, at which point the person with the most stones wins.

Assuming Alice and Bob play optimally, return true if Alice wins the game, or false if Bob wins.

 

Example 1:

Input: piles = [5,3,4,5]

Output: true

Explanation: 

Alice starts first, and can only take the first 5 or the last 5.
Say she takes the first 5, so that the row becomes [3, 4, 5].
If Bob takes 3, then the board is [4, 5], and Alice takes 5 to win with 10 points.
If Bob takes the last 5, then the board is [3, 4], and Alice takes 4 to win with 9 points.
This demonstrated that taking the first 5 was a winning move for Alice, so we return true.


```java
class Solution {
    public int solve(int[] piles,int low,int high,int[][] memoiz){
        if(low>high) return 0;

        if(low==high) return memoiz[low][high]=piles[low];

        if(memoiz[low][high]!=-1) return memoiz[low][high];

        int takeLow=piles[low]-solve(piles,low+1,high,memoiz);
        int takeHigh=piles[high]-solve(piles,low,high-1,memoiz);

        return memoiz[low][high]=Math.max(takeLow,takeHigh);
    }
    public boolean stoneGame(int[] piles) {
        int[][] memoiz=new int[piles.length+1][piles.length+1];

        for(int[] memo:memoiz){
            Arrays.fill(memo,-1);
        }
        return solve(piles,0,piles.length-1,memoiz)>=0;
    }
}
```
