# Firstly Create a Mask with all the Bit set to 1 corresponding to the Bit Length of that Number
# Why Use (1 << bitLength) - 1?
  ## The expression (1 << bitLength) - 1 gives us a mask with only the lowest bitLength bits set to 1, 
  and all higher bits set to 0. This is useful for limiting operations to a specific number of bits.
   ## +-----------------------------------------------------+
   ##   1 << 4  =  10000  (binary for 16)
   ##    (1 << 4) - 1 = 10000 - 1 = 1111  (binary for 15)
   ## +-----------------------------------------------------+
```java
  public int BitFlipper(int num, int bitLength) {
          int bitMask = (1 << bitLength) - 1;
          return num ^ bitMask;
  }

```
