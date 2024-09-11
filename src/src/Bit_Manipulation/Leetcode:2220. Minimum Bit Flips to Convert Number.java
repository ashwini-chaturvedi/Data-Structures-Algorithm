------------------------------------->Approach:1(Loop & Right Shift)<------------------------------------------
  #IMPORTANT
  class Solution {

    public int minBitFlips(int start, int goal) {
        int num = start ^ goal;// XOR to find difference
        int count = 0;
        while (num > 0) {
            count += num & 1; //Checks if the least significant bit is set or not
            num >>= 1; //Moves the bit to the right 1 by 1 so that it can become zero and we can count all the set bits
        }
        return count;
    }
}

------------------------------------>Approach:2(Using Built-In Method)<----------------------------------------
  class Solution {
    public int minBitFlips(int start, int goal) {
        int num=start^goal;
        return Integer.bitCount(num);
    }
}
