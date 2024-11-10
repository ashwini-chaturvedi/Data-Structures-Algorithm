```java
  public int[] setBitsCount(int[] nums) {
        int[] IthBitSet = new int[32];
        for (int num : nums) {
            int IthBitSet = 0;
            for (int i = 0; i < 32; i++) {
                if (((num >> i) & 1) == 1) {
                    IthBitSet[i]++;
                }
            }
        }
        return IthBitSet;
    }
```
# More
```java
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
```
