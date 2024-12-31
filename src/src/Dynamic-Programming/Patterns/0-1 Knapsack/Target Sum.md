```java
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        int sum=0;
        for(int num:nums){
            sum+=num;
        }

        //check if (sum+d)%2!=0 becuase if their sum is odd then there cannot be two partitions.
        //if the sum is less than target then by any chance we cannot achieve target value
        //if the sum+target is less than zero which means that the size will be negative ans hence return 0 because all the Integers in the Array are positive and cannot be made negative
        if((sum+target)%2!=0 || sum<target || sum+target<0) return 0;

        int S1=(sum+target)/2;
        int[][] topDown=new int[n+1][S1+1];

        for(int i=0;i<n+1;i++){
            for(int j=0;j<S1+1;j++){
                if(i==0) topDown[i][j]=0;

                if(j==0) topDown[i][j]=1;
            }
        }

        for(int i=1;i<nums.length+1;i++){
            for(int j=0;j<S1+1;j++){//Start from j==0 because there might be 0 element in the array

                if(nums[i-1]<=j){
                    int include=topDown[i-1][j-nums[i-1]];
                    int exclude=topDown[i-1][j];

                    topDown[i][j]=include+exclude;
                }else{
                    topDown[i][j]=topDown[i-1][j];
                }
            }
        }
        return topDown[n][S1];
    }
}
```
