```java
class Solution {
    public int solve(int n,int[] memoiz){
        if(n==0 || n==1) return 1; //Because to climb 0 or 1 stair there is only 1 way

        if(memoiz[n]!=-1){
            return memoiz[n];
        }
        return memoiz[n]=solve(n-1,memoiz) + solve(n-2,memoiz);//can either take 1 or 2 step at a time so it will form a tree because we have options and we have to take Decison based on that options.
    }
    
    public int climbStairs(int n) {
        int[] memoiz=new int[46];
        Arrays.fill(memoiz,-1);
        return solve(n,memoiz);        
    }
}
```
