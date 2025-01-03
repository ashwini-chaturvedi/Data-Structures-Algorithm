```java
class Solution {
    public int waysToSplitArray(int[] nums) {
       

//find prefix sum from starting and ending.
        long[] prefix=new long[nums.length];
        long[] reversePrefix=new long[nums.length];

        prefix[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        
        reversePrefix[nums.length-1]=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            reversePrefix[i]=reversePrefix[i+1]+nums[i];
        }

 int splits=0;
//Now,find the valid Splits on the basis rules given...
        for(int i=0;i<nums.length-1;i++){
            if(prefix[i]>=reversePrefix[i+1]){
                splits++;
            }
        }
        return splits;
    }
}
```


```java
class Solution {
    public int waysToSplitArray(int[] nums) {
        long sum=0;
        for(int num:nums){
            sum+=num;
        }

        int splits=0;
        int i=0;
        long currSum=0;

        while(i<nums.length-1){
            currSum+=nums[i];

            long remaining=sum-currSum;

            if(currSum>=remaining){
                splits++;
            }
            i++;
        }

        return splits;
    }
}

```
