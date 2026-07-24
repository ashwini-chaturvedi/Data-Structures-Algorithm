You are given an integer array nums of length n, where nums is a permutation of the numbers in the range [1, n].

A XOR triplet is defined as the XOR of three elements nums[i] XOR nums[j] XOR nums[k] where i <= j <= k.

Return the number of unique XOR triplet values from all possible triplets (i, j, k).

 

Example 1:

Input: nums = [1,2]

Output: 2

Explanation:

The possible XOR triplet values are:

(0, 0, 0) → 1 XOR 1 XOR 1 = 1

(0, 0, 1) → 1 XOR 1 XOR 2 = 2

(0, 1, 1) → 1 XOR 2 XOR 2 = 1

(1, 1, 1) → 2 XOR 2 XOR 2 = 2

The unique XOR values are {1, 2}, so the output is 2.

Example 2:

Input: nums = [3,1,2]

Output: 4

Explanation:

The possible XOR triplet values include:

(0, 0, 0) → 3 XOR 3 XOR 3 = 3

(0, 0, 1) → 3 XOR 3 XOR 1 = 1

(0, 0, 2) → 3 XOR 3 XOR 2 = 2

(0, 1, 2) → 3 XOR 1 XOR 2 = 0

The unique XOR values are {0, 1, 2, 3}, so the output is 4.

## Solution:

-  Permutation word is just given to confuse the XOR value is same for permutation including same elements same number of time but different positions

    Idea: 'n' ke value ke nearest power of 2 ki value hi number of distinct element btaengi.i.e n=4 ans=8

    XOR never gives bigger values means XORING never sets a new set bit to the binary Representation.

### Hints:

  - Hint 1
      What is the maximum and minimum value we can obtain using the given numbers?
  - Hint 2
      Can we generate all numbers within that range?
  - Hint 3
      For n >= 3 we can obtain all numbers in [0, 2^(msb(n) + 1) - 1], where msb(n) is the index of the most significant bit in n’s binary representation (i.e., the highest power of 2 less than or equal to n). Handle the case when n <= 2 separately.



```java
class Solution {   
    public int uniqueXorTriplets(int[] nums) {
        
        if(nums.length<=2) return nums.length;

        int msb=0;//Index of Most Significant bit in n
        int n=nums.length;
       
        for(int i=0;i<32;i++){
            int mask=(1<<i);
            int res=(n&mask);

            if(res>=1){
                msb=i;
            }
        }

       int high=(int)(Math.pow(2,(msb+1))-1);

       return high+1;
    }

}
```
