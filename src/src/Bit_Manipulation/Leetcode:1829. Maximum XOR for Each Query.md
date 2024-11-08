# Approach:
  ## 1.Take XOR of all the Element of the Array.
  ## 2.Take the XOR with the Removed Element this will remove the contribution of that removedElement from the Overall XOR.
  ## 3.Flip the XOR Result and Store it in the Result Array.
## Note:Why This Maximizes the XOR?
  ## 1.This bitwise inversion creates the largest possible number (within the bit length) that is completely different from xorRes.
  ## 2.This is because each bit position will contribute to the maximum value achievable for that bit length.

```java
class Solution {
    public int BitFlipper(int num, int bitLength) {//Flips the Bit in Given Bit Length
        int bitMask = (1 << bitLength) - 1;
        return num ^ bitMask;
    }
    public int[] getMaximumXor(int[] nums, int maximumBit) {

        int xorRes = nums[0];
        for (int i = 1; i < nums.length; i++) {
            xorRes ^= nums[i];
        }

        int[] result = new int[nums.length];
        int removedElement = 0;
        int toBeRemoveIdx=nums.length-1;
        for (int i = 0; i < nums.length; i++) {
            xorRes ^= removedElement;

            int flippedXorRes = BitFlipper(xorRes, maximumBit);//Flip the Bit in between the Given bitLength.

            result[i] = flippedXorRes;
            //Remove the Element From Last as From question.
            removedElement=nums[toBeRemoveIdx];
            toBeRemoveIdx--;
        }

        return result;
    }
}


```
