Given two strings s and t, return the number of distinct subsequences of s which equals t.

The test cases are generated so that the answer fits on a 32-bit signed integer.

 

Example 1:

Input: s = "rabbbit", t = "rabbit"
Output: 3
Explanation:
As shown below, there are 3 ways you can generate "rabbit" from s.

rabbbit

rabbbit

rabbbit

# Recursion + Memoization
```java
class Solution {
    public int solve(String s,String t,int idx,int jdx,int[][] memoiz){
        if(jdx==t.length()){
            return 1;
        }
        if(idx==s.length()){
            return 0;
        }

        if(memoiz[idx][jdx]!=-1) return memoiz[idx][jdx];
    

        if(s.charAt(idx)==t.charAt(jdx)){
            int take=solve(s,t,idx+1,jdx+1,memoiz);
            int skip=solve(s,t,idx+1,jdx,memoiz);

            return memoiz[idx][jdx]=take+skip;
        }else{
            return memoiz[idx][jdx]=solve(s,t,idx+1,jdx,memoiz);
        }
    }
    public int numDistinct(String s, String t) {
        int[][] memoiz=new int[s.length()+1][t.length()+1];

        for(int[] memo:memoiz){
            Arrays.fill(memo,-1);
        }
        
        return solve(s,t,0,0,memoiz);
    }
}
```
