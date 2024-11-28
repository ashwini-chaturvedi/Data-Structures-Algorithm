```java
class Solution {
    public int findComplement(int num) {
        // Find the number of bits in 'num'
        int bitLength = Integer.toBinaryString(num).length();
        System.out.println(bitLength);
        
        // Create a mask with all bits set to 1 for the length of 'num'
        int mask = (1 << bitLength) - 1; //1000-1=0111
        System.out.println(mask);
        
        // XOR 'num' with the mask to get the complement
        return num ^ mask;
    }
}

```
