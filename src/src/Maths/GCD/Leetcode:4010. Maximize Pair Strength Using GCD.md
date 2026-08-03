You are given an integer array nums.

Choose exactly one pair of distinct indices i and j. The strength of the pair is defined as (nums[i] * nums[j]) / gcd(nums[i], nums[j])2.

Return the maximum strength over all possible pairs.

 

Example 1:

Input: nums = [2,3,5]

Output: 15

Explanation:

Choosing i = 1 and j = 2 gives strength (3 * 5) / gcd(3, 5)2 = 15 / 1 = 15, which is the maximum over all pairs.

```java
class Solution {
    public long gcd(long a,long b){
        if(a<b){
            long temp=a;
            a=b;
            b=temp;
        }

        while(b!=0){
            long temp=b;
            b=a%b;
            a=temp;
        }

        return a;
    }

    //Didn't remember
    public long power(long base, long exp) {
        long result = 1;
    
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result *= base;
            } 
            base *= base;
            exp >>= 1;
        }
    
        return result;
    }
    
    public long maxPairStrength(int[] nums) {
        long strength=0;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                long gcdVal=gcd(nums[i],nums[j]);
                long pro=1L*nums[i]*nums[j];//Handling Overflow

                long sq=power(gcdVal,2);

                long score=pro/sq;

                strength=Math.max(strength,score);
            }
        }

        return strength;
    }
}
```
