1.Take 1 as the initial value. This represents a binary number with only the least significant bit set 
  (i.e., 0001 in binary for 4-bit representation).
2.Left shift (<<) this value by n positions. This moves the bit that was originally set to the n-th position.
3.For example, if n = 2, then:
    int var = 1;
    var = var << n;
    // var will be 1 << 2, which is 4 (binary 0100)

4.Take the number in which you want to set the n-th bit and use the bitwise OR operator (|) to set that bit.
      int number = 5;  // binary 0101
    number = number | var;
    // number will be 0101 | 0100, which is 0101 (no change since the 2nd bit is already set)
