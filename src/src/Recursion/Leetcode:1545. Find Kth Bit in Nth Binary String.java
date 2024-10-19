//Time Complexity:O(LogN)
class Solution {

    public char solve(int n, int k) {
        if (n == 1) return '0';

        int length = (1 << n) - 1; //Shifting 1 to the left by n positions is equivalent to calculating 2^n.
        int mid = (length / 2) + 1;

        //1.if the k is smaller then mid which means it should be on the left side of the mid so we just have to recusrively find it
        if (k < mid) {
            // If k is in the left half, recursively find it in Si-1
            return solve(n - 1, k);
        }
        //2.if the k is equal to mid and in mid we always have '1' because it is given in the question.
        else if (k == mid) return '1';
        //3.if the k is greater then mid it will be on the right side
        else {
            //if 'k' is on the right half of the mid then the right half is the reverseInvert of the left half so just find the character on the left half in reverse/backward order and Invert it this will give the same as that on right side.
            char onTheRight = solve(n - 1, length - k + 1);
            return onTheRight == '0' ? '1' : '0';
        }
    }

    public char findKthBit(int n, int k) {
        return solve(n, k);
    }
}


1.int length = (1 << n) - 1:
  The expression int length = (1 << n) - 1 is used to calculate the length of the sequence Si for a given value of n.
  Shifting 1 to the left by n positions is equivalent to calculating 2^𝑛
   For example, 1 << 3 would shift 1 to the left three times, resulting in 2^3=8
2.length - k + 1:
  S1 = "0"
  Si = Si - 1 + "1" + reverse(invert(Si - 1)) for i > 1
  This means the sequence has three parts:
      1.The first part is the original sequence Si-1.
      2.The middle element is always "1".
      3.The last part is the reverse and inverted version of Si-1.
  
=>Why Use length - k + 1?
When searching for the k-th bit, if k is in the right half (i.e., after the middle element), the position in the right half corresponds to some position in the reverse-inverted left half.
To find this corresponding position, we can calculate length - k + 1.
