Given an integer n, return true if it is possible to represent n as the sum of distinct powers of three. Otherwise, return false.

An integer y is a power of three if there exists an integer x such that y == 3x.

 

Example 1:

Input: n = 12
Output: true
Explanation: 12 = 31 + 32
Example 2:

Input: n = 91
Output: true
Explanation: 91 = 30 + 32 + 34
Example 3:

Input: n = 21
Output: false

```java
class Solution {
    public boolean checkPowersOfThree(int n) {
        while(n>0){
            if(n%3==2) return false;//The number can not be represented as a sum of powers of 3 if it's ternary presentation has a 2 in it
            /*Key Idea: Using Base-3 (Ternary) Representation
In base-3 (ternary), every number is written using only the digits 0, 1, and 2. If a number can be expressed as a sum of distinct powers of 3, then its ternary representation must not contain the digit 2. This is because:

Each digit in base-3 represents a coefficient for a power of 3.
If a digit is 0 or 1, it's fine because it means the power of 3 is either not used (0) or used once (1).
If a digit is 2, it means that a certain power of 3 would need to be used twice, which is not allowed. */
            n/=3;
        }
        return true;
    }
}
```
