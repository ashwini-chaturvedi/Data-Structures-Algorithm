Given an integer array nums, return the length of the longest strictly increasing 
subsequence.

 

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]

Output: 4

Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

# Recursion + Memoization
```java
class Solution {

    public int LIS(int[] nums, int idx, int prevIdx, int[][] dp) {
        if (idx == nums.length) return 0;


        if ( dp[idx+1][prevIdx+1] != -1) return dp[idx+1][prevIdx+1];

        int exclude = LIS(nums, idx + 1, prevIdx, dp);//exclude the element at this index

        int include = 0;
        if (prevIdx == -1 || nums[idx] > nums[prevIdx]) {//if the element is in Increasing Order.
            include = 1 + LIS(nums, idx + 1, idx, dp);//take it and Increase its count.
        }

        return dp[idx+1][prevIdx+1] = Math.max(include, exclude);//maximum count after including or excluding the current Element.
    }

    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length + 1][nums.length + 1];

        for (int[] memo : dp) {
            Arrays.fill(memo, -1);
        }     
        
        return LIS(nums, 0, -1, dp);
    }
}

```

# Tabulation
```java
public int solveTab(int[] nums){
        int[][] dp=new int[nums.length+1][nums.length+1];

        for(int i=nums.length-1;i>=0;i--){// this represent the index 
            for(int j=i-1;j>=-1;j--){//j represent prevIndex and i cannot be bigger then the current index i.e. i so , j starts from i-1 -> -1. -1 representing the prevIdx of 0 or base case.
                int skip=dp[i+1][j+1];

                int take=0;
                if(j==-1 || nums[i]>nums[j]){
                    take=1+dp[i+1][i+1];

                }

                dp[i][j+1]=Math.max(skip,take);
            }
        }

        return dp[0][0];
    }
```

# Binary Search

```java
public int binarySearch(int[] nums){
        int[] tails=new int[nums.length];
        int size=0;
                                                        
        for(int num:nums){
            int low=0;
            int high=size;

            while(low<high){
                int mid=low+(high-low)/2;

                if(tails[mid]<num){
                    low=mid+1;
                }else{
                    high=mid;
                }

            }

            tails[low]=num;

            if(low==size){
                size++;
            }
            
            
        }


        return size;
    }
```
