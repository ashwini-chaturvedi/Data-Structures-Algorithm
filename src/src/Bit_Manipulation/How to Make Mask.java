1.Initialize mask to 0: This will create an integer where all bits are initially set to 0.
  int mask = 0;  // 0000 in binary (for a 4-bit example)

2.Left shift 1 by i: In each iteration, you're shifting 1 by i positions, which sets the bit at position 
   i to 1.
  For example, if i = 0, 1 << 0 will result in 0001 (binary). If i = 1, 1 << 1 will result in 0010 (binary),
   and so on.

3.Bitwise OR (|): You're using the bitwise OR operation to combine the current mask with 1 << i. 
   This ensures that the i-th bit is set in mask, while all other bits remain unchanged.
   For example, if mask is 0000 and 1 << 0 is 0001, then mask | (1 << 0) results in 0001.

4.Loop for multiple bits: By looping through i from 0 to n-1, you are setting all bits from 0 to n-1 to 1 
   in the mask.
   

Here’s the example code again:

   int mask = 0;
   int n = 4;  // You can set this value to whatever number of bits you want
   for (int i = 0; i < n; i++) {
       mask = mask | (1 << i);
   }
Example Output:
For n = 4, the mask would be:

Iteration 0: mask = 0001 (binary for 1)
Iteration 1: mask = 0011 (binary for 3)
Iteration 2: mask = 0111 (binary for 7)
Iteration 3: mask = 1111 (binary for 15)
After the loop completes, the mask will have the first n bits set to 1. For n = 4, the result would be 1111 (binary) or 15 (decimal).

This code correctly generates a bitmask where the first n bits are set to 1.







