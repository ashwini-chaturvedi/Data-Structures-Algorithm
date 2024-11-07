
# Approach:
   ## For the Result of Bit-wise AND of numbers to be Greater than zero any one of the bit of the binary representation of all the numbers should be set
                                            ### OR
    ## All the numbers should have atleast one Set-Bit which is set in all the numbers to make the Bit-wise AND of the Numbers Greater than zero.
    ## So we will check the every number for having a particular bit set or not and from there we will get the maximum number of candidates which have a particular bit set or not this will give us the Largest Combination having Bit-wise AND greater than Zero.
    
```java
class Solution {
    public int largestCombination(int[] candidates) {
        int result=Integer.MIN_VALUE;

        for(int i=0;i<24;i++){//Candidates can Only have 24 bits 
            int IthSetBit=0;
            for(int j=0;j<candidates.length;j++){//Traversing Over the Candidates Array. 
                int num=candidates[j];
                if(((num>>i)&1)==1){//Check if the ith bit is Set or Not if the ith bit for Current Number is Set then this Number can be in a Combination with others having similar bit set
                    IthSetBit++;
                }
            }
            result=Math.max(result,IthSetBit);//Find the maximum number of candidates that have nth bit set and can for a Combination.
        }
        return result;
    }
}
```
