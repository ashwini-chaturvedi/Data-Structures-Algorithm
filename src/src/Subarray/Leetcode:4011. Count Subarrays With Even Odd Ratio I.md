You are given an integer array nums and two integers a and b.

For a subarray, let:

x be the number of even elements.
y be the number of odd elements.
The ratio of even to odd elements in a subarray is defined as x / y, where ratios are compared by their exact rational values.

A subarray is considered valid if:

y > 0, and
x / y <= a / b.
Return the number of valid subarrays in nums.

 

Example 1:

Input: nums = [1,2,1,2], a = 3, b = 2

Output: 7

Explanation:

The following are the valid subarrays:

| Subarray     | Values         | Even Count | Odd Count | Ratio   |
|--------------|----------------|-----------:|----------:|--------:|
| `nums[0..0]` | `[1]`          | 0          | 1         | `0 / 1` |
| `nums[0..1]` | `[1, 2]`       | 1          | 1         | `1 / 1` |
| `nums[0..2]` | `[1, 2, 1]`    | 1          | 2         | `1 / 2` |
| `nums[0..3]` | `[1, 2, 1, 2]` | 2          | 2         | `2 / 2` |
| `nums[1..2]` | `[2, 1]`       | 1          | 1         | `1 / 1` |
| `nums[2..2]` | `[1]`          | 0          | 1         | `0 / 1` |
| `nums[2..3]` | `[1, 2]`       | 1          | 1         | `1 / 1` |

Thus, the number of valid subarrays is 7.

Constraints:

- 1 <= nums.length <= 1000
- 1 <= nums[i] <= 1000
- 1 <= a, b <= 1000

# Solution

## Why Prefix Sum?
- we want to get no. of odd and even number at the index in as less time as possible so we will priorily store the numbers and then use them
```java
class Solution {
 
    public int countRatioSubarrays(int[] nums, int a, int b) {
        
        // Prefix sum for Odd and Even
        int count=0;
        int[] odds=new int[nums.length];
        int[] evens=new int[nums.length];

        odds[0]=nums[0]%2!=0?1:0;
        evens[0]=nums[0]%2==0?1:0;

        for(int i=1;i<nums.length;i++){
            int oddCount=nums[i]%2!=0?1:0;
            int evenCount=nums[i]%2==0?1:0;

            odds[i]=odds[i-1]+oddCount;
            evens[i]=evens[i-1]+evenCount;
        }

        //Generate all the subarrays.
        int i=0;
        while(i<nums.length){
            int j=i;//Didn't remember
            while(j<nums.length){
                int odd = odds[j] - (i > 0 ? odds[i - 1] : 0);
                int even = evens[j] - (i > 0 ? evens[i - 1] : 0);

                double div=even;
                div/=odd;
                double div2=a;
                div2/=b;
        
                if(odd>0 && ((div)<=(div2))){
                    count++;
                }
               
                j++;
            }
            i++;
                        
        }

        return count;
    }
}
```
