# Recursion + Memoization
```java
class Solution {
    public long solve(int[] nums,int idx,boolean isEven,long[][] memoiz){
        if(idx==nums.length) return 0;

        int sign=isEven?0:1;//because the memoiz 2d array is long type ,to store boolean type we will use sign to show the signs like if it is even index mark it will 0 and for Odd Mark it with 1.
        if(memoiz[idx][sign]!=-1){
            return memoiz[idx][sign];
        }

        long skip=solve(nums,idx+1,isEven,memoiz);//if we skip the current Element then the Sign remains the Same as Previous
        //Draw the Recursive Tree Diagram to find it.

        int val=nums[idx];//Current Index Value

        if(!isEven){//As we know we have to minus the Odd Index Numbers so if the curr flag is false make the value negative this way it will get subtracted from over all sum
            val=-val;
        }

        long take=val+solve(nums,idx+1,!isEven,memoiz);//When you Include the Element add the value and then change the flag of isEven.

        return memoiz[idx][sign]=Math.max(skip,take);
    }
    public long maxAlternatingSum(int[] nums) {
        //So here we will use a marker 'isEven' which will tell that this Index is Even or Odd and Based on that we will find out answer
        long[][] memoiz=new long[nums.length+1][2];//two Parameters are Changing i.e. idx,isEven

        for(long[] memo:memoiz){
            Arrays.fill(memo,-1);
        }
        return solve(nums,0,true,memoiz);
    }
}
```

# Bottom-Up
```java
class Solution {

    public long maxAlternatingSum(int[] nums) {
        long[][] dp = new long[nums.length + 1][2]; //Each row will save the value and the size of the array when the current element is inserted into it if it becomes even or Odd size.

        for (int i = 1; i < nums.length + 1; i++) {
            long takeEven = dp[i - 1][1] - nums[i - 1];//if we take the Element this will make the array size odd hence dp[i-1][1]-nums[i-1] because for Odd we have to subtract it
            long skipEven = dp[i - 1][0];//if we skip the next Element will still be an Even Index Number
            dp[i][0] = Math.max(takeEven, skipEven);

            long takeOdd = dp[i - 1][0] + nums[i - 1];//if we take the Element this will make the array size even hence dp[i-1][0]+nums[i-1] because for Even we have to Add it
            long skipOdd = dp[i - 1][1];
            
            dp[i][1] = Math.max(takeOdd, skipOdd);
        }

        long evenAns = dp[nums.length][0];
        long oddAns = dp[nums.length][1];
        return Math.max(evenAns, oddAns);
    }
}

```
